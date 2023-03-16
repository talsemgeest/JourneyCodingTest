package com.example.exampleapp.ui.screens.postdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exampleapp.data.model.Comment
import com.example.exampleapp.data.model.Post
import com.example.exampleapp.domain.GetComments
import com.example.exampleapp.domain.GetPost
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostDetailsViewModel @Inject constructor(
    private val getPost: GetPost,
    private val getComments: GetComments
) : ViewModel() {
    val state = MutableStateFlow(PostDetailsScreenState())

    fun loadDetails(postId: Int) {
        state.value = state.value.copy(loading = true)
        viewModelScope.launch {
            val post = getPost(postId).getOrNull()
            val comments = getComments(postId).getOrNull()

            if (post == null || comments == null) {
                state.value = state.value.copy(
                    loading = false,
                    error = true,
                )
            } else {
                state.value = state.value.copy(
                    loading = false,
                    error = false,
                    post = post,
                    comments = comments
                )
            }
        }
    }

    data class PostDetailsScreenState(
        val loading: Boolean = true,
        val error: Boolean = false,
        val post: Post? = null,
        val comments: List<Comment> = emptyList()
    )
}