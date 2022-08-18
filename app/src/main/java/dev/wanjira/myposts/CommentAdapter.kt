package dev.wanjira.myposts

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.wanjira.myposts.databinding.CommentsBinding

class CommentAdapter(var commentList: List<Comment>
) : RecyclerView.Adapter<CommentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder{
        var bindingView = CommentsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentViewHolder(bindingView)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var currentItem = commentList.get(position)

        with(holder.bindingView) {
            tvPostId2.text = currentItem.id.toString()
            tvUserId2.text = currentItem.id.toString()
            tvTitle2.text = currentItem.toString()
            tvBody2.text = currentItem.body

            val context=holder.itemView.context
            cvCons2.setOnClickListener {
                val intent= Intent(context,CommentActivity::class.java)
                intent.putExtra("POST_ID",currentItem.id)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return commentList.size
    }
}

class CommentViewHolder(var bindingView: CommentsBinding) :
    RecyclerView.ViewHolder(bindingView.root) {

}