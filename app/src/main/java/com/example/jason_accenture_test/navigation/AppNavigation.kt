package com.example.jason_accenture_test.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.common.utils.NavRoute
import com.example.feature_list.RepoListRoute
import com.example.feature_list.RepoListViewModel

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
){
    NavHost(navController = navController, startDestination = NavRoute.popularListScreen ){

        composable(NavRoute.popularListScreen){
            val viewModel: RepoListViewModel = hiltViewModel()
            RepoListRoute(viewModel = viewModel){
                navController.navigate(NavRoute.profileScreen)
            }
        }
//
//        composable(NavRoute.profileScreen){
//            val viewModel:ProfileViewModel = hiltViewModel()
//            ProfileRoute(
//                viewModel = viewModel,
//                onPopBack = {navController.popBackStack()}
//            )
//        }
    }
}