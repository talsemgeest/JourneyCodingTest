package com.example.exampleapp.ui.screens.postdetails.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PostDetails(title: String, body: String) {
    Column {
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = body,
            fontSize = 14.sp
        )
    }
}