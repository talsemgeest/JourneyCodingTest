package com.example.exampleapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CommentEntity (
    @ColumnInfo(name = "body") val body: String,
    @ColumnInfo(name = "email") val email: String,
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "post_id") val postId: Int
)