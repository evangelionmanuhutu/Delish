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

class CategoryBahanMakananActivity : AppCompatActivity(){
    private lateinit var mBinding: ActivityCategoryFoodBinding
    private var foodList: ArrayList<FoodModel> = ArrayList()
    private lateinit var adapter: CategoryFoodListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        supportActionBar?.hide()
        mBinding = ActivityCategoryFoodBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        setupAdapters(FoodCategory.BAHAN_MAKANAN)
    }

    private fun setupAdapters(cat: FoodCategory) {
        val recyclerView: RecyclerView = mBinding.rcCategoryFood
        recyclerView.layoutManager = LinearLayoutManager(this)

        foodList.add(FoodModel("Tepung A", 12, 10000, cat, "KG"))
        foodList.add(FoodModel("Tepung B", 12, 10000, cat, "KG"))
        foodList.add(FoodModel("Tepung C", 12, 10000, cat, "KG"))
        foodList.add(FoodModel("Tepung D", 12, 10000, cat, "KG"))
        foodList.add(FoodModel("Tepung E", 12, 10000, cat, "KG"))
        foodList.add(FoodModel("Tepung F", 12, 10000, cat, "KG"))
        foodList.add(FoodModel("Tepung G", 12, 10000, cat, "KG"))
        foodList.add(FoodModel("Tepung H", 12, 10000, cat, "KG"))

        adapter = CategoryFoodListAdapter(foodList, FoodCategory.BAHAN_MAKANAN)
        recyclerView.adapter = adapter
    }

}