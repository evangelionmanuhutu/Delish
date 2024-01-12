package com.delishstudio.delish

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.delishstudio.delish.view.fragments.ProfileFragment
import com.delishstudio.delish.view.fragments.HomeFragment
import com.delishstudio.delish.view.fragments.MysteryBoxFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener{menuItem->
            when(menuItem.itemId){
                R.id.navigation_home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.navigation_mystery_box -> {
                    replaceFragment(MysteryBoxFragment())
                    true
                }
                R.id.navigation_transactions -> {
                    Toast.makeText(this, "Transaction clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.navigation_userprofile -> {
                    replaceFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }

        replaceFragment(HomeFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        super.onDestroy()
    }
}