package com.delishstudio.delish.model

enum class PaymentMethod {
    Invalid,
    GOPAY,
    LINKAJA,
    MANDIRI,
    BCA,
    BNI,
    SHOPEEPAY,
    QRIS
}

class PaymentUtils() {
    companion object {
        public fun MethodToString(method: PaymentMethod): String {
            when(method){
                PaymentMethod.GOPAY -> return "GOPAY"
                PaymentMethod.LINKAJA -> return "LINKAJA"
                PaymentMethod.MANDIRI -> return "MANDIRI"
                PaymentMethod.BCA -> return "BCA"
                PaymentMethod.BNI -> return "BNI"
                PaymentMethod.SHOPEEPAY -> return "SHOPEEPAY"
                PaymentMethod.QRIS -> return "QRIS"
                else -> {
                    return "Invalid"
                }
            }
        }

        public fun MethodFromString(method: String): PaymentMethod {
            when(method){
                "GOPAY" -> return PaymentMethod.GOPAY
                "LINKAJA" -> return PaymentMethod.LINKAJA
                "MANDIRI" -> return PaymentMethod.MANDIRI
                "BCA" -> return PaymentMethod.BCA
                "BNI" -> return PaymentMethod.BNI
                "SHOPEEPAY" -> return PaymentMethod.SHOPEEPAY
                "QRIS" -> return PaymentMethod.QRIS
                else -> {
                    return PaymentMethod.Invalid
                }
            }
        }
    }


}



