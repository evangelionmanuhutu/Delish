package com.delishstudio.delish.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.delishstudio.delish.R
import com.delishstudio.delish.databinding.FragmentProfileBinding
import com.delishstudio.delish.utils.FragmentUtils.Companion.navigateToFragment
import com.delishstudio.delish.view.activities.AccountSettingsActivity
import com.delishstudio.delish.view.activities.EditProfileActivity

class ProfileFragment : Fragment() {
    private lateinit var mBinding: FragmentProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        inflater.inflate(R.layout.fragment_profile, container, false)
        mBinding = FragmentProfileBinding.inflate(inflater, container, false)
        onSetupButtons()
        return mBinding.root
    }

    private fun onSetupButtons() {
        mBinding.pengaturanAkun.setOnClickListener {
            val intent = Intent(activity, AccountSettingsActivity::class.java)
            startActivity(intent)
        }

        mBinding.profileEditButton.setOnClickListener{
            val intent = Intent(activity, EditProfileActivity::class.java)
            startActivity(intent)
        }
    }
}