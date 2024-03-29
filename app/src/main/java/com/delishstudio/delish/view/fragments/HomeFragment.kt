package com.delishstudio.delish.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.delishstudio.delish.R
import com.delishstudio.delish.databinding.FragmentHomeBinding
import com.delishstudio.delish.model.FoodCategory
import com.delishstudio.delish.model.FoodModel
import com.delishstudio.delish.view.activities.CartActivity
import com.delishstudio.delish.view.activities.CategoryBahanMakananActivity
import com.delishstudio.delish.view.activities.CategoryCamilanActivity
import com.delishstudio.delish.view.activities.CategoryMakananBeratActivity
import com.delishstudio.delish.view.activities.CategoryMinumanActivity
import com.delishstudio.delish.view.activities.CategoryNonHalalActivity
import com.delishstudio.delish.view.activities.CategoryVeganActivity
import com.delishstudio.delish.view.activities.adapters.FoodListAdapter
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.food_list_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        val foods = listOf(
            FoodModel("Nasi Padang", 12, 10000, FoodCategory.MAKANAN_BERAT),
            FoodModel("Donat", 12, 5000, FoodCategory.CAMILAN),
            FoodModel("Nasi Goreng", 12, 40000, FoodCategory.MAKANAN_BERAT),
            FoodModel("Bir", 12, 40000, FoodCategory.MINUMAN),
            FoodModel("Coca Cola", 12, 40000, FoodCategory.MINUMAN)
        )

        recyclerView.adapter = FoodListAdapter(foods)
        setupButtons()
    }

    private fun setupButtons() {
        binding.btHeavyFood.setOnClickListener {
            val intent = Intent(activity, CategoryMakananBeratActivity::class.java)
            startActivity(intent)
        }

        binding.btDrinks.setOnClickListener {
            val intent = Intent(activity, CategoryMinumanActivity::class.java)
            startActivity(intent)
        }

        binding.btBeverages.setOnClickListener {
            val intent = Intent(activity, CategoryCamilanActivity::class.java)
            startActivity(intent)
        }

        binding.btVegan.setOnClickListener {
            val intent = Intent(activity, CategoryVeganActivity::class.java)
            startActivity(intent)
        }

        binding.btNonHalal.setOnClickListener {
            val intent = Intent(activity, CategoryNonHalalActivity::class.java)
            startActivity(intent)
        }

        binding.btGroceries.setOnClickListener {
            val intent = Intent(activity, CategoryBahanMakananActivity::class.java)
            startActivity(intent)
        }

        binding.btCart.setOnClickListener {
            val intent = Intent(activity, CartActivity::class.java)
            startActivity(intent)
        }
    }
}