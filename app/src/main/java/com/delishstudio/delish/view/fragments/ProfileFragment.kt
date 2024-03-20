package com.delishstudio.delish.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.delishstudio.delish.R
import com.delishstudio.delish.databinding.FragmentProfileBinding
import com.delishstudio.delish.view.activities.EditProfileActivity
import com.delishstudio.delish.view.activities.SignInActivity
import com.delishstudio.delish.view.activities.SignUpActivity
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment() {

    private lateinit var mBinding: FragmentProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inflater.inflate(R.layout.fragment_profile, container, false)
        mBinding = FragmentProfileBinding.inflate(inflater, container, false)
        setupButtons()
        return mBinding.root
    }

    private fun setupButtons() {
        mBinding.btLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(activity, SignInActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }

        mBinding.profileEditButton.setOnClickListener{
            val intent = Intent(activity, EditProfileActivity::class.java)
            startActivity(intent)
        }
    }
}