package com.example.jjobpasti.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import com.example.jjobpasti.Model.Post
import com.example.jjobpasti.R
import java.lang.StringBuilder

class PostAdapter(internal var context: Context, internal var postList:MutableList<Post>)
    :RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PostViewHolder {
        val itemView=LayoutInflater.from(p0.context)
            .inflate(R.layout.cardlist,p0,false)
        return PostViewHolder(itemView)




    }

    override fun getItemCount(): Int {
     return postList.size
     }

    override fun onBindViewHolder(p0: PostViewHolder, p1: Int) {
        p0.txt_like.text=postList[p1].id.toString()
        p0.txt_title.text=postList[p1].title
        p0.txt_post.text=postList[p1].body





    }


}

