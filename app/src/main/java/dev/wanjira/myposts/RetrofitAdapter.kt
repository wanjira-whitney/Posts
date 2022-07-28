package dev.wanjira.myposts

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.wanjira.myposts.databinding.RetrofitListPostsBinding

class RetrofitAdapter(
    var context: Context, var postList: List<Post>
) : RecyclerView.Adapter<RetrofitViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
        var bindingView =
            RetrofitListPostsBinding.inflate(LayoutInflater.from(context), parent, false)
        return RetrofitViewHolder(bindingView)
    }

    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
        var currentItem = postList.get(position)

        with(holder.bindingView) {
            tvPostId.text = currentItem.id.toString()
            tvUserId.text = currentItem.userId.toString()
            tvTitle.text = currentItem.title
            tvBody.text = currentItem.body
        }

    }

    override fun getItemCount(): Int {
        return postList.size
    }
}

class RetrofitViewHolder(var bindingView: RetrofitListPostsBinding) :
    RecyclerView.ViewHolder(bindingView.root) {

}