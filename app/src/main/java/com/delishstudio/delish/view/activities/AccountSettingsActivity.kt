package com.delishstudio.delish.view.activities

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.delishstudio.delish.R
import com.delishstudio.delish.databinding.ActivityAccountSettingsBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AccountSettingsActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityAccountSettingsBinding
    private var mIsDialogShown: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityAccountSettingsBinding.inflate(layoutInflater)
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        supportActionBar?.hide()
        setContentView(mBinding.root)

        onSetupButtons()
    }

    private fun onSetupButtons() {
        mBinding.btProfileSettingsBack.setOnClickListener {
            this.onBackPressed()
        }

        mBinding.hapusAkun.setOnClickListener {
            val intent = Intent(this, DeleteAccountActivity::class.java)
            startActivity(intent)
        }

        mBinding.keluar.setOnClickListener {
            showLoggedOutConfirmation()
        }
    }

    private fun showLoggedOutConfirmation() {
        if(mIsDialogShown) {
            return
        }

        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.layout_confirmation)
        val confirmationText = dialog.findViewById<TextView>(R.id.txt_confirmation_status)
        confirmationText.text = "Konfirmasi Keluar"
        val questionText = dialog.findViewById<TextView>(R.id.txt_confirmation_question)
        questionText.text = "Apakah kamu yakin mau keluar?"

        val confirmBtn = dialog.findViewById<AppCompatButton>(R.id.bt_confirm)
        confirmBtn.text = "Keluar"

        val cancelBtn = dialog.findViewById<AppCompatButton>(R.id.bt_cancel)

        confirmBtn.setOnClickListener{
            FirebaseAuth.getInstance().signOut()

            // Create intent to navigate to SignInActivity and clear task stack
            val intent = Intent(this, AuthBoardingActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }

        cancelBtn.setOnClickListener{
            dialog.dismiss()
        }

        dialog.setOnDismissListener{
            mIsDialogShown = false
        }

        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.setGravity(Gravity.CENTER)

        dialog.show()
        mIsDialogShown = true
    }
}
