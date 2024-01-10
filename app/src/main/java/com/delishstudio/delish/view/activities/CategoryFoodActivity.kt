package com.delishstudio.delish.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.delishstudio.delish.R
import com.delishstudio.delish.model.Food
import com.delishstudio.delish.model.FoodCategory

class CategoryFoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this, R.color.main_col)
        supportActionBar?.hide()
        setContentView(R.layout.activity_order_makanan_berat)

        val recyclerView = findViewById<RecyclerView>(R.id.cat_food_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val foodList = listOf(
            Food("Nasi Padang", 12, 10.000, FoodCategory.MAKANAN_BERAT),
            Food("Donat", 12, 5.000, FoodCategory.CAMILAN),
            Food("Bir", 12, 40.000, FoodCategory.MINUMAN)
        )

        recyclerView.adapter = CategoryFoodAdapter(foodList)
    }
}