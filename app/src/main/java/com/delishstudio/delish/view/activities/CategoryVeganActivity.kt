package com.delishstudio.delish.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.delishstudio.delish.R
import com.delishstudio.delish.model.FoodModel
import com.delishstudio.delish.model.CategoryModel
import com.delishstudio.delish.view.activities.adapters.CategoryFoodAdapter

class CategoryVeganActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        supportActionBar?.hide()
        setContentView(R.layout.activity_category_food)

        val recyclerView = findViewById<RecyclerView>(R.id.cat_food_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val foodList = listOf(
            FoodModel("Sayur A", 12, 10000, CategoryModel.VEGAN),
            FoodModel("Sayur B", 12, 10000, CategoryModel.VEGAN),
            FoodModel("Sayur C", 12, 10000, CategoryModel.VEGAN),
            FoodModel("Sayur D", 12, 10000, CategoryModel.VEGAN),
            FoodModel("Sayur E", 12, 10000, CategoryModel.VEGAN),
            FoodModel("Sayur F", 12, 10000, CategoryModel.VEGAN),
            FoodModel("Sayur G", 12, 10000, CategoryModel.VEGAN),
            FoodModel("Sayur H", 12, 10000, CategoryModel.VEGAN)
        )

        recyclerView.adapter = CategoryFoodAdapter(foodList, CategoryModel.VEGAN)
    }
}