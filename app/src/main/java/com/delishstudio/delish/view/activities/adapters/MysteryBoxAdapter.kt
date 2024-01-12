package com.delishstudio.delish.view.activities.adapters

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.delishstudio.delish.R
import com.delishstudio.delish.model.FoodModel
import com.delishstudio.delish.model.OrderedFood
import com.delishstudio.delish.view.activities.CheckoutActivity

class MysteryBoxAdapter(val foodList: ArrayList<FoodModel>) : RecyclerView.Adapter<MysteryBoxAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var quantity: TextView
        var category: TextView
        var price: TextView
        var addButton: AppCompatButton
        var address: TextView
        var distance: TextView
        var bg: ConstraintLayout
        var ratingNumber: TextView

        init {
            name = itemView.findViewById(R.id.mystery_box_nama_makanan)
            quantity = itemView.findViewById(R.id.mystery_box_quantity)
            category = itemView.findViewById(R.id.mystery_box_category)
            price = itemView.findViewById(R.id.mystery_box_price)
            addButton = itemView.findViewById(R.id.mystery_box_add_button)
            address = itemView.findViewById(R.id.mystery_box_alamat)
            distance = itemView.findViewById(R.id.mystery_box_distance)
            bg = itemView.findViewById(R.id.mystery_box_image_frame)
            ratingNumber = itemView.findViewById(R.id.mystery_box_rating_number)

            addButton.setOnClickListener {
                addButtonOnClickListener(itemView.context)
            }
        }

        private fun addButtonOnClickListener(c: Context) {
            val dialog = Dialog(c)

            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.layout_bottom_sheet)

            val nama = dialog.findViewById<TextView>(R.id.bs_nama)
            val price = dialog.findViewById<TextView>(R.id.bs_price)
            var counter = dialog.findViewById<TextView>(R.id.bs_counter)

            val increment = dialog.findViewById<AppCompatButton>(R.id.bs_increment_btn)
            val decrement = dialog.findViewById<AppCompatButton>(R.id.bs_decrement_btn)
            val orderBtn = dialog.findViewById<AppCompatButton>(R.id.bs_tambah_pesanan_btn)

            val currentFood = foodList[bindingAdapterPosition]

            if (currentFood.buyQuantity == 0)
                currentFood.buyQuantity++

            nama.text = currentFood.name
            price.text = currentFood.getFormatedPriceString()
            counter.text = currentFood.buyQuantity.toString()

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

            // Tambah ke keranjang
            orderBtn.setOnClickListener{
                OrderedFood.foodArray.add(currentFood)
                val intent = Intent(c, CheckoutActivity::class.java)
                c.startActivity(intent)
            }

            dialog.show()
            dialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window?.attributes?.windowAnimations = R.style.BottomSheetAnimation
            dialog.window?.setGravity(Gravity.BOTTOM)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_mystery_box_card, parent, false))
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = foodList[position].name
        holder.price.text = foodList[position].getFormatedPriceString()
        holder.quantity.text = "${foodList[position].availableQua} ${foodList[position].quaUnit}"
        holder.category.text = foodList[position].getCategoryString()
        holder.ratingNumber.text = foodList[position].rating.toString()
        //holder.address.text = foodList[position].address
        holder.distance.text = "${foodList[position].distance} meter"
        holder.bg.setBackgroundResource(R.drawable.background_light_blue)
    }
}