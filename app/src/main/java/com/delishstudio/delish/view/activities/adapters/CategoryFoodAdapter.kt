package com.delishstudio.delish.view.activities.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.delishstudio.delish.R
import com.delishstudio.delish.model.FoodModel
import com.delishstudio.delish.model.CategoryModel
import java.text.NumberFormat
import java.util.Locale

class CategoryFoodAdapter(private val foodList: ArrayList<FoodModel>, private val cat: CategoryModel, private val onClickItem : (FoodModel) -> Unit) : RecyclerView.Adapter<CategoryFoodAdapter.ViewHolder>(){

    private lateinit var addButtonListener: View.OnClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_category_food_card, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.name.text = foodList[position].getName()
        val formatter = NumberFormat.getInstance(Locale.getDefault())
        val formattedCurrency = formatter.format(foodList[position].getPrice())
        holder.price.text = "Rp.$formattedCurrency"

        holder.quantity.text = foodList[position].getQuantity().toString()
        holder.category.text = foodList[position].getCategoryString()

        when(cat){
            CategoryModel.MAKANAN_BERAT      -> holder.bg.setBackgroundResource(R.drawable.background_light_blue)
            CategoryModel.NON_HALAL  -> holder.bg.setBackgroundResource(R.drawable.background_pink)
            CategoryModel.CAMILAN            -> holder.bg.setBackgroundResource(R.drawable.background_orange)
            CategoryModel.MINUMAN            -> holder.bg.setBackgroundResource(R.drawable.background_pink)
            CategoryModel.BAHAN_MAKANAN      -> holder.bg.setBackgroundResource(R.drawable.background_light_blue)
            CategoryModel.VEGAN      -> holder.bg.setBackgroundResource(R.drawable.background_orange)
        }

        holder.addButton.setOnClickListener(addButtonListener)
        onClickItem(foodList[position])
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    fun setAddButtonListener(listener: View.OnClickListener) {
        this.addButtonListener = listener
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.cat_food_nama_makanan)
        val quantity = view.findViewById<TextView>(R.id.cat_food_quantity)
        val category = view.findViewById<TextView>(R.id.cat_food_category)
        val price = view.findViewById<TextView>(R.id.cat_food_price)
        val addButton = view.findViewById<AppCompatButton>(R.id.cat_food_add_button)
        val address = view.findViewById<TextView>(R.id.cat_food_alamat)
        val distance = view.findViewById<TextView>(R.id.cat_food_distance)
        val bg = view.findViewById<ConstraintLayout>(R.id.cat_food_image_frame)
        val ratingNumber = view.findViewById<TextView>(R.id.cat_food_rating_number)
    }
}
