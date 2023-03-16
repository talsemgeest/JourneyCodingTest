package com.example.exampleapp.data.service

import com.example.exampleapp.data.model.Comment
import com.example.exampleapp.data.model.Post
import retrofit2.http.GET
import retrofit2.http.Query

interface ExampleRetrofitService {

    @GET("/posts")
    suspend fun getPosts(): List<Post>

    @GET("/comments")
    suspend fun getComments(@Query("postId") postId: Int): List<Comment>

}