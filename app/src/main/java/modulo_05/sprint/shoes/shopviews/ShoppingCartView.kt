package modulo_05.sprint.shoes.shopviews

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import modulo_05.sprint.shoes.MyScaffold
import modulo_05.sprint.shoes.data.ShoeItem
import modulo_05.sprint.shoes.data.shoeItems
import modulo_05.sprint.shoes.viewmodel.ShopViewModel
import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.Color

@Composable
fun ShoppingCartView(navController: NavController, viewModel: ShopViewModel){
    MyScaffold(
        title = "Shopping Cart View",
        navController = navController, navigationIcon = {
            IconButton(onClick = { /* "Open nav drawer" */ }) {
                Icon(Icons.Filled.Home, contentDescription = "")
            }
        },
        actions = {
            IconButton(onClick = { viewModel.clearShoppingCart() }) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "Clear Cart", tint = Color.Red)
            }
        }

    ) { innerPadding ->
        ContentShoppingCartView(
            innerPadding = innerPadding,
            navController = navController,
            viewModel = viewModel
        )
    }
}

@Composable
fun  ContentShoppingCartView(innerPadding: PaddingValues, navController: NavController, viewModel: ShopViewModel) {
    //var productoEditado by remember { mutableStateOf<ProductoState?>(null) }
    Column(
        modifier = Modifier
            .fillMaxSize().
            padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()

        ) {
            items(viewModel.shoppingCart) { item ->
                //recuperar item como el entero que se guardo como idResourceID
                val shoeItem = shoeItems.find { it.idResourceId == item }
               // Log.d("Item shopping cart", item.toInt())
                shoeItem?.let {
                    ShoppingCartCard(
                            shoeItem = shoeItem,
                            onEditClick = { },
                            onDeleteClick = {viewModel.removeItemFromShoppingCart(shoeItem.idResourceId) }
                        )
                }
            }
        }
    }
}


@Composable
fun ShoppingCartCard(shoeItem: ShoeItem, onEditClick : () -> Unit, onDeleteClick:()->Unit) {
    Card(
        colors = CardDefaults.cardColors(containerColor =Color.White),
        modifier = Modifier.padding(8.dp).fillMaxWidth(), // Add padding around the card
        onClick = onEditClick,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp) // Add elevation
    ){
        Row(horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier.size(50.dp, 50.dp),
                painter = painterResource(id = shoeItem.imageResourceId),
                contentScale = ContentScale.Fit,
                contentDescription = stringResource(shoeItem.descriptionResourceId)
            )
            Column (modifier =Modifier.padding(end = 8.dp)){
                Text(text = stringResource(id = shoeItem.nameResourceId))
                Text(text = stringResource(id = shoeItem.priceResourceId), fontWeight = FontWeight.Bold)
            }
            // Coloca un Icono de borrar, para cada elemento de la card
            IconButton(onClick = onDeleteClick) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = null)
            }

        }
    }
}




