package com.delishstudio.delish.model

import java.text.NumberFormat
import java.util.Locale

class FoodModel(name: String, availableQua: Int, price: Int, cat: CategoryModel, unit: String = "Porsi"){
    var name: String = name
    var price: Int = price
    var availableQua: Int = availableQua
    lateinit var imgSrc : String
    var distance: Double = 0.0
    lateinit var address: String
    var rating: Double = 0.0
    var category: CategoryModel = cat
    var quaUnit: String = unit
    var buyQuantity: Int = 0

    fun getCategoryString(): String {
        when(category){
            CategoryModel.MAKANAN_BERAT -> return "Makanan Berat"
            CategoryModel.NON_HALAL     -> return "Non Halal"
            CategoryModel.CAMILAN       -> return "Camilan"
            CategoryModel.MINUMAN       -> return "Minuman"
            CategoryModel.BAHAN_MAKANAN -> return "Bahan Makanan"
            CategoryModel.VEGAN         -> return "Vegan"
            else -> {
                return "Invalid"
            }
        }
    }

    fun getFormatedPriceString(): String {
        val formatter = NumberFormat.getInstance(Locale.getDefault())
        val formattedCurrency = formatter.format(price)
        return "Rp.$formattedCurrency"
    }
}