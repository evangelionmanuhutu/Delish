package com.delishstudio.delish.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.delishstudio.delish.R
import com.delishstudio.delish.databinding.ActivityCartBinding

@Suppress("DEPRECATION")
class CartActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityCartBinding.inflate(layoutInflater)
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        supportActionBar?.hide()
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()

        mBinding.btBeli.setOnClickListener {

        }

        mBinding.cartBackButton.setOnClickListener {
            onBackPressed()
        }
    }
}