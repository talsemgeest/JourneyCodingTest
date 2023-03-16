package com.example.exampleapp.ui.screens.postdetails.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CommentView(name: String, body: String) {
    Card(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
    ) {
        Column(modifier = Modifier.padding(horizontal = 8.dp)) {
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = name,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )

            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = body,
                fontSize = 12.sp
            )
        }
    }
}