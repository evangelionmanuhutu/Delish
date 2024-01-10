package com.delishstudio.delish.view.activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.delishstudio.delish.R
import com.delishstudio.delish.model.Food

class CategoryFoodAdapter(
    private val m_FoodList: List<Food>

) : RecyclerView.Adapter<CategoryFoodAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryFoodAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.category_food_card, parent, false))
    }

    override fun onBindViewHolder(holder: CategoryFoodAdapter.ViewHolder, position: Int) {
        holder.name.text = m_FoodList[position].getName()
        holder.price.text = java.lang.String("Rp." + m_FoodList[position].getPrice().toString())
        holder.quantity.text = m_FoodList[position].getQuantity().toString()
        holder.address.text = m_FoodList[position].getAddress()
        holder.distance.text = java.lang.String(m_FoodList[position].getDistance().toString() + " m")
        holder.ratingNumber.text = m_FoodList[position].getRating().toString()
        holder.category.text = m_FoodList[position].getCategoryString()
    }

    override fun getItemCount(): Int {
        return m_FoodList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //val image = view.findViewById<ImageView>(R.id.cat_food_image_preview)
        val name = view.findViewById<TextView>(R.id.cat_food_nama_makanan)
        val quantity = view.findViewById<TextView>(R.id.cat_food_quantity)
        val category = view.findViewById<TextView>(R.id.cat_food_quantity)
        //val addButton = view.findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.cat_food_add_button)
        val price = view.findViewById<TextView>(R.id.cat_food_price)
        val address = view.findViewById<TextView>(R.id.cat_food_alamat)
        val distance = view.findViewById<TextView>(R.id.cat_food_distance)
        val ratingNumber = view.findViewById<TextView>(R.id.cat_food_rating_number)

    }
}