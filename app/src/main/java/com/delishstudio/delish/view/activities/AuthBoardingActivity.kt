package com.delishstudio.delish.view.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.delishstudio.delish.MainActivity
import com.delishstudio.delish.R
import com.delishstudio.delish.databinding.ActivityAuthBoardingBinding
import com.delishstudio.delish.model.User
import com.google.firebase.auth.FirebaseAuth

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

            // Checking the database
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
            // If not logged in just set to login/signup activity
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