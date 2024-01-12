package com.delishstudio.delish.model

import java.text.NumberFormat
import java.util.Locale

class UserModel(name: String, phone: String) {
    var name: String = name
    var imgSrc: Int = 0
    var phoneNumber: String = phone
    lateinit var address: String
    var cost: Int = 0

    fun getFormattedCost(): String {
        val formatter = NumberFormat.getInstance(Locale.getDefault())
        val formattedCurrency = formatter.format(cost)
        return "Rp$formattedCurrency"
    }
}