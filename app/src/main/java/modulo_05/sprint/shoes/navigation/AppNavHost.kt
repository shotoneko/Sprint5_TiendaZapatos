package modulo_05.sprint.shoes

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import modulo_05.sprint.shoes.data.shoeItems
import modulo_05.sprint.shoes.shopviews.*
import modulo_05.sprint.shoes.viewmodel.ShopViewModel

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String,
    viewModel: ShopViewModel
    ) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,

        ) {
        composable(NavigationItem.HomeCatalog.route) {
            HomeCatalogView(navController, viewModel)
        }
        composable(
            route = "${NavigationItem.Detail.route}/{shoeItemId}",
            arguments = listOf(navArgument("shoeItemId") { type = NavType.IntType })
        ) {
            backStackEntry ->
            val shoeItemId = backStackEntry.arguments?.getInt("shoeItemId") ?: 0
            val shoeItem = shoeItems.find { it.nameResourceId == shoeItemId } ?: shoeItems[0] // Handle if not found
            DetailView(navController= navController, viewModel = viewModel, shoeItem = shoeItem)
        }
        composable(NavigationItem.ShoppingCart.route) {
            ShoppingCartView(navController = navController, viewModel)
        }
    }
}

//        composable("IMCView/{id}/{name}", arguments = listOf(
//            navArgument("id") { type = NavType.IntType } ,
//            navArgument("name") { type = NavType.StringType }
//
//
//        )) {
//            val id = it.arguments?.getInt("id") ?: 0
//            val name = it.arguments?.getString("name") ?: ""
//            IMCView(navController, viewModel, id, name )
//        }

//        composable(NavigationItem.Detail.route) {
//            DetailView(navController = navController, viewModel)
//        }
