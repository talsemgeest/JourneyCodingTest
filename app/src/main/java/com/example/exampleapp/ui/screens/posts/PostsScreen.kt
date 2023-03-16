package com.example.exampleapp.ui.screens.posts

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.exampleapp.ui.common.ErrorView
import com.example.exampleapp.ui.common.Loading
import com.example.exampleapp.ui.screens.posts.compose.PostRow

@Composable
fun PostsScreen(
    onPostClicked: (postId: Int) -> Unit,
    viewModel: PostsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    when {
        state.loading -> {
            Loading()
        }

        state.error -> {
            ErrorView {
                viewModel.loadPosts()
            }
        }

        else -> {
            LazyColumn {

                items(state.posts, key = { it.id }) {
                    PostRow(post = it, onClick = {
                        onPostClicked(it.id)
                    })
                }
            }
        }
    }
}