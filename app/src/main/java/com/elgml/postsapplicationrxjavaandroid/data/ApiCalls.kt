package com.elgml.postsapplicationrxjavaandroid.data

import com.elgml.postsapplicationrxjavaandroid.pojo.Post
import io.reactivex.Observable
import retrofit2.http.*

interface ApiCalls {

    // Get all posts
    @GET("posts")
    fun getAllPosts():
            Observable<List<Post>>
}