package modulo_05.sprint.shoes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import modulo_05.sprint.shoes.ui.theme.SprintTiendaZapatosTheme
import modulo_05.sprint.shoes.viewmodel.ShopViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: ShopViewModel by viewModels()
        //enableEdgeToEdge()
        setContent {
            SprintTiendaZapatosTheme {
                AppNavHost(
                    navController = rememberNavController(),
                    startDestination = NavigationItem.HomeCatalog.route,
                    viewModel = viewModel)
            }
        }
    }
}
