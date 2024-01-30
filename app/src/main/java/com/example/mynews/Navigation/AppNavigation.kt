package com.example.mynews.Navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mynews.Screens.CategoryScreen
import com.example.mynews.Screens.HomeScreen
import com.example.mynews.Screens.StartScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "startscreen" ){
        composable("startscreen"){StartScreen(navController)}
        composable("categoryscreen/{country}",
            arguments = listOf(navArgument("country"){
                type = NavType.StringType
            })
        ){backStackEntry ->
            val country =backStackEntry.arguments?.getString("country") ?:return@composable
            CategoryScreen(navController = navController, country )
        }
        composable("homescreen/{country}/{category}",
            listOf(navArgument("country"){
                type = NavType.StringType
            }, navArgument("category"){
                type = NavType.StringType
            })
        ){ backStackEntry ->
            val country = backStackEntry.arguments?.getString("country") ?: return@composable
            val category = backStackEntry.arguments?.getString("category") ?: return@composable

            HomeScreen( navController, country,category)
        }
    }


}