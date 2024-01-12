package com.delishstudio.delish.view.activities

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.delishstudio.delish.R
import com.delishstudio.delish.databinding.ActivityCheckoutBinding
import com.delishstudio.delish.model.OrderedFood
import com.delishstudio.delish.model.UserModel

class CheckoutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCheckoutBinding
    private lateinit var userSample: UserModel
    private lateinit var checkoutMsg: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCheckoutBinding.inflate(layoutInflater)
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        supportActionBar?.hide()
        setContentView(binding.root)

        // TODO: Access ordered food class

        userSample = UserModel("Kania", "0812345678")
        userSample.address = "Jl. Kenangan Mantan No.12 Rt.18 Rw.06 Buah Batu, Bandung, Jawa Barat"


        var i = 0
        var totalBiaya = 0
        for (f in OrderedFood.foodArray) {
            Log.e("Ordered Food", i.toString() + " "+ f.name + " buy " + f.buyQuantity)
            totalBiaya += f.price * f.buyQuantity
            i++
        }

        Log.e("Ordered Food", "Rp.$totalBiaya")

        setupButtons()
    }

    private fun setupButtons() {
        binding.checkoutMetodePembayaranBtn.setOnClickListener{
            val dialog = Dialog(this)

            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.layout_sheet_payment_method)

            dialog.show()
            dialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window?.attributes?.windowAnimations = R.style.BottomSheetAnimation
            dialog.window?.setGravity(Gravity.BOTTOM)
        }
    }
}