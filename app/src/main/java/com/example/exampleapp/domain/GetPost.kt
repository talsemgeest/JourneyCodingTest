package com.example.exampleapp.domain

import com.example.exampleapp.data.model.Post
import com.example.exampleapp.data.repository.ExampleRepository
import javax.inject.Inject

class GetPost @Inject constructor(private val repository: ExampleRepository) {

    suspend operator fun invoke(id: Int): Result<Post> {
        return repository.getPost(id)
    }
}