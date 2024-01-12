package com.delishstudio.delish.view.activities.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.delishstudio.delish.R
import com.delishstudio.delish.model.FoodModel
import com.delishstudio.delish.model.OrderedFood
import com.delishstudio.delish.model.UserModel

class OrderedFoodAdapter(val user: UserModel) : RecyclerView.Adapter<OrderedFoodAdapter.FoodHolder>() {

    inner class FoodHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var price: TextView
        var counter: TextView
        var address: TextView
        var incrementBtn: AppCompatButton
        var decrementBtn: AppCompatButton

        init {
            name = itemView.findViewById(R.id.ordered_food_name)
            address = itemView.findViewById(R.id.ordered_food_address)
            price = itemView.findViewById(R.id.ordered_food_price)
            counter = itemView.findViewById(R.id.ordered_counter)
            incrementBtn = itemView.findViewById(R.id.ordered_increment_btn)
            decrementBtn = itemView.findViewById(R.id.ordered_decrement_btn)

            setupButtons()
        }

        private fun setupButtons() {

            incrementBtn.setOnClickListener{
                val currentFood = OrderedFood.foodArray[bindingAdapterPosition]
                currentFood.buyQuantity++
                counter.text = currentFood.buyQuantity.toString()
            }

            decrementBtn.setOnClickListener{
                val currentFood = OrderedFood.foodArray[bindingAdapterPosition]
                if (currentFood.buyQuantity > 0) {
                    currentFood.buyQuantity--
                }
                counter.text = currentFood.buyQuantity.toString()
            }

            /*
            counter.text = currentFood.buyQuantity.toString()

            var i = 0
            var totalBiaya: Int = 0
            for (f in OrderedFood.foodArray) {
                totalBiaya += f.price * f.buyQuantity
                i++
            }
            user.cost = totalBiaya
            */
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHolder {
        return FoodHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_ordered_food_card, parent, false))
    }

    override fun getItemCount(): Int {
        return OrderedFood.foodArray.size
    }

    override fun onBindViewHolder(holder: FoodHolder, position: Int) {
        Log.e("Bind Holder Delish", position.toString())

        val currentFood = OrderedFood.foodArray[position]
        holder.name.text = currentFood.name
        holder.address.text = currentFood.address
        holder.price.text = currentFood.getFormatedPriceString()
        holder.counter.text = currentFood.buyQuantity.toString()
    }
}