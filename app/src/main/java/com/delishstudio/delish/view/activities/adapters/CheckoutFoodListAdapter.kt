package com.delishstudio.delish.view.activities.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.delishstudio.delish.R
import com.delishstudio.delish.model.User
import com.delishstudio.delish.model.UserModel

// Checkout Food untuk makanan yang ingin dibeli dan juga untuk keranjang
class CheckoutFoodListAdapter(val user: UserModel) : RecyclerView.Adapter<CheckoutFoodListAdapter.FoodHolder>() {

    interface OnUpdateListener {
        fun onUpdate()
    }
    private var onUpdateListener: OnUpdateListener? = null
    fun setOnUpdateListener(listener: OnUpdateListener) {
        onUpdateListener = listener
    }

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
                User.Main.orderedFood[bindingAdapterPosition].buyQuantity++
                User.Main.calculateCost()
                counter.text = User.Main.orderedFood[bindingAdapterPosition].buyQuantity.toString()
                onUpdateListener?.onUpdate() // Notify listener
            }

            decrementBtn.setOnClickListener{
                val currentFood = User.Main.orderedFood[bindingAdapterPosition]
                if (currentFood.buyQuantity > 0) {
                    currentFood.buyQuantity--
                    User.Main.calculateCost()
                }
                // delete food if buy quantity is less than 1
                if (currentFood.buyQuantity < 1) {
                    User.Main.orderedFood.remove(currentFood)
                    Toast.makeText(itemView.context, "${currentFood.name} Food removed", Toast.LENGTH_SHORT).show()
                }
                counter.text = User.Main.orderedFood[bindingAdapterPosition].buyQuantity.toString()
                onUpdateListener?.onUpdate() // Notify listener
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHolder {
        return FoodHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_ordered_food_card, parent, false))
    }

    override fun getItemCount(): Int {
        return  User.Main.orderedFood.size
    }

    override fun onBindViewHolder(holder: FoodHolder, position: Int) {
        val currentFood =  User.Main.orderedFood[position]
        holder.name.text = currentFood.name
        holder.address.text = currentFood.address
        holder.price.text = currentFood.getFormatedPriceString()
        holder.counter.text = currentFood.buyQuantity.toString()
    }
}