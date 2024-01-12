package com.delishstudio.delish.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import com.delishstudio.delish.R
import com.delishstudio.delish.databinding.ActivityCheckoutBinding
import com.delishstudio.delish.databinding.ActivityEditProfileBinding
import com.delishstudio.delish.model.OrderedFood

class CheckoutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCheckoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCheckoutBinding.inflate(layoutInflater)
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        supportActionBar?.hide()
        setContentView(binding.root)

        // TODO: Access ordered food class
        var i = 0
        var totalBiaya = 0
        for (f in OrderedFood.foodArray) {
            Log.e("Ordered Food", i.toString() + " "+ f.name + " buy " + f.buyQuantity)
            totalBiaya += f.price * f.buyQuantity
            i++
        }

        Log.e("Ordered Food", "Rp.$totalBiaya")
    }
}