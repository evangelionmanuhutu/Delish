package com.delishstudio.delish.viewmodel.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel : ViewModel() {
    private val _loginResult = MutableLiveData<Boolean>()

    // Login Email
    val loginResult: LiveData<Boolean>
        get() = _loginResult

    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    fun loginUser(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            _loginResult.value = task.isSuccessful
        }
    }

    // Login Google

}

