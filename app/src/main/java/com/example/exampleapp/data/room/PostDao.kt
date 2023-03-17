package com.example.exampleapp.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.exampleapp.data.model.CommentEntity
import com.example.exampleapp.data.model.PostEntity

@Dao
interface PostDao {
    @Query("SELECT * FROM PostEntity")
    suspend fun getPosts(): List<PostEntity>

    @Query("SELECT * FROM PostEntity WHERE id LIKE :id LIMIT 1")
    suspend fun getPost(id: Int): PostEntity


    @Query("SELECT * FROM CommentEntity WHERE post_id LIKE :postId")
    suspend fun getComments(postId: Int): List<CommentEntity>

    @Insert
    suspend fun insertPosts(vararg posts: PostEntity)

    @Insert
    suspend fun insertComments(vararg posts: CommentEntity)
}