package com.example.exampleapp.data.repository

import com.example.exampleapp.data.model.Comment
import com.example.exampleapp.data.model.Post
import com.example.exampleapp.data.service.ExampleRetrofitService
import javax.inject.Inject

class ExampleRepository @Inject constructor(
    private val service: ExampleRetrofitService
) {

    suspend fun getPosts(): Result<List<Post>> = runCatching {
        service.getPosts()
    }

    suspend fun getPost(id: Int): Result<Post> = runCatching {
        service.getPosts().find { it.id == id }
            ?: throw NoSuchElementException("No post matching postId: $id")
    }

    suspend fun getComments(postId: Int): Result<List<Comment>> = runCatching {
        service.getComments(postId)
    }
}