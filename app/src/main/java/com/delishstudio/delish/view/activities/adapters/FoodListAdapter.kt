package com.delishstudio.delish.view.activities.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.delishstudio.delish.R
import com.delishstudio.delish.model.FoodModel
import com.delishstudio.delish.view.activities.CheckoutActivity

// FoodList untuk list semua makanan yang ada di aplikasi
class FoodListAdapter(val foodList: List<FoodModel>) : RecyclerView.Adapter<FoodListAdapter.FoodHolder>(){
    private var mConfirm: Boolean = false

    inner class FoodHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var quantity: TextView
        var category: TextView
        var price: TextView
        var buyButton: AppCompatButton

        init {
            name = itemView.findViewById(R.id.food_name)
            quantity = itemView.findViewById(R.id.food_quantity)
            category = itemView.findViewById(R.id.food_category)
            price = itemView.findViewById(R.id.food_price)
            buyButton = itemView.findViewById(R.id.food_buy_btn)

            buyButton.setOnClickListener{
                val intent = Intent(itemView.context, CheckoutActivity::class.java)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHolder {
        return FoodHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_food_list_card, parent, false))
    }

    override fun onBindViewHolder(holder: FoodHolder, position: Int) {
        holder.name.text = foodList[position].name
        holder.price.text = foodList[position].getFormatedPriceString()
        holder.quantity.text = foodList[position].availableQua.toString()
        holder.category.text = foodList[position].getCategoryString()
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}