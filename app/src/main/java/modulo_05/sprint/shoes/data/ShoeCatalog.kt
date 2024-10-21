package modulo_05.sprint.shoes.data

import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes
import modulo_05.sprint.shoes.R


val shoeItems = listOf(
    ShoeItem(
        R.integer.id_1, R.string.zapato_h1, R.drawable.zman1, R.string.precio_h1, R.string.desc_h1, R.string.tallas_h1, R.string.colores_h1
    ), ShoeItem(
        R.integer.id_2, R.string.zapato_h2, R.drawable.zman2, R.string.precio_h2, R.string.desc_h2, R.string.tallas_h1, R.string.colores_h1
    ), ShoeItem(
        R.integer.id_3,  R.string.zapato_h3, R.drawable.zman3, R.string.precio_h3, R.string.desc_h3, R.string.tallas_h1, R.string.colores_h1
    ), ShoeItem(
        R.integer.id_4, R.string.zapato_m1, R.drawable.zd1, R.string.precio_m1, R.string.desc_m1,
        R.string.tallas_h1, R.string.colores_h1
    ), ShoeItem(
        R.integer.id_5, R.string.zapato_m2, R.drawable.zd2, R.string.precio_m2, R.string.desc_m2, R.string.tallas_h1, R.string.colores_h1
    ), ShoeItem(
        R.integer.id_6, R.string.zapato_m3, R.drawable.zd3, R.string.precio_m3, R.string.desc_m3, R.string.tallas_h1, R.string.colores_h1
    ), ShoeItem(
        R.integer.id_7, R.string.zapatilla1, R.drawable.s1, R.string.precio_z1, R.string.desc_z1, R.string.tallas_h1, R.string.colores_h1
    ), ShoeItem(
        R.integer.id_8, R.string.zapatilla2, R.drawable.s2, R.string.precio_z2, R.string.desc_z2, R.string.tallas_h1, R.string.colores_h1
    ), ShoeItem(
        R.integer.id_9, R.string.zapatilla3, R.drawable.s3, R.string.precio_z3, R.string.desc_z3, R.string.tallas_h1, R.string.colores_h1
    )
)

val itemsCatalog = listOf(
    ShoeCategory(
        R.string.manshoes, listOf(
            shoeItems[0],
            shoeItems[1],
            shoeItems[2],

            )
    ), ShoeCategory(
        R.string.womanshoes, listOf(
            shoeItems[3],
            shoeItems[4],
            shoeItems[5],
        )
    ), ShoeCategory(
        R.string.snickers, listOf(
            shoeItems[6],
            shoeItems[7],
            shoeItems[8],
        )
    )
)
data class ShoeCategory(
    @StringRes val categoryResourceId: Int, val shoeItemResources: List<ShoeItem>
)

data class ShoeItem(
    @IntegerRes val idResourceId: Int,
    @StringRes val nameResourceId: Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val priceResourceId: Int,
    @StringRes val descriptionResourceId: Int,
    @StringRes val sizeResourceId: Int,
    @StringRes val colorResourceId: Int

)
