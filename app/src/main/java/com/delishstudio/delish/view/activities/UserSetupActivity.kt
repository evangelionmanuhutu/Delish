package com.delishstudio.delish.view.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.delishstudio.delish.MainActivity
import com.delishstudio.delish.R
import com.delishstudio.delish.databinding.ActivityUserSetupBinding
import com.delishstudio.delish.model.User
import com.delishstudio.delish.model.UserModel
import com.delishstudio.delish.utils.DatabaseStrRef
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UserSetupActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityUserSetupBinding
    private lateinit var mFirebaseRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        supportActionBar?.hide()

        mBinding = ActivityUserSetupBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        val firebase = FirebaseAuth.getInstance()
        mFirebaseRef = FirebaseDatabase.getInstance().getReference(DatabaseStrRef.USERS)

        mBinding.btNext.setOnClickListener {
            val username = mBinding.txtUsername.text.toString()
            val phone = mBinding.txtPhone.text.toString()
            val userId = mFirebaseRef.push().key?: " "
            val email = firebase.currentUser!!.email.toString()
            User.Main = UserModel(username, phone, email)

            mFirebaseRef.child(userId).setValue(User.Main)
                .addOnCompleteListener{
                    val intent = Intent(this, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish()

                }.addOnFailureListener{
                    Toast.makeText(this, "Failed to insert data", Toast.LENGTH_LONG)
                        .show()
                }
        }
    }

}