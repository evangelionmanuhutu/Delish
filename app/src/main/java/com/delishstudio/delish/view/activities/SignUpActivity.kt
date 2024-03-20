package com.delishstudio.delish.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.delishstudio.delish.R
import com.delishstudio.delish.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivitySignUpBinding
    private lateinit var mFirebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        mBinding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mFirebaseAuth = FirebaseAuth.getInstance()

        // NOT A USER BUTTON
        mBinding.txtRegistered.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        // SIGN UP BUTTON
        mBinding.btSignup.setOnClickListener {
            val email = mBinding.emailEt.text.toString()
            val password = mBinding.passET.text.toString()
            val confirmPassword = mBinding.confirmPassEt.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                if (password == confirmPassword) {
                    mFirebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this, SignInActivity::class.java)
                            startActivity(intent)
                        }
                        else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                else {
                    Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this, "Empty fields is not allowed!!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}