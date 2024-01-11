package com.delishstudio.delish.view.activities.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.delishstudio.delish.R
import com.delishstudio.delish.databinding.ActivityRegisterBinding
import com.delishstudio.delish.view.fragments.HomeFragment
import com.delishstudio.delish.viewmodel.auth.RegisterViewModel

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private val viewModel: RegisterViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        window.statusBarColor = ContextCompat.getColor(this, R.color.main_col)
        supportActionBar?.hide()
        setContentView(binding.root)

        binding.subDescLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.btnRegister.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            val verifPassword = binding.etVerifikasiPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty() && verifPassword.isNotEmpty()) {
                viewModel.registerUser(email, password, verifPassword)
            } else {
                Toast.makeText(this, "Form kosong tidak diperbolehkan", Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.registrationResult.observe(this) { isSuccessful ->
            if (isSuccessful) {
                val intent = Intent(this, HomeFragment::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Registrasi akun gagal!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

