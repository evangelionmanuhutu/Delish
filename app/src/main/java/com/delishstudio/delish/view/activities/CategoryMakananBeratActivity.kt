package com.delishstudio.delish.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.delishstudio.delish.R
import com.delishstudio.delish.databinding.ActivityCategoryFoodBinding
import com.delishstudio.delish.model.FoodModel
import com.delishstudio.delish.model.FoodCategory
import com.delishstudio.delish.view.activities.adapters.CategoryFoodListAdapter

class CategoryMakananBeratActivity: AppCompatActivity() {
    private lateinit var mBinding: ActivityCategoryFoodBinding
    private var foodList: ArrayList<FoodModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        supportActionBar?.hide()
        mBinding = ActivityCategoryFoodBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setupAdapters(FoodCategory.MAKANAN_BERAT)
    }

    private fun setupAdapters(cat: FoodCategory) {
        val recyclerView: RecyclerView = mBinding.rcCategoryFood
        recyclerView.layoutManager = LinearLayoutManager(this)

        foodList.add(FoodModel("Nasi Padang A", 12, 10000, cat))
        foodList.add(FoodModel("Nasi Padang B", 12, 10000, cat))
        foodList.add(FoodModel("Nasi Padang C", 12, 10000, cat))
        foodList.add(FoodModel("Nasi Padang D", 12, 10000, cat))
        foodList.add(FoodModel("Nasi Padang E", 12, 10000, cat))
        foodList.add(FoodModel("Nasi Padang F", 12, 10000, cat))
        foodList.add(FoodModel("Nasi Padang G", 12, 10000, cat))
        foodList.add(FoodModel("Nasi Padang H", 12, 10000, cat))
        foodList.add(FoodModel("Nasi Padang I", 12, 10000, cat))
        foodList.add(FoodModel("Nasi Padang K", 12, 10000, cat))
        foodList.add(FoodModel("Nasi Padang L", 12, 10000, cat))

        val adapter = CategoryFoodListAdapter(foodList, cat)
        recyclerView.adapter = adapter
    }
}