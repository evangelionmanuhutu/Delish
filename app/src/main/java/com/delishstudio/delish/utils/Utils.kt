package com.delishstudio.delish.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.delishstudio.delish.R

class DatabaseStrRef {
    companion object {
        val USERS: String = "Users"
        val PRODUCTS: String = "Products"
        val EMAIL: String = "email"
    }
}

class FragmentUtils : Fragment() {
    companion object {
        public fun navigateToFragment(currentFragment :Fragment, other: Fragment) {
            val fragmentManager = currentFragment.requireActivity().supportFragmentManager
            fragmentManager.beginTransaction().replace(R.id.frameContainer, other).commit()
        }
    }
}

class ActivityUtils: AppCompatActivity() {
    companion object {
        public fun navigateToFragment(activity: AppCompatActivity, fragment: Fragment) {
            activity.supportFragmentManager.beginTransaction().replace(R.id.frameContainer, fragment).commit()
        }
    }
}