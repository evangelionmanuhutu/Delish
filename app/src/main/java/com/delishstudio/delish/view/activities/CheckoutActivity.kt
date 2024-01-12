package com.delishstudio.delish.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.delishstudio.delish.R
import com.delishstudio.delish.model.OrderedFood

class CheckoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        // TODO: Access ordered food class
        for (f in OrderedFood.foodArray) {
            Log.e("Ordered Food", f.name)
        }
    }
}