package com.delishstudio.delish.view.activities.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.delishstudio.delish.R
import com.delishstudio.delish.model.Food
import java.text.NumberFormat
import java.util.Locale

class FoodListAdapter(private val m_FoodList: List<Food>) : RecyclerView.Adapter<FoodListAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.food_list_card, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = m_FoodList[position].getName()

        val formatter = NumberFormat.getInstance(Locale.getDefault())
        val formattedCurrency = formatter.format(m_FoodList[position].getPrice())
        holder.price.text = "Rp.$formattedCurrency"

        holder.quantity.text = m_FoodList[position].getQuantity().toString()
        holder.category.text = m_FoodList[position].getCategoryString()
    }

    override fun getItemCount(): Int {
        return m_FoodList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.food_name)
        val quantity = view.findViewById<TextView>(R.id.food_quantity)
        val category = view.findViewById<TextView>(R.id.food_category)
        val price = view.findViewById<TextView>(R.id.food_price)
    }
}