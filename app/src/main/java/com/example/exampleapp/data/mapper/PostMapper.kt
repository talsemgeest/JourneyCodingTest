package com.example.exampleapp.data.mapper

import com.example.exampleapp.data.model.Post
import com.example.exampleapp.data.model.PostEntity

fun Post.toPostEntity(): PostEntity {
    return PostEntity(
        body = body,
        id = id,
        title = title,
        userId = userId
    )
}

fun PostEntity.toPost(): Post {
    return Post(
        body = body,
        id = id,
        title = title,
        userId = userId
    )
}