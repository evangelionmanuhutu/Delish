package com.delishstudio.delish.view.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.delishstudio.delish.MainActivity
import com.delishstudio.delish.R
import com.delishstudio.delish.databinding.ActivityAuthBoardingBinding
import com.delishstudio.delish.model.User
import com.delishstudio.delish.model.UserModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AuthBoardingActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityAuthBoardingBinding
    private lateinit var mFirebaseAuth: FirebaseAuth
    private var mUserAvailable: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityAuthBoardingBinding.inflate(layoutInflater)
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        supportActionBar?.hide()

        setContentView(R.layout.layout_loading_screen)

        mFirebaseAuth = FirebaseAuth.getInstance()

        // User already logged in
        if (mFirebaseAuth.currentUser != null) {
            User.Available { userAvailable ->
                mUserAvailable = userAvailable
                if (userAvailable) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else
                {
                    setContentView(mBinding.root)
                    mBinding.btLogin.setOnClickListener {
                        val intent = Intent(this, SignInActivity::class.java)
                        startActivity(intent)
                    }

                    mBinding.btSignup.setOnClickListener {
                        val intent = Intent(this, SignUpActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        }
        else
        {
            setContentView(mBinding.root)
            mBinding.btLogin.setOnClickListener {
                val intent = Intent(this, SignInActivity::class.java)
                startActivity(intent)
            }

            mBinding.btSignup.setOnClickListener {
                val intent = Intent(this, SignUpActivity::class.java)
                startActivity(intent)
            }
        }
    }
}