package dev.wanjira.myposts

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/Posts")
    fun getPosts(): Call<List<Post>>

    @GET("/Posts")
    fun getPostsById(@Path("id") postId: Int): Call<List<Post>>

}

