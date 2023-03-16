package com.example.exampleapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.exampleapp.ui.screens.posts.PostsScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = POSTS_SCREEN) {
        composable(POSTS_SCREEN) {
            PostsScreen(onPostClicked = { postId ->
                navController.navigate("$POST_DETAILS_SCREEN/$postId")
            })
        }

        composable(
            "$POST_DETAILS_SCREEN/{$POST_DETAILS_ID_ARG}",
            arguments = listOf(navArgument(POST_DETAILS_ID_ARG) { type = NavType.IntType })
        ) {
            //TODO Post Details
        }
    }
}

const val POSTS_SCREEN = "posts"
const val POST_DETAILS_SCREEN = "post_details"
const val POST_DETAILS_ID_ARG = "postId"