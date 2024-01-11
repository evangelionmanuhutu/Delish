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

class CategoryCamilanActivity : AppCompatActivity() {

    private var foodList: ArrayList<FoodModel> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        supportActionBar?.hide()
        setContentView(R.layout.activity_category_food)

        setupAdapters(CategoryModel.CAMILAN)
    }

    private fun setupAdapters(cat: CategoryModel) {
        val recyclerView = findViewById<RecyclerView>(R.id.cat_food_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        foodList.add(FoodModel("Tepung Terigu", 12, 10000, cat))
        val adapter = CategoryFoodAdapter(this, foodList, cat)
        recyclerView.adapter = adapter
    }
}