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
import com.delishstudio.delish.model.FoodCategory
import com.delishstudio.delish.model.FoodModel
import com.delishstudio.delish.view.activities.adapters.CategoryFoodListAdapter

class MysteryBoxFragment : Fragment() {
    private lateinit var mBinding: FragmentMysteryBoxBinding
    private var foodList: ArrayList<FoodModel> = ArrayList()
    private lateinit var adapter: CategoryFoodListAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var view: ConstraintLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inflater.inflate(R.layout.fragment_mystery_box, container, false)
        mBinding = FragmentMysteryBoxBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapters()
    }

    private fun setupAdapters() {
        recyclerView = mBinding.rcMisteryBox
        recyclerView.layoutManager = LinearLayoutManager(activity)

        foodList.add(FoodModel("Random Food", 1, 1000000, FoodCategory.MYSTERY_BOX, "KG"))
        foodList.add(FoodModel("Random Food", 1, 1000000, FoodCategory.MYSTERY_BOX, "KG"))
        foodList.add(FoodModel("Random Food", 1, 1000000, FoodCategory.MYSTERY_BOX, "KG"))
        foodList.add(FoodModel("Random Food", 1, 1000000, FoodCategory.MYSTERY_BOX, "KG"))
        foodList.add(FoodModel("Random Food", 1, 1000000, FoodCategory.MYSTERY_BOX, "KG"))

        adapter = CategoryFoodListAdapter(foodList, FoodCategory.MYSTERY_BOX)
        recyclerView.adapter = adapter
    }
}