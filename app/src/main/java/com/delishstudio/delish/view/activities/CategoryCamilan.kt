package com.delishstudio.delish.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.delishstudio.delish.R
import com.delishstudio.delish.model.Food
import com.delishstudio.delish.model.FoodCategory
import com.delishstudio.delish.view.activities.adapters.CategoryFoodAdapter

class CategoryCamilan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        supportActionBar?.hide()
        setContentView(R.layout.activity_category_food)

        val recyclerView = findViewById<RecyclerView>(R.id.cat_food_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val foodList = listOf(
            Food("Taro", 12, 10000, FoodCategory.CAMILAN),
            Food("Taro", 12, 10000, FoodCategory.CAMILAN),
            Food("Taro", 12, 10000, FoodCategory.CAMILAN),
            Food("Taro", 12, 10000, FoodCategory.CAMILAN),
            Food("Taro", 12, 10000, FoodCategory.CAMILAN),
            Food("Taro", 12, 10000, FoodCategory.CAMILAN),
            Food("Taro", 12, 10000, FoodCategory.CAMILAN),
            Food("Taro", 12, 10000, FoodCategory.CAMILAN)
        )

        recyclerView.adapter = CategoryFoodAdapter(foodList, FoodCategory.CAMILAN)
    }
}