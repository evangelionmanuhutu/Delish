package com.delishstudio.delish.view.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.delishstudio.delish.MainActivity
import com.delishstudio.delish.R
import com.delishstudio.delish.databinding.ActivitySignInBinding
import com.delishstudio.delish.model.User
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class SignInActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivitySignInBinding
    private lateinit var mFirebaseAuth: FirebaseAuth
    private lateinit var mGooGleSignInClient: GoogleSignInClient

    companion object {
        public lateinit var mUserEmail: String
    }

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
                if (it.isSuccessful)
                {
                    User.Available { userAvailable ->
                        if(!userAvailable)
                        {
                            val intent = Intent(this, UserSetupActivity::class.java)
                            startActivity(intent)
                        }
                        else
                        {
                            val intent = Intent(this, MainActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else
                {
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
        launcher.launch(signInIntent)
    }

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            val credential = GoogleAuthProvider.getCredential(account.idToken, null)
            mFirebaseAuth.signInWithCredential(credential).addOnCompleteListener(this) { task ->
                if (task.isSuccessful)
                {
                    User.Available { userAvailable ->
                        if (!userAvailable)
                        {
                            val intent = Intent(this, UserSetupActivity::class.java)
                            startActivity(intent)
                        }
                        else
                        {
                            val intent = Intent(this, MainActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else
                {
                    Toast.makeText(this, task.exception.toString(), Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
        catch (e: ApiException)
        {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG)
                .show()
        }
    }
}