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

class CategoryNonHalalActivity:AppCompatActivity() {
    private var foodList: ArrayList<FoodModel> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        supportActionBar?.hide()
        setContentView(R.layout.activity_category_food)

        setupAdapters(FoodCategory.NON_HALAL)
    }

    private fun setupAdapters(cat: FoodCategory) {
        val recyclerView = findViewById<RecyclerView>(R.id.cat_food_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        foodList.add(FoodModel("Babi A", 12, 12000, cat))
        foodList.add(FoodModel("Babi B", 12, 12000, cat))
        foodList.add(FoodModel("Babi C", 12, 12000, cat))
        foodList.add(FoodModel("Babi D", 12, 12000, cat))
        foodList.add(FoodModel("Babi E", 12, 12000, cat))
        foodList.add(FoodModel("Babi F", 12, 12000, cat))
        foodList.add(FoodModel("Babi G", 12, 12000, cat))
        foodList.add(FoodModel("Babi H", 12, 12000, cat))
        foodList.add(FoodModel("Babi I", 12, 12000, cat))
        foodList.add(FoodModel("Babi K", 12, 12000, cat))
        foodList.add(FoodModel("Babi L", 12, 12000, cat))

        val adapter = FoodAdapter(foodList, cat)
        recyclerView.adapter = adapter
    }
}