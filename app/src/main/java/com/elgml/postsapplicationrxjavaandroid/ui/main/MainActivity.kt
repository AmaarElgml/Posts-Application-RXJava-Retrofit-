package com.elgml.postsapplicationrxjavaandroid.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elgml.postsapplicationrxjavaandroid.R
import com.elgml.postsapplicationrxjavaandroid.adapter.PostsAdapter
import com.elgml.postsapplicationrxjavaandroid.pojo.Post
import com.elgml.postsapplicationrxjavaandroid.viewmodels.PostsViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var postsRecyclerView: RecyclerView
    private lateinit var postsAdapter: PostsAdapter
    private lateinit var postsViewModel: PostsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()

        postsViewModel = ViewModelProvider(this).get(PostsViewModel::class.java)
        postsViewModel.getPosts()
        postsViewModel.postsMutableLiveData.observe(this,
            Observer<List<Post>> {
                postsAdapter.setList(it)
                postsRecyclerView.adapter = postsAdapter

            })
    }

    private fun initRecyclerView() {
        postsRecyclerView = findViewById(R.id.postsRecyclerView)
        postsRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            postsAdapter = PostsAdapter()
        }
    }

    override fun onStop() {
        postsViewModel.clearDisposable()
        super.onStop()
    }
}
