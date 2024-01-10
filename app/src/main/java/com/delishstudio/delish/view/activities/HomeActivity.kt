package com.delishstudio.delish.view.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.delishstudio.delish.R
import com.delishstudio.delish.databinding.ActivityHomeBinding
import com.delishstudio.delish.model.Food
import com.delishstudio.delish.model.FoodCategory

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        window.statusBarColor = ContextCompat.getColor(this, R.color.main_col)
        supportActionBar?.hide()
        setContentView(binding.root)

        super.onCreate(savedInstanceState)

        val recyclerView = findViewById<RecyclerView>(R.id.food_list_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val foods = listOf(
            Food("Nasi Padang", 12, 10000.0, FoodCategory.MAKANAN_BERAT),
            Food("Donat", 12, 5000.0, FoodCategory.CAMILAN),
            Food("Nasi Goreng", 12, 40000.0, FoodCategory.MAKANAN_BERAT),
            Food("Bir", 12, 40000.0, FoodCategory.MINUMAN),
            Food("Coca Cola", 12, 40000.0, FoodCategory.MINUMAN)
        )

        recyclerView.adapter = FoodListAdapter(foods)

        binding.homeMakananBeratBtn.setOnClickListener {
            val intent = Intent(this, CategoryFoodActivity::class.java)
            startActivity(intent)
        }
    }
}