package com.delishstudio.delish.view.activities

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.delishstudio.delish.MainActivity
import com.delishstudio.delish.R
import com.delishstudio.delish.databinding.ActivitySignInBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class SignInActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivitySignInBinding
    private lateinit var mFirebaseAuth: FirebaseAuth
    private lateinit var mGooGleSignInClient: GoogleSignInClient
    private val RC_SIGN_IN = 9001

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

        mBinding.btEmailSignin.setOnClickListener {
            emailPasswordSignIn()
        }

        configureGoogleSignin()
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
                    Toast.makeText(this, "Your email or password is wrong", Toast.LENGTH_SHORT).show()
                }
            }
        }
        else {
            Toast.makeText(this, "Empty fields is not allowed!!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun configureGoogleSignin() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.google_sign_in_web_client_id))
            .requestEmail()
            .build()
        mGooGleSignInClient = GoogleSignIn.getClient(this, gso)

        mBinding.btGoogleSignin.setOnClickListener {
            googleSignIn()
        }
    }

    private fun googleSignIn() {
        val signInIntent = mGooGleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            val credential = GoogleAuthProvider.getCredential(account.idToken, null)
            mFirebaseAuth.signInWithCredential(credential).addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, task.exception.toString(), Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
        catch (e: ApiException) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG)
                .show()
        }
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