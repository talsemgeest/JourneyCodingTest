package com.example.exampleapp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.exampleapp.data.model.CommentEntity
import com.example.exampleapp.data.model.PostEntity

@Database(entities = [PostEntity::class, CommentEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}