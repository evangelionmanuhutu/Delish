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
import androidx.recyclerview.widget.RecyclerView
import com.delishstudio.delish.R
import com.delishstudio.delish.model.FoodModel
import com.delishstudio.delish.model.CategoryModel
import com.delishstudio.delish.model.OrderedFood
import com.delishstudio.delish.view.activities.CheckoutActivity

class FoodAdapter(val foodList: ArrayList<FoodModel>, private val cat: CategoryModel) : RecyclerView.Adapter<FoodAdapter.FoodHolder>() {
    final var m_Category = cat
    inner class FoodHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var quantity: TextView
        var category: TextView
        var price: TextView
        var addButton: AppCompatButton
        var address: TextView
        var distance: TextView
        var bg: ConstraintLayout
        var ratingNumber: TextView

        var isDialogShown = false

        init {
            if (m_Category == CategoryModel.MYSTERY_BOX) {
                name = itemView.findViewById(R.id.mystery_box_nama_makanan)
                quantity = itemView.findViewById(R.id.mystery_box_quantity)
                category = itemView.findViewById(R.id.mystery_box_category)
                price = itemView.findViewById(R.id.mystery_box_price)
                addButton = itemView.findViewById(R.id.mystery_box_add_button)
                address = itemView.findViewById(R.id.mystery_box_alamat)
                distance = itemView.findViewById(R.id.mystery_box_distance)
                bg = itemView.findViewById(R.id.mystery_box_image_frame)
                ratingNumber = itemView.findViewById(R.id.mystery_box_rating_number)
            }
            else {
                name = itemView.findViewById(R.id.cat_food_nama_makanan)
                quantity = itemView.findViewById(R.id.cat_food_quantity)
                category = itemView.findViewById(R.id.cat_food_category)
                price = itemView.findViewById(R.id.cat_food_price)
                addButton = itemView.findViewById(R.id.cat_food_add_button)
                address = itemView.findViewById(R.id.cat_food_alamat)
                distance = itemView.findViewById(R.id.cat_food_distance)
                bg = itemView.findViewById(R.id.cat_food_image_frame)
                ratingNumber = itemView.findViewById(R.id.cat_food_rating_number)
            }

            addButton.setOnClickListener {
                addButtonOnClickListener(itemView.context)
            }
        }

        private fun addButtonOnClickListener(c: Context) {

            // Dialog only shown once
            if (isDialogShown) {
                return
            }

            val dialog = Dialog(c)

            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.layout_sheet_add_food)

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

            dialog.setOnDismissListener {
                isDialogShown = false
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

            isDialogShown = true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHolder {
        var layoutID = 0

        if (m_Category == CategoryModel.MYSTERY_BOX) {
            layoutID = R.layout.layout_mystery_box_card
        }
        else {
            layoutID = R.layout.layout_category_food_card
        }

        return FoodHolder(LayoutInflater.from(parent.context).inflate(layoutID, parent, false))
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
            CategoryModel.MAKANAN_BERAT -> holder.bg.setBackgroundResource(R.drawable.background_light_blue)
            CategoryModel.NON_HALAL -> holder.bg.setBackgroundResource(R.drawable.background_pink)
            CategoryModel.CAMILAN -> holder.bg.setBackgroundResource(R.drawable.background_orange)
            CategoryModel.MINUMAN -> holder.bg.setBackgroundResource(R.drawable.background_pink)
            CategoryModel.BAHAN_MAKANAN -> holder.bg.setBackgroundResource(R.drawable.background_light_blue)
            CategoryModel.VEGAN -> holder.bg.setBackgroundResource(R.drawable.background_orange)
            CategoryModel.MYSTERY_BOX -> holder.bg.setBackgroundResource(R.drawable.background_light_blue)
        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}
