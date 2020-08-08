package com.elgml.postsapplicationrxjavaandroid.data

import com.elgml.postsapplicationrxjavaandroid.pojo.Post
import io.reactivex.Observable
import retrofit2.*
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PostsClient {
    private val API_BASE_URL = "https://jsonplaceholder.typicode.com/"
    private var apiCalls: ApiCalls

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        apiCalls = retrofit.create()
    }

    companion object {
        val INSTANCE = PostsClient()
    }

    fun getAllPosts(): Observable<List<Post>> {
        return apiCalls.getAllPosts()
    }

}