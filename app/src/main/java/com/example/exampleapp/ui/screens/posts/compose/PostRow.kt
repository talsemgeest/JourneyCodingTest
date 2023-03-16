package com.example.exampleapp.ui.screens.posts.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.exampleapp.data.model.Post

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostRow(post: Post, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        onClick = onClick
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = post.title
        )
    }
}