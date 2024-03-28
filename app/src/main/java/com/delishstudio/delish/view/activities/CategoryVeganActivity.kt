package com.delishstudio.delish.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.delishstudio.delish.R
import com.delishstudio.delish.databinding.ActivityCategoryFoodBinding
import com.delishstudio.delish.model.FoodModel
import com.delishstudio.delish.model.FoodCategory
import com.delishstudio.delish.view.activities.adapters.CategoryFoodListAdapter

class CategoryVeganActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityCategoryFoodBinding

    private var foodList: ArrayList<FoodModel> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        supportActionBar?.hide()
        mBinding = ActivityCategoryFoodBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setupAdapters(FoodCategory.VEGAN)
    }

    private fun setupAdapters(cat: FoodCategory) {
        val recyclerView: RecyclerView = mBinding.rcCategoryFood
        recyclerView.layoutManager = LinearLayoutManager(this)

        foodList.add(FoodModel("Sayur A", 12, 10000, cat))
        foodList.add(FoodModel("Sayur B", 12, 10000, cat))
        foodList.add(FoodModel("Sayur C", 12, 10000, cat))
        foodList.add(FoodModel("Sayur D", 12, 10000, cat))
        foodList.add(FoodModel("Sayur E", 12, 10000, cat))
        foodList.add(FoodModel("Sayur F", 12, 10000, cat))
        foodList.add(FoodModel("Sayur G", 12, 10000, cat))
        foodList.add(FoodModel("Sayur H", 12, 10000, cat))
        foodList.add(FoodModel("Sayur I", 12, 10000, cat))
        foodList.add(FoodModel("Sayur K", 12, 10000, cat))
        foodList.add(FoodModel("Sayur L", 12, 10000, cat))
        foodList.add(FoodModel("Sayur M", 12, 10000, cat))

        val adapter = CategoryFoodListAdapter(foodList, cat)
        recyclerView.adapter = adapter
    }
}