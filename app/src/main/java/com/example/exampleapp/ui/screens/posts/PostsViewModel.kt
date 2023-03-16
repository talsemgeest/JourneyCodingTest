package com.example.exampleapp.ui.screens.posts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exampleapp.data.model.Post
import com.example.exampleapp.domain.GetPosts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getPosts: GetPosts
) : ViewModel() {
    val state = MutableStateFlow(PostsScreenState())

    init {
        loadPosts()
    }

    fun loadPosts() {
        state.value = state.value.copy(loading = true)

        viewModelScope.launch {
            getPosts().onSuccess {
                state.value = state.value.copy(
                    loading = false,
                    error = false,
                    posts = it
                )
            }.onFailure {
                state.value = state.value.copy(
                    loading = false,
                    error = true
                )
            }
        }
    }

    //TODO add LCE wrapper class and associated helper extensions for better state management
    data class PostsScreenState(
        val loading: Boolean = true,
        val error: Boolean = false,
        val posts: List<Post> = emptyList()
    )
}