package com.example.jjobpasti.Retrofit

import com.example.jjobpasti.Model.Post
import io.reactivex.Observable
import retrofit2.http.GET
import java.util.*

interface MyApi {

@get:GET("posts")
 val posts:Observable<List<Post>>

}