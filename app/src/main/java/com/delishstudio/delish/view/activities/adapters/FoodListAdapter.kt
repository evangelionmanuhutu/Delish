package com.delishstudio.delish.view.activities.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.delishstudio.delish.R
import com.delishstudio.delish.model.FoodModel
import java.text.NumberFormat
import java.util.Locale

class FoodListAdapter(val foodList: List<FoodModel>) : RecyclerView.Adapter<FoodListAdapter.ViewHolder>(){

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.food_name)
        val quantity = view.findViewById<TextView>(R.id.food_quantity)
        val category = view.findViewById<TextView>(R.id.food_category)
        val price = view.findViewById<TextView>(R.id.food_price)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_food_list_card, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = foodList[position].name
        holder.price.text = foodList[position].getFormatedPriceString()
        holder.quantity.text = foodList[position].availableQua.toString()
        holder.category.text = foodList[position].getCategoryString()
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}