package com.delishstudio.delish.view.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.delishstudio.delish.R
import com.delishstudio.delish.databinding.ActivityHomeBinding
import com.delishstudio.delish.model.Food

class HomeActivity : AppCompatActivity() {

    private var foodList: ArrayList<Food> = ArrayList()

    private var _binding: ActivityHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        foodList.add(Food("Nasi Padang", "Gratis Ongkir | Halal", "Rp.10.000"))
        foodList.add(Food("Donat", "Gratis Ongkir | 12 Porsi", "Rp.7.000"))
        foodList.add(Food("Ayam Lalapan", "Gratis Ongkir", "Rp.15.000"))

        for (food in foodList) {
            val inflater = LayoutInflater.from(this).inflate(R.layout.food_item, null)

            val foodNameTextView = inflater.findViewById<TextView>(R.id.foodNameTextView)
            val foodCategoryTextView = inflater.findViewById<TextView>(R.id.foodCategoryTextView)
            val foodPriceTextView = inflater.findViewById<TextView>(R.id.foodPriceTextView)

            foodNameTextView.text = food.name
            foodCategoryTextView.text = food.category
            foodPriceTextView.text = food.price

            binding.parentLayout.addView(inflater, binding.parentLayout.childCount)
        }
    }
}