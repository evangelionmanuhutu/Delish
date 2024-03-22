package com.delishstudio.delish.model

import java.text.NumberFormat
import java.util.Locale

class FoodModel(name: String, availableQua: Int, price: Int, cat: FoodCategory, unit: String = "Porsi"){
    var name: String = name
    var price: Int = price
    var availableQua: Int = availableQua
    lateinit var imgSrc : String
    var distance: Int = 10
    var address: String = "Rumah Makan"
    var rating: Double = 0.0
    var category: FoodCategory = cat
    var quaUnit: String = unit
    var buyQuantity: Int = 0
    lateinit var orderMsgToRestaurant: String

    fun getCategoryString(): String {
        when(category){
            FoodCategory.MAKANAN_BERAT -> return "Makanan Berat"
            FoodCategory.NON_HALAL     -> return "Non Halal"
            FoodCategory.CAMILAN       -> return "Camilan"
            FoodCategory.MINUMAN       -> return "Minuman"
            FoodCategory.BAHAN_MAKANAN -> return "Bahan Makanan"
            FoodCategory.VEGAN         -> return "Vegan"
            FoodCategory.MYSTERY_BOX   -> return "Mystery Box"
            else -> {
                return "Invalid"
            }
        }
    }

    fun getFormatedPriceString(): String {
        val formatter = NumberFormat.getInstance(Locale.getDefault())
        val formattedCurrency = formatter.format(price)
        return "Rp$formattedCurrency"
    }
}
