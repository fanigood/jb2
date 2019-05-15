package com.example.jjobpasti

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ImageView
import android.widget.Toast
import com.example.jjobpasti.Adapter.PostAdapter
import com.example.jjobpasti.Model.Post
import com.example.jjobpasti.Retrofit.MyApi
import com.example.jjobpasti.Retrofit.RetrofitClinet
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    internal lateinit var jsonApi:MyApi
    internal var compositeDisposable = CompositeDisposable()

//    CompositeDisposable compositeDisposable = new CompositeDisposable();;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btpost=findViewById(R.id.btpost) as ImageView
//        init
        val retrofit = RetrofitClinet.instance
        jsonApi = retrofit.create(MyApi::class.java)

        listpost.setHasFixedSize(true)
        listpost.layoutManager=LinearLayoutManager(this)
        fetchData()



       btpost.setOnClickListener {
           Toast.makeText(this,"helow",Toast.LENGTH_LONG).show()

       }

    }

    private fun fetchData() {
       compositeDisposable.add(jsonApi.posts
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                    posts->displayData(posts)
            }, {
              Toast.makeText(this,"Sorry You Signal Error",Toast.LENGTH_LONG).show()

            })

        )


    }

    private fun displayData(posts: List<Post>?) {
    val adapter= PostAdapter(this, (posts as MutableList<Post>?)!!)
        listpost.adapter=adapter



    }
}
