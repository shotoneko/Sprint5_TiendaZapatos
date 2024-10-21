package modulo_05.sprint.shoes.shopviews

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import modulo_05.sprint.shoes.MyScaffold
import modulo_05.sprint.shoes.NavigationItem
import modulo_05.sprint.shoes.data.ShoeItem
import modulo_05.sprint.shoes.viewmodel.ShopViewModel

@Composable
fun DetailView(navController: NavController, viewModel: ShopViewModel, shoeItem: ShoeItem) {
    MyScaffold(
        title = "Detailed View",
        navController = navController, navigationIcon = {
            IconButton(onClick = { /* "Open nav drawer" */ }) {
                Icon(Icons.Filled.Home, contentDescription = "")
            }
        }, content = { innerPadding ->
            ContentDetailView(
                innerPadding = PaddingValues(top = 180.dp),
                navController = navController,
                shoeItem = shoeItem,
                viewModel = viewModel
            )
        }
    )
}
@Composable
fun ContentDetailView(
    innerPadding: PaddingValues,
    navController: NavController,
    shoeItem: ShoeItem,
    viewModel: ShopViewModel
) {
    ConstraintLayout(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()

    ) {
        val (image, title, description, price, button) = createRefs()

        Image(
            painter = painterResource(id = shoeItem.imageResourceId),
            contentDescription = stringResource(shoeItem.descriptionResourceId),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(170.dp, 200.dp)
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Text(
            text = stringResource(id = shoeItem.nameResourceId), // Assuming you have a nameResourceId
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.constrainAs(title) {
                top.linkTo(image.bottom, margin = 16.dp)
                start.linkTo(parent.start, margin = 16.dp)
            }
        )

        Text(
            text = stringResource(id = shoeItem.descriptionResourceId),
            fontSize = 14.sp,
            modifier = Modifier.constrainAs(description) {
                top.linkTo(title.bottom, margin = 8.dp)
                start.linkTo(parent.start, margin = 16.dp)
            }
        )

        Text(
            text = stringResource(id = shoeItem.priceResourceId),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.constrainAs(price) {
                bottom.linkTo(button.top, margin = 16.dp)
                end.linkTo(parent.end, margin = 16.dp)
            }
        )

        Button(
            onClick = {
                viewModel.addItemToShoppingCart(shoeItem.idResourceId)
                navController.navigate(NavigationItem.ShoppingCart.route)
                      },
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(button) {
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            Text("Add to Shopping Cart")
        }
    }
}

