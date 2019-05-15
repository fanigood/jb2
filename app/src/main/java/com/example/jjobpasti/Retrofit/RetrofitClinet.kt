package com.example.jjobpasti.Retrofit

import com.example.jjobpasti.MainActivity
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClinet {
    private var OurInstance: Retrofit? = null
    private var BASE_URL="https://jsonplaceholder.typicode.com/"
    val instance: Retrofit
        get() {
            if (OurInstance == null) {

                OurInstance = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()


            }
           return OurInstance!!
        }


}
