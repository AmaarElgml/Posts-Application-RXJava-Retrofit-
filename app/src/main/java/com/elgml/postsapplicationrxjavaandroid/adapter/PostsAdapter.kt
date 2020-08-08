package com.elgml.postsapplicationrxjavaandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.elgml.postsapplicationrxjavaandroid.R
import com.elgml.postsapplicationrxjavaandroid.pojo.Post
import kotlinx.android.synthetic.main.post_item.view.*

class PostsAdapter : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {
    private var postsList: List<Post> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViews(postsList[position])
    }

    override fun getItemCount(): Int {
        return postsList.count()
    }

    fun setList(postsList: List<Post>) {
        this.postsList = postsList
        notifyDataSetChanged()
    }

    class ViewHolder constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private val postIdView: TextView = itemView.postId
        private val userIdView: TextView = itemView.userId
        private val titleView: TextView = itemView.title
        private val bodyView: TextView = itemView.body

        fun bindViews(post: Post) {
            postIdView.text = "Post number ${post.id}"
            userIdView.text = "User ${post.userId}"
            titleView.text = post.title
            bodyView.text = post.body
        }
    }

}