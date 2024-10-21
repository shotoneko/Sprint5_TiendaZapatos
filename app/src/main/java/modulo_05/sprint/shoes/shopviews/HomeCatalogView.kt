package modulo_05.sprint.shoes.shopviews

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import modulo_05.sprint.shoes.MyScaffold
import modulo_05.sprint.shoes.NavigationItem
import modulo_05.sprint.shoes.viewmodel.ShopViewModel
import modulo_05.sprint.shoes.R
import modulo_05.sprint.shoes.data.ShoeCategory
import modulo_05.sprint.shoes.data.ShoeItem
import modulo_05.sprint.shoes.data.itemsCatalog

@Composable
fun HomeCatalogView(navController: NavHostController, viewModel: ShopViewModel) {
    MyScaffold(title = "Home Catalog View", navController = navController, navigationIcon = {
        IconButton(onClick = { /* "Open nav drawer" */ }) {
            Icon(Icons.Filled.Menu, contentDescription = "")
        }
    }, content = { innerPadding ->
        ContentCatalogView(
            innerPadding,
            navController = navController
        )
    }

    )
}

@Composable
fun ContentCatalogView(innerPadding: PaddingValues, navController: NavHostController) {

    LazyColumn(Modifier.padding(top = 80.dp)) {
        items(itemsCatalog) { item -> ListItem(item, navController = navController) }
    }
}

@Composable
fun ListItem(shoeCategory: ShoeCategory, modifier: Modifier = Modifier, navController: NavHostController) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = stringResource(shoeCategory.categoryResourceId),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.colorPrimary)
        )
        Spacer(modifier = modifier.height(8.dp))

        LazyRow {
            items(shoeCategory.shoeItemResources) { items ->
                ShoeCard(items, onClick = {
                    navController.navigate("${NavigationItem.Detail.route}/${items.nameResourceId}")
                })
            }
        }
    }
}

@Composable
fun ShoeCard(shoeItem: ShoeItem, onClick : () -> Unit) {
    Card(
        colors = CardDefaults.cardColors(containerColor =Color.White),
        modifier = Modifier.padding(8.dp).width(200.dp), // Add padding around the card
        onClick = onClick,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp) // Add elevation
    ){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier.size(170.dp, 200.dp),
                painter = painterResource(id = shoeItem.imageResourceId),
                contentScale = ContentScale.Fit,
                contentDescription = stringResource(shoeItem.descriptionResourceId)
            )
            Text(text = stringResource(id = shoeItem.descriptionResourceId))
            Row (modifier =Modifier.padding(end = 8.dp).fillMaxWidth(), horizontalArrangement = Arrangement.End){
                Text(text = stringResource(id = shoeItem.priceResourceId), fontWeight = FontWeight.Bold)
            }

        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ShowCard() {
//    ShoeCard(shoeItem = shoeItems[0])
//}


