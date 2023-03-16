package com.example.exampleapp.domain

import com.example.exampleapp.data.model.Post
import com.example.exampleapp.data.repository.ExampleRepository
import javax.inject.Inject

class GetPosts @Inject constructor(private val repository: ExampleRepository) {

    suspend operator fun invoke(): Result<List<Post>> {
        return repository.getPosts()
    }
}