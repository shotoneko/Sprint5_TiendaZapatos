package modulo_05.sprint.shoes

enum class Screen {
    HomeCatalogView,
    DetailView,
    ShoppingCartView,
}
sealed class NavigationItem(val route: String) {
    object HomeCatalog : NavigationItem(Screen.HomeCatalogView.name)
    object Detail : NavigationItem(Screen.DetailView.name)
    object ShoppingCart : NavigationItem(Screen.ShoppingCartView.name)

}