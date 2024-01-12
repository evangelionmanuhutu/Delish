package com.delishstudio.delish.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.delishstudio.delish.R
import com.delishstudio.delish.model.FoodModel
import com.delishstudio.delish.model.CategoryModel
import com.delishstudio.delish.view.activities.adapters.FoodAdapter

class CategoryBahanMakananActivity : AppCompatActivity(){
    private var foodList: ArrayList<FoodModel> = ArrayList()
    private lateinit var adapter: FoodAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        supportActionBar?.hide()
        setContentView(R.layout.activity_category_food)
        setupAdapters(CategoryModel.BAHAN_MAKANAN)
    }

    private fun setupAdapters(cat: CategoryModel) {
        recyclerView = findViewById(R.id.cat_food_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        foodList.add(FoodModel("Tepung A", 12, 10000, cat, "KG"))
        foodList.add(FoodModel("Tepung B", 12, 10000, cat, "KG"))
        foodList.add(FoodModel("Tepung C", 12, 10000, cat, "KG"))
        foodList.add(FoodModel("Tepung D", 12, 10000, cat, "KG"))
        foodList.add(FoodModel("Tepung E", 12, 10000, cat, "KG"))
        foodList.add(FoodModel("Tepung F", 12, 10000, cat, "KG"))
        foodList.add(FoodModel("Tepung G", 12, 10000, cat, "KG"))
        foodList.add(FoodModel("Tepung H", 12, 10000, cat, "KG"))

        adapter = FoodAdapter(foodList, CategoryModel.BAHAN_MAKANAN)

        recyclerView.adapter = adapter
    }

}