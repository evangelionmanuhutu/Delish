package com.delishstudio.delish.view.activities.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.delishstudio.delish.R
import com.delishstudio.delish.model.FoodModel

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
                //addButtonOnClickListener()
            }
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