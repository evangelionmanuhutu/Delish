package com.delishstudio.delish.view.activities.adapters

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.delishstudio.delish.R
import com.delishstudio.delish.model.FoodModel
import com.delishstudio.delish.model.FoodCategory
import com.delishstudio.delish.model.User
import com.delishstudio.delish.view.activities.CheckoutActivity

class CategoryFoodListAdapter(val foodList: ArrayList<FoodModel>, private val cat: FoodCategory) : RecyclerView.Adapter<CategoryFoodListAdapter.FoodHolder>() {

    inner class FoodHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var quantity: TextView
        var category: TextView
        var price: TextView
        var addButton: AppCompatButton
        var address: TextView
        var distance: TextView
        var bg: LinearLayout
        var ratingNumber: TextView
        var isDialogShown = false

        init {
            name = itemView.findViewById(R.id.cat_food_foodname)
            quantity = itemView.findViewById(R.id.cat_food_quantity)
            category = itemView.findViewById(R.id.cat_food_category)
            price = itemView.findViewById(R.id.cat_food_price)
            addButton = itemView.findViewById(R.id.cat_food_add_button)
            address = itemView.findViewById(R.id.cat_food_alamat)
            distance = itemView.findViewById(R.id.cat_food_distance)
            bg = itemView.findViewById(R.id.cat_food_image_frame)
            ratingNumber = itemView.findViewById(R.id.cat_food_rating_number)

            addButton.setOnClickListener {
                addButtonOnClickListener()
            }
        }

        private fun addButtonOnClickListener() {

            // Dialog only shown once
            if (isDialogShown) {
                return
            }

            val dialog = Dialog(itemView.context)

            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.layout_add_food)

            val nama = dialog.findViewById<TextView>(R.id.txtFoodName)
            val price = dialog.findViewById<TextView>(R.id.txtPrice)
            var counter = dialog.findViewById<TextView>(R.id.txtCounter)
            val orderMsg = dialog.findViewById<EditText>(R.id.etRestaurantMsg)
            val increment = dialog.findViewById<AppCompatButton>(R.id.btIncrement)
            val decrement = dialog.findViewById<AppCompatButton>(R.id.btDecrement)
            val orderBtn = dialog.findViewById<AppCompatButton>(R.id.btAddFoodOrder)

            val currentFood = foodList[bindingAdapterPosition]

            if (currentFood.buyQuantity == 0)
                currentFood.buyQuantity++

            nama.text = currentFood.name
            price.text = currentFood.getFormatedPriceString()
            counter.text = currentFood.buyQuantity.toString()
            currentFood.orderMsgToRestaurant = orderMsg.toString()

            increment.setOnClickListener {
                currentFood.buyQuantity++
                counter.text = currentFood.buyQuantity.toString()
            }

            decrement.setOnClickListener{
                if(currentFood.buyQuantity > 0){
                    currentFood.buyQuantity--
                    counter.text = currentFood.buyQuantity.toString()
                }

                if(currentFood.buyQuantity == 0){
                    dialog.dismiss()
                }
            }

            dialog.setOnDismissListener {
                isDialogShown = false
            }

            orderBtn.setOnClickListener{
                User.Main.orderedFood.add(currentFood)
                User.Main.calculateCost()

                val intent = Intent(itemView.context, CheckoutActivity::class.java)
                itemView.context.startActivity(intent)
            }

            dialog.show()
            dialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window?.attributes?.windowAnimations = R.style.BottomSheetAnimation
            dialog.window?.setGravity(Gravity.BOTTOM)

            isDialogShown = true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHolder {
        return FoodHolder(LayoutInflater.from(parent.context).inflate( R.layout.layout_category_food_card, parent, false))
    }

    override fun onBindViewHolder(holder: FoodHolder, position: Int) {
        holder.name.text = foodList[position].name
        holder.price.text = foodList[position].getFormatedPriceString()
        holder.quantity.text = "${foodList[position].availableQua} ${foodList[position].quaUnit}"
        holder.category.text = foodList[position].getCategoryString()
        holder.ratingNumber.text = foodList[position].rating.toString()
        //holder.address.text = foodList[position].address
        holder.distance.text = "${foodList[position].distance} meter"
        when(cat){
            FoodCategory.MAKANAN_BERAT -> holder.bg.setBackgroundResource(R.drawable.background_light_blue)
            FoodCategory.NON_HALAL -> holder.bg.setBackgroundResource(R.drawable.background_pink)
            FoodCategory.CAMILAN -> holder.bg.setBackgroundResource(R.drawable.background_orange)
            FoodCategory.MINUMAN -> holder.bg.setBackgroundResource(R.drawable.background_pink)
            FoodCategory.BAHAN_MAKANAN -> holder.bg.setBackgroundResource(R.drawable.background_light_blue)
            FoodCategory.VEGAN -> holder.bg.setBackgroundResource(R.drawable.background_orange)
            FoodCategory.MYSTERY_BOX -> holder.bg.setBackgroundResource(R.drawable.background_light_blue)
        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}
