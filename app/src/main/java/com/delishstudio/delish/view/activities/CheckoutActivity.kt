package com.delishstudio.delish.view.activities

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.delishstudio.delish.R
import com.delishstudio.delish.databinding.ActivityCheckoutBinding
import com.delishstudio.delish.model.User
import com.delishstudio.delish.view.activities.adapters.CheckoutFoodListAdapter

class CheckoutActivity : AppCompatActivity(), CheckoutFoodListAdapter.OnUpdateListener {

    private lateinit var mBinding: ActivityCheckoutBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CheckoutFoodListAdapter
    private var isDialogShown = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        supportActionBar?.hide()
        mBinding = ActivityCheckoutBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setupAdapter()
        setupUserBindingData()
        onSetupButtons()
    }

    private fun setupAdapter() {
        recyclerView = mBinding.checkoutOrderedFoodRecyclerview
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = CheckoutFoodListAdapter(User.Main)
        adapter.setOnUpdateListener(this)
        recyclerView.adapter = adapter
    }

    override fun onUpdate() {
        val totalCostTextView: TextView = findViewById(R.id.checkout_total_cost)
        totalCostTextView.text = User.Main.getFormattedCost()
    }

    private fun setupUserBindingData() {
        var userName: TextView = findViewById(R.id.checkout_username)
        var userAddress: TextView = findViewById(R.id.checkout_user_address)
        var userPhone: TextView = findViewById(R.id.checkout_user_phone_number)
        var totalCost: TextView = findViewById(R.id.checkout_total_cost)

        userName.text = User.Main.name
        userPhone.text = User.Main.phone
        userAddress.text = User.Main.address
        totalCost.text = User.Main.getFormattedCost()
    }

    private fun onSetupButtons() {
        mBinding.checkoutPesanSekarangBtn.setOnClickListener {
            setupPesanSekarangBtn()
        }
        mBinding.checkoutMetodePembayaranBtn.setOnClickListener {
            showMetodePembayaranDialog()
        }
        mBinding.checkoutPilihKurirBtn.setOnClickListener() {
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
