package com.delishstudio.delish.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.delishstudio.delish.R
import com.delishstudio.delish.model.Food
import com.delishstudio.delish.model.FoodCategory
import com.delishstudio.delish.view.activities.adapters.CategoryMakananBeratAdapter

class CategoryMakananBeratActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        supportActionBar?.hide()
        setContentView(R.layout.activity_category_makanan_berat)

        val recyclerView = findViewById<RecyclerView>(R.id.cat_makanan_berat_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val foodList = listOf(
            Food("Nasi Padang", 12, 10000, FoodCategory.MAKANAN_BERAT),
            Food("Nasi Padang", 12, 10000, FoodCategory.MAKANAN_BERAT),
            Food("Nasi Padang", 12, 10000, FoodCategory.MAKANAN_BERAT),
            Food("Nasi Padang", 12, 10000, FoodCategory.MAKANAN_BERAT),
            Food("Nasi Padang", 12, 10000, FoodCategory.MAKANAN_BERAT),
            Food("Nasi Padang", 12, 10000, FoodCategory.MAKANAN_BERAT),
            Food("Nasi Padang", 12, 10000, FoodCategory.MAKANAN_BERAT),
            Food("Nasi Padang", 12, 10000, FoodCategory.MAKANAN_BERAT)
        )

        recyclerView.adapter = CategoryMakananBeratAdapter(foodList)
    }
}