package com.delishstudio.delish.view.activities.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.delishstudio.delish.R
import com.delishstudio.delish.databinding.ActivityAuthBoardingBinding

class BoardingAuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBoardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBoardingBinding.inflate(layoutInflater)
        window.statusBarColor = ContextCompat.getColor(this, R.color.main_col)
        supportActionBar?.hide()
        setContentView(binding.root)

        binding.btRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}