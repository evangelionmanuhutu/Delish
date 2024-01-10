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

class CategoryMinumanAdapter(private val foodList: List<Food>) : RecyclerView.Adapter<CategoryMinumanAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.category_minuman_card, parent, false))
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
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.cat_minuman_nama_makanan)
        val quantity = view.findViewById<TextView>(R.id.cat_minuman_quantity)
        val category = view.findViewById<TextView>(R.id.cat_minuman_category)
        val price = view.findViewById<TextView>(R.id.cat_minuman_price)
        val address = view.findViewById<TextView>(R.id.cat_minuman_alamat)
        val distance = view.findViewById<TextView>(R.id.cat_minuman_distance)
        //val ratingNumber = view.findViewById<TextView>(R.id.cat_minuman_rating_number)
    }
}