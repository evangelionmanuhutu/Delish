package com.delishstudio.delish.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.delishstudio.delish.R
import com.delishstudio.delish.model.FoodModel
import com.delishstudio.delish.model.FoodCategory
import com.delishstudio.delish.view.activities.adapters.FoodAdapter

class CategoryCamilanActivity : AppCompatActivity() {

    private var foodList: ArrayList<FoodModel> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        supportActionBar?.hide()
        setContentView(R.layout.activity_category_food)

        setupAdapters(FoodCategory.CAMILAN)
    }

    private fun setupAdapters(cat: FoodCategory) {
        val recyclerView = findViewById<RecyclerView>(R.id.cat_food_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        foodList.add(FoodModel("Camilan A", 1, 12000, cat))
        foodList.add(FoodModel("Camilan B", 1, 12000, cat))
        foodList.add(FoodModel("Camilan C", 1, 12000, cat))
        foodList.add(FoodModel("Camilan D", 13, 121000, cat))
        foodList.add(FoodModel("Camilan E", 4, 145000, cat))
        foodList.add(FoodModel("Camilan F", 21, 112000, cat))
        foodList.add(FoodModel("Camilan G", 63, 52000, cat))
        foodList.add(FoodModel("Camilan H", 31, 23000, cat))
        foodList.add(FoodModel("Camilan I", 32, 17000, cat))
        foodList.add(FoodModel("Camilan J", 86, 13000, cat))
        val adapter = FoodAdapter(foodList, cat)
        recyclerView.adapter = adapter
    }
}