package com.elgml.postsapplicationrxjavaandroid.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elgml.postsapplicationrxjavaandroid.data.PostsClient
import com.elgml.postsapplicationrxjavaandroid.pojo.Post
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PostsViewModel : ViewModel() {
    var postsMutableLiveData: MutableLiveData<List<Post>> = MutableLiveData()
    private val compositeDisposable = CompositeDisposable()

    fun getPosts() {
        compositeDisposable.add(
            PostsClient.INSTANCE.getAllPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { posts -> postsMutableLiveData.value = posts }
        )
    }

    fun clearDisposable() {
        compositeDisposable.clear()
    }
}