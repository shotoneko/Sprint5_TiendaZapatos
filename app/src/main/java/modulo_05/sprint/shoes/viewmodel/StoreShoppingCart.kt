package modulo_05.sprint.shoes.viewmodel

import android.content.Context
import androidx.datastore.core.DataStore
import kotlinx.coroutines.flow.Flow
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import kotlinx.coroutines.flow.map
class StoreShoppingCart (private val context: Context){

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("ShoppingCart")
        val SHOPPING_CART_KEY = stringPreferencesKey("shopping_cart")
    }
    private val gson = Gson()
    val shoppingCart: Flow<List<Int>> = context.dataStore.data
        .map { preferences ->
            val json = preferences[SHOPPING_CART_KEY] ?: "[]"
            val type = object : TypeToken<List<Int>>() {}.type
            gson.fromJson(json, type)
        }


    suspend fun saveShoppingCart(cart: List<Int>) {
        val json = gson.toJson(cart)
        context.dataStore.edit { preferences ->
            preferences[SHOPPING_CART_KEY] = json
        }
    }
}