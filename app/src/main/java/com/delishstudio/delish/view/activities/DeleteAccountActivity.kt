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
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.delishstudio.delish.R
import com.delishstudio.delish.databinding.ActivityCheckoutBinding
import com.delishstudio.delish.databinding.ActivityDeleteAccountBinding
import com.google.firebase.auth.FirebaseAuth

class DeleteAccountActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityDeleteAccountBinding
    private var mIsDialogShown: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        supportActionBar?.hide()
        mBinding = ActivityDeleteAccountBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setupButtons()
    }

    private fun setupButtons() {
        mBinding.btDeleteAccount.setOnClickListener {
            showDeleteAccountConfirmation()
        }
    }

    private fun showDeleteAccountConfirmation() {
        if(mIsDialogShown)
            return

        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.layout_confirmation)
        val confirmationText = dialog.findViewById<TextView>(R.id.txtConfirmationStatus)
        confirmationText.text = "Hapus Akun"
        val questionText = dialog.findViewById<TextView>(R.id.txtConfirmationQuestion)
        questionText.text = "Apa kamu yakin mau lanjut hapus akun\u2028kamu di aplikasi Delish?"
        val confirmBtn = dialog.findViewById<AppCompatButton>(R.id.btConfirm)
        confirmBtn.text = "Hapus"

        val cancelBtn = dialog.findViewById<AppCompatButton>(R.id.btCancel)

        confirmBtn.setOnClickListener {
            FirebaseAuth.getInstance().currentUser?.delete()?.addOnCompleteListener { task->
                if (task.isSuccessful)
                {
                    val intent = Intent(this, AuthBoardingActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish()
                }
                else
                {
                    Toast.makeText(this, "Failed to delete your account", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
            }
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