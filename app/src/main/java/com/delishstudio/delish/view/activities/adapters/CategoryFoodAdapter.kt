package com.delishstudio.delish.view.activities.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.delishstudio.delish.R
import com.delishstudio.delish.model.Food
import com.delishstudio.delish.model.FoodCategory
import java.text.NumberFormat
import java.util.Locale

class CategoryFoodAdapter(private val foodList: List<Food>, private val cat: FoodCategory) : RecyclerView.Adapter<CategoryFoodAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.category_food_card, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = foodList[position].getName()

        val formatter = NumberFormat.getInstance(Locale.getDefault())
        val formattedCurrency = formatter.format(foodList[position].getPrice())
        holder.price.text = "Rp.$formattedCurrency"

        holder.quantity.text = foodList[position].getQuantity().toString()
        //holder.distance.text = "${foodList[position].getDistance()} m"

        //holder.ratingNumber.text = foodList[position].getRating().toString()
        holder.category.text = foodList[position].getCategoryString()

        when(cat){
            FoodCategory.MAKANAN_BERAT      -> holder.bg.setBackgroundResource(R.drawable.background_light_blue_left_round_corner)
            FoodCategory.NON_HALAL  -> holder.bg.setBackgroundResource(R.drawable.background_pink_left_round_corner)
            FoodCategory.CAMILAN            -> holder.bg.setBackgroundResource(R.drawable.background_orange_left_round_corner)
            FoodCategory.MINUMAN            -> holder.bg.setBackgroundResource(R.drawable.background_pink_left_round_corner)
            FoodCategory.BAHAN_MAKANAN      -> holder.bg.setBackgroundResource(R.drawable.background_light_blue_left_round_corner)
            FoodCategory.VEGAN      -> holder.bg.setBackgroundResource(R.drawable.background_orange_left_round_corner)
        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.cat_food_nama_makanan)
        val quantity = view.findViewById<TextView>(R.id.cat_food_quantity)
        val category = view.findViewById<TextView>(R.id.cat_food_category)
        val price = view.findViewById<TextView>(R.id.cat_food_price)
        val address = view.findViewById<TextView>(R.id.cat_food_alamat)
        val distance = view.findViewById<TextView>(R.id.cat_food_distance)
        val bg = view.findViewById<ConstraintLayout>(R.id.cat_food_image_frame)
        val ratingNumber = view.findViewById<TextView>(R.id.cat_food_rating_number)
    }
}