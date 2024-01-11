package com.delishstudio.delish.model

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class FoodModel(name: String, qua: Int, price: Int, cat: CategoryModel){
    private var  m_Name: String = name
    private var m_Price: Int = price
    private var m_Quantity: Int = qua
    private lateinit var m_ImageSrc : String
    private var m_Distance: Double = 0.0
    private lateinit var m_Address: String
    private var m_RatingNumber: Double = 0.0
    private var m_Category: CategoryModel = cat

    fun setAddress(address: String) {
        m_Address = address
    }

    fun setDistance(dist: Double) {
        m_Distance = dist
    }

    fun setRating(rating: Double) {
        m_RatingNumber = rating
    }

    fun setPrice(price: Int){
        m_Price = price
    }

    fun setQuantity(qua: Int) {
        m_Quantity = qua
    }

    fun getCategoryString(): String {
        when(m_Category){
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

    fun getCategory(): CategoryModel {
        return m_Category
    }

    fun getName(): String  {
        return m_Name
    }

    fun getPrice(): Int {
        return m_Price
    }

    fun getQuantity(): Int {
        return m_Quantity
    }

    fun getDistance(): Double {
        return m_Distance
    }
    fun getAddress(): String {
        return m_Address
    }
    fun getRating(): Double {
        return m_RatingNumber
    }
}
