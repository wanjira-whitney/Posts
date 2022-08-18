package dev.wanjira.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dev.wanjira.myposts.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getPosts()
    }

    fun getPosts(){
        val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
        val request = retrofit.getPosts()

        request.enqueue(object: Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful){
                    var posts = response.body()
                    if (posts !=null){
                        displayPosts(posts)
                    }

                }
            }
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(baseContext,t.message, Toast.
                LENGTH_LONG).show()
            }
        })
    }

    fun displayPosts(postList: List<Post>){
        var adapter = RetrofitAdapter(postList)
        binding.rvViews.layoutManager = LinearLayoutManager(this)
        binding.rvViews.adapter = adapter

    }
}