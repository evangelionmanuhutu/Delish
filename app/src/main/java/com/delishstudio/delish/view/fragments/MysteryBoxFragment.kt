package com.delishstudio.delish.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.delishstudio.delish.R
import com.delishstudio.delish.databinding.FragmentMysteryBoxBinding
import com.delishstudio.delish.model.CategoryModel
import com.delishstudio.delish.model.FoodModel
import com.delishstudio.delish.view.activities.adapters.FoodAdapter

class MysteryBoxFragment : Fragment() {
    private lateinit var binding: FragmentMysteryBoxBinding
    private var foodList: ArrayList<FoodModel> = ArrayList()
    private lateinit var adapter: FoodAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var view: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inflater.inflate(R.layout.fragment_mystery_box, container, false)
        binding = FragmentMysteryBoxBinding.inflate(inflater, container, false)
        view = binding.root

        setupAdapters()
        return view
    }

    private fun setupAdapters() {
        recyclerView = view.findViewById(R.id.mystery_box_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        foodList.add(FoodModel("Random Food", 1, 1000000, CategoryModel.MYSTERY_BOX, "KG"))
        foodList.add(FoodModel("Random Food", 1, 1000000, CategoryModel.MYSTERY_BOX, "KG"))
        foodList.add(FoodModel("Random Food", 1, 1000000, CategoryModel.MYSTERY_BOX, "KG"))
        foodList.add(FoodModel("Random Food", 1, 1000000, CategoryModel.MYSTERY_BOX, "KG"))
        foodList.add(FoodModel("Random Food", 1, 1000000, CategoryModel.MYSTERY_BOX, "KG"))

        adapter = FoodAdapter(foodList, CategoryModel.MYSTERY_BOX)
        recyclerView.adapter = adapter
    }
}