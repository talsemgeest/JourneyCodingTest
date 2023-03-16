package com.example.exampleapp.domain

import com.example.exampleapp.data.model.Comment
import com.example.exampleapp.data.repository.ExampleRepository
import javax.inject.Inject

class GetComments @Inject constructor(private val repository: ExampleRepository) {

    suspend operator fun invoke(postId: Int): Result<List<Comment>> {
        return repository.getComments(postId)
    }
}