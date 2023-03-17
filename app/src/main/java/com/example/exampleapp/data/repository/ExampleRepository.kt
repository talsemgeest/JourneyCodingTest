package com.example.exampleapp.data.repository

import com.example.exampleapp.data.mapper.toComment
import com.example.exampleapp.data.mapper.toCommentEntity
import com.example.exampleapp.data.mapper.toPost
import com.example.exampleapp.data.mapper.toPostEntity
import com.example.exampleapp.data.model.Comment
import com.example.exampleapp.data.model.Post
import com.example.exampleapp.data.room.PostDao
import com.example.exampleapp.data.service.ExampleRetrofitService
import javax.inject.Inject

class ExampleRepository @Inject constructor(
    private val service: ExampleRetrofitService,
    private val postDao: PostDao
) {

    suspend fun getPosts(): Result<List<Post>> = runCatching {
        val savedPosts = postDao.getPosts()

        if (savedPosts.isNotEmpty()) {
            return@runCatching savedPosts.map { it.toPost() }
        } else {
            val remotePosts = service.getPosts()
            postDao.insertPosts(
                *remotePosts
                    .map { it.toPostEntity() }
                    .toTypedArray()
            )
            return@runCatching remotePosts
        }
    }

    suspend fun getPost(id: Int): Result<Post> = runCatching {
        postDao.getPost(id).toPost()
    }

    suspend fun getComments(postId: Int): Result<List<Comment>> = runCatching {
        val savedComments = postDao.getComments(postId)

        if (savedComments.isNotEmpty()) {
            return@runCatching savedComments.map { it.toComment() }
        } else {
            val remoteComments = service.getComments(postId)
            postDao.insertComments(
                *remoteComments
                    .map { it.toCommentEntity() }
                    .toTypedArray()
            )
            return@runCatching remoteComments
        }
    }
}