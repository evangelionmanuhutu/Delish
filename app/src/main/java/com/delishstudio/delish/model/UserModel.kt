package com.delishstudio.delish.model

import java.text.NumberFormat
import java.util.Locale

class UserModel(
    var name: String? = null,
    var phone: String? = null,
    var email: String? = null
) {
    var address: String = ""
    var payment: PaymentMethod = PaymentMethod.GOPAY
    var orderedFood: ArrayList<FoodModel> = ArrayList()

    private var totalCost: Float = 0.0f
    fun calculateCost() {
        totalCost = 0.0f
        for (f in orderedFood) {
            totalCost += f.price * f.buyQuantity
        }
    }

    fun getFormattedCost(): String {
        val formatter = NumberFormat.getInstance(Locale.getDefault())
        val formattedCurrency = formatter.format(totalCost)
        return "Rp$formattedCurrency"
    }
}