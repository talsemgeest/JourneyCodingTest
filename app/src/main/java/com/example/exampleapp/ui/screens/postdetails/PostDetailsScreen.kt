package com.example.exampleapp.ui.screens.postdetails

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.exampleapp.R
import com.example.exampleapp.ui.common.ErrorView
import com.example.exampleapp.ui.common.Loading
import com.example.exampleapp.ui.screens.postdetails.compose.CommentView
import com.example.exampleapp.ui.screens.postdetails.compose.PostDetails

@Composable
fun PostDetailsScreen(
    postId: Int,
    viewModel: PostDetailsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(key1 = postId) {
        viewModel.loadDetails(postId)
    }

    when {
        state.loading -> {
            Loading()
        }

        state.error -> {
            ErrorView {
                viewModel.loadDetails(postId)
            }
        }

        else -> {
            LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)) {
                item {
                    state.post?.let {
                        PostDetails(title = it.title, body = it.body)
                    }
                }

                item {
                    Text(
                        modifier = Modifier.padding(top = 24.dp),
                        text = stringResource(id = R.string.comments),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    )
                }

                items(state.comments, key = { it.id }) {
                    CommentView(it.name, it.body)
                }
            }

        }
    }
}