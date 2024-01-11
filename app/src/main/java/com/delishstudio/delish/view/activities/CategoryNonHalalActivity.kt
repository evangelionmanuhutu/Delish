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

class CategoryNonHalalActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        supportActionBar?.hide()
        setContentView(R.layout.activity_category_food)

        val recyclerView = findViewById<RecyclerView>(R.id.cat_food_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val foodList = listOf(
            FoodModel("Babi", 12, 10000, CategoryModel.NON_HALAL),
            FoodModel("Babi", 12, 10000, CategoryModel.NON_HALAL),
            FoodModel("Babi", 12, 10000, CategoryModel.NON_HALAL),
            FoodModel("Babi", 12, 10000, CategoryModel.NON_HALAL),
            FoodModel("Babi", 12, 10000, CategoryModel.NON_HALAL),
            FoodModel("Babi", 12, 10000, CategoryModel.NON_HALAL),
            FoodModel("Babi", 12, 10000, CategoryModel.NON_HALAL),
            FoodModel("Babi", 12, 10000, CategoryModel.NON_HALAL)
        )

        recyclerView.adapter = CategoryFoodAdapter(foodList, CategoryModel.NON_HALAL)
    }
}