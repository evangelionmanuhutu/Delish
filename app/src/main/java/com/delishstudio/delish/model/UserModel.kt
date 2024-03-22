package com.delishstudio.delish.model

import java.text.NumberFormat
import java.util.Locale

class UserModel(
    var name: String? = null,
    var phone: String? = null,
    var email: String? = null
) {
    public var cost: Int = 0
    public var address: String = ""

    fun getFormattedCost(): String {
        val formatter = NumberFormat.getInstance(Locale.getDefault())
        val formattedCurrency = formatter.format(cost)
        return "Rp$formattedCurrency"
    }
}