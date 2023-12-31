package com.delishstudio.delish

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.delishstudio.delish.view.activities.auth.BoardingAuthActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        val intent = Intent(this, BoardingAuthActivity::class.java)
        startActivity(intent)
    }
}