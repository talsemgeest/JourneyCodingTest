package com.example.exampleapp.data.mapper

import com.example.exampleapp.data.model.Comment
import com.example.exampleapp.data.model.CommentEntity

fun Comment.toCommentEntity(): CommentEntity {
    return CommentEntity(
        body = body,
        email = email,
        id = id,
        name = name,
        postId = postId
    )
}

fun CommentEntity.toComment(): Comment {
    return Comment(
        body = body,
        email = email,
        id = id,
        name = name,
        postId = postId
    )
}