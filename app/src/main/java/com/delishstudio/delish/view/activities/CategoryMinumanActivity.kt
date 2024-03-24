package com.delishstudio.delish.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.delishstudio.delish.R
import com.delishstudio.delish.model.FoodModel
import com.delishstudio.delish.model.FoodCategory
import com.delishstudio.delish.view.activities.adapters.CategoryFoodListAdapter

class CategoryMinumanActivity : AppCompatActivity() {
    private var foodList: ArrayList<FoodModel> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        supportActionBar?.hide()
        setContentView(R.layout.activity_category_food)

        setupAdapters(FoodCategory.MINUMAN)
    }

    private fun setupAdapters(cat: FoodCategory) {
        val recyclerView = findViewById<RecyclerView>(R.id.cat_food_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        foodList.add(FoodModel("Minuman A", 1, 12000, cat, "Botol"))
        foodList.add(FoodModel("Minuman B", 1, 12000, cat, "Botol"))
        foodList.add(FoodModel("Minuman C", 1, 12000, cat, "Botol"))
        foodList.add(FoodModel("Minuman D", 13, 121000, cat, "Botol"))
        foodList.add(FoodModel("Minuman E", 4, 145000, cat, "Botol"))
        foodList.add(FoodModel("Minuman F", 21, 112000, cat, "Botol"))
        foodList.add(FoodModel("Minuman G", 63, 52000, cat, "Botol"))
        foodList.add(FoodModel("Minuman H", 31, 23000, cat, "Botol"))
        foodList.add(FoodModel("Minuman I", 32, 17000, cat, "Botol"))
        foodList.add(FoodModel("Minuman J", 86, 13000, cat, "Botol"))

        val adapter = CategoryFoodListAdapter(foodList, cat)
        recyclerView.adapter = adapter
    }
}