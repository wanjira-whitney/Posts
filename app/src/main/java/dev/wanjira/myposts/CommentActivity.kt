package dev.wanjira.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentActivity : AppCompatActivity() {
    var postId=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)
    }
    fun obtainPostId(){
        postId=intent.extras?.getInt("POST_ID") ?:0
    }

    fun fetchPost() {
        var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getPostsById(postId)
        request.enqueue(object : Callback<Post> {

            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                TODO("Not yet implemented")
            }
        }  )      }

    
}