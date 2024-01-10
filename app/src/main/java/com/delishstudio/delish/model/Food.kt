package com.delishstudio.delish.model

import androidx.appcompat.widget.AppCompatButton

class Food(name: String, qua: Int, price: Double, cat: FoodCategory){
    private var  m_Name: String = name
    private var m_Price: Double = price
    private var m_Quantity: Int = qua
    private lateinit var m_ImageSrc : String
    private lateinit var m_BuyButton: AppCompatButton
    private var m_Distance: Double = 0.0
    private lateinit var m_Address: String
    private var m_RatingNumber: Double = 0.0
    private var m_Category: FoodCategory = cat

    fun setAddress(address: String) {
        m_Address = address
    }

    fun setDistance(dist: Double) {
        m_Distance = dist
    }

    fun setRating(rating: Double) {
        m_RatingNumber = rating
    }

    fun setPrice(price: Double){
        m_Price = price
    }

    fun setQuantity(qua: Int) {
        m_Quantity = qua
    }

    fun getCategoryString(): String {
        when(m_Category){
            FoodCategory.MAKANAN_BERAT      -> return "Makanan Berat"
            FoodCategory.MAKANAN_NON_HALAL  -> return "Makanan Non Halal"
            FoodCategory.CAMILAN            -> return "Camilan"
            FoodCategory.MINUMAN            -> return "Minuman"
            FoodCategory.BAHAN_MAKANAN      -> return "Bahan Makanan"
            FoodCategory.MAKANAN_VEGAN      -> return "Makanan Vegan"
            else -> {
                return "Invalid"
            }
        }
        return "Invalid"
    }

    fun getCategory(): FoodCategory {
        return m_Category
    }

    fun getName(): String  {
        return m_Name
    }

    fun getPrice(): Double {
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
