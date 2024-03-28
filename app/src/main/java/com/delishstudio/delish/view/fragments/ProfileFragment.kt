package com.delishstudio.delish.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.delishstudio.delish.R
import com.delishstudio.delish.databinding.FragmentProfileBinding
import com.delishstudio.delish.model.User
import com.delishstudio.delish.view.activities.AccountSettingsActivity
import com.delishstudio.delish.view.activities.EditProfileActivity
import com.delishstudio.delish.view.activities.PaymentMethodActivity

class ProfileFragment : Fragment() {
    private lateinit var mBinding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        inflater.inflate(R.layout.fragment_profile, container, false)
        mBinding = FragmentProfileBinding.inflate(inflater, container, false)

        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.profileUserName.text = User.Main.name
        mBinding.profileUserEmail.text = User.Main.email
        mBinding.profilePhoneNumber.text = User.Main.phone

        onSetupButtons()
    }

    private fun onSetupButtons() {

        mBinding.metodePembayaran.setOnClickListener{
            val intent = Intent(activity, PaymentMethodActivity::class.java)
            startActivity(intent)
        }

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