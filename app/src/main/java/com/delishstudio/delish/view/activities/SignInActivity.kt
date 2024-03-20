package com.delishstudio.delish.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.delishstudio.delish.MainActivity
import com.delishstudio.delish.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivitySignInBinding
    private lateinit var mFirebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        mBinding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mFirebaseAuth = FirebaseAuth.getInstance()

        mBinding.txtNotRegistered.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        mBinding.btSignIn.setOnClickListener {
            emailPasswordSignIn()
        }
    }

    private fun emailPasswordSignIn() {
        val email = mBinding.emailEt.text.toString()
        val password = mBinding.passET.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty()) {
            mFirebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                else {
                    Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        }
        else {
            Toast.makeText(this, "Empty fields is not allowed!!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun googleSignIn() {

    }

    override fun onStart() {
        super.onStart()

        if (mFirebaseAuth.currentUser != null) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}