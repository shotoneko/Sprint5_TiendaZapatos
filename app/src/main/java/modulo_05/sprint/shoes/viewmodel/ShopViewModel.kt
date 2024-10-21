package modulo_05.sprint.shoes.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.first

class ShopViewModel(application: Application) : AndroidViewModel(application) {

    private val storeShoppingCart = StoreShoppingCart(application)
    var shoppingCart = mutableStateListOf<Int>()
        private set
    init {
        viewModelScope.launch {
            shoppingCart.addAll(storeShoppingCart.shoppingCart.first())
        }
    }
    fun addItemToShoppingCart(idResourceId: Int) {
        shoppingCart.add(idResourceId)
        viewModelScope.launch {
            storeShoppingCart.saveShoppingCart(shoppingCart)
        }
    }
    // agrega funcion para eliminar item del carrito
    fun removeItemFromShoppingCart(idResourceId: Int) {
        shoppingCart.remove(idResourceId)
        viewModelScope.launch {
            storeShoppingCart.saveShoppingCart(shoppingCart)
        }
    }
    //implementar funcion para limpiar carrito
    fun clearShoppingCart() {
        shoppingCart.clear()
        viewModelScope.launch {
            storeShoppingCart.saveShoppingCart(shoppingCart)
        }
    }



//
//    fun addItemToShoppingCart(idResourceId: Int) {
//        shoppingCart += idResourceId
//    }

}