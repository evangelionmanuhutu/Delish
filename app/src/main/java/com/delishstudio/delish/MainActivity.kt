package com.delishstudio.delish

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.delishstudio.delish.databinding.ActivityMainBinding
import com.delishstudio.delish.utils.ActivityUtils
import com.delishstudio.delish.view.fragments.ProfileFragment
import com.delishstudio.delish.view.fragments.HomeFragment
import com.delishstudio.delish.view.fragments.MysteryBoxFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        bottomNavigation()

        if (savedInstanceState == null) {
            ActivityUtils.navigateToFragment(this, HomeFragment())
        }
    }

    private fun bottomNavigation() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener{menuItem->
            when(menuItem.itemId){
                R.id.navigation_home -> {
                    ActivityUtils.navigateToFragment(this, HomeFragment())
                    true
                }
                R.id.navigation_mystery_box -> {
                    ActivityUtils.navigateToFragment(this, MysteryBoxFragment())
                    true
                }
                R.id.navigation_transactions -> {
                    Toast.makeText(this, "Transaction clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.navigation_userprofile -> {
                    ActivityUtils.navigateToFragment(this, ProfileFragment())
                    true
                }
                else -> false
            }
        }
    }

    override fun onBackPressed() {
        @Suppress("DEPRECATION")
        super.onBackPressed()
        super.onDestroy()
    }
}