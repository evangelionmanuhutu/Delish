package com.delishstudio.delish.view.activities

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.delishstudio.delish.R
import com.delishstudio.delish.model.OrderedFood
import com.delishstudio.delish.model.UserModel
import com.delishstudio.delish.view.activities.adapters.OrderedFoodAdapter

class CheckoutActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: OrderedFoodAdapter
    private lateinit var userSample: UserModel
    private var isDialogShown = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        supportActionBar?.hide()
        setContentView(R.layout.activity_checkout)

        userSample = UserModel("Kania", "0812345678")
        userSample.address = "Jl. Kenangan Mantan No.12 Rt.18 Rw.06 Buah Batu, Bandung, Jawa Barat"

        var i = 0
        var totalBiaya: Int = 0
        for (f in OrderedFood.foodArray) {
            totalBiaya += f.price * f.buyQuantity
            i++
        }
        userSample.cost = totalBiaya

        setupAdapter()
        setupUserBindingData()
        setupButtons()
    }

    private fun setupAdapter() {
        recyclerView = findViewById(R.id.checkout_ordered_food_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)

        Log.e("Food Array", OrderedFood.foodArray.size.toString())

        adapter = OrderedFoodAdapter(userSample)
        recyclerView.adapter = adapter
    }

    private fun setupUserBindingData() {
        var userName: TextView = findViewById(R.id.checkout_username)
        var userAddress: TextView = findViewById(R.id.checkout_user_address)
        var userPhone: TextView = findViewById(R.id.checkout_user_phone_number)

        userName.text = userSample.name
        userAddress.text = userSample.address
        userPhone.text = userSample.phoneNumber
    }

    private fun setupButtons() {

        findViewById<AppCompatButton>(R.id.checkout_pesan_sekarang_btn).setOnClickListener {
            setupPesanSekarangBtn()
        }

        findViewById<AppCompatButton>(R.id.checkout_metode_pembayaran_btn).setOnClickListener {
            showMetodePembayaranDialog()
        }
        findViewById<AppCompatButton>(R.id.checkout_pilih_kurir_btn).setOnClickListener() {
            showPilihKurirDialog()
        }
    }

    private fun setupPesanSekarangBtn() {

    }

    private fun showMetodePembayaranDialog() {
        if(isDialogShown) {
            return
        }

        val dialog = Dialog(this)

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.layout_payment_method)

        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        dialog.setOnDismissListener{
            isDialogShown = false
        }

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.attributes?.windowAnimations = R.style.BottomSheetAnimation
        dialog.window?.setGravity(Gravity.BOTTOM)

        dialog.show()
        isDialogShown = true
    }

    private fun showPilihKurirDialog() {
        if(isDialogShown) {
            return
        }

        val dialog = Dialog(this)

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.layout_pilih_kurir)

        val confirmBtn = dialog.findViewById<AppCompatButton>(R.id.konfirmasi_btn)

        confirmBtn.setOnClickListener{
            dialog.dismiss()
        }

        dialog.setOnDismissListener{
            isDialogShown = false
        }

        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        //dialog.window?.attributes?.windowAnimations = R.style.BottomSheetAnimation
        dialog.window?.setGravity(Gravity.CENTER)

        dialog.show()
        isDialogShown = true
    }
}
