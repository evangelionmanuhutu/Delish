package com.delishstudio.delish.view.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.delishstudio.delish.R
import com.delishstudio.delish.databinding.ActivityHomeBinding
import com.delishstudio.delish.model.FoodModel
import com.delishstudio.delish.model.CategoryModel
import com.delishstudio.delish.view.activities.adapters.FoodListAdapter

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        window.statusBarColor = ContextCompat.getColor(this, R.color.main_col)
        supportActionBar?.hide()
        setContentView(binding.root)

        super.onCreate(savedInstanceState)

        val recyclerView = findViewById<RecyclerView>(R.id.food_list_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val foods = listOf(
            FoodModel("Nasi Padang", 12, 10000, CategoryModel.MAKANAN_BERAT),
            FoodModel("Donat", 12, 5000, CategoryModel.CAMILAN),
            FoodModel("Nasi Goreng", 12, 40000, CategoryModel.MAKANAN_BERAT),
            FoodModel("Bir", 12, 40000, CategoryModel.MINUMAN),
            FoodModel("Coca Cola", 12, 40000, CategoryModel.MINUMAN)
        )

        recyclerView.adapter = FoodListAdapter(foods)

        setupButtons()
    }

    override fun onBackPressed() {
        super.finishAffinity();
    }

    private fun setupButtons() {
        binding.makananBeratBtn.setOnClickListener {
            val intent = Intent(this, CategoryMakananBeratActivity::class.java)
            startActivity(intent)
        }

        binding.minumanBtn.setOnClickListener {
            val intent = Intent(this, CategoryMinumanActivity::class.java)
            startActivity(intent)
        }

        binding.camilanBtn.setOnClickListener {
            val intent = Intent(this, CategoryCamilan::class.java)
            startActivity(intent)
        }

        binding.makananVeganBtn.setOnClickListener {
            val intent = Intent(this, CategoryVeganActivity::class.java)
            startActivity(intent)
        }

        binding.makananNonHalalBtn.setOnClickListener {
            val intent = Intent(this, CategoryNonHalalActivity::class.java)
            startActivity(intent)
        }

        binding.bahanMakananBtn.setOnClickListener {
            val intent = Intent(this, CategoryBahanMakanan::class.java)
            startActivity(intent)
        }

        binding.cartBtn.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }
    }
}
