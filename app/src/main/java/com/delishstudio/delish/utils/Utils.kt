package com.delishstudio.delish.utils

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.delishstudio.delish.R

class Utils {
    companion object {
        fun LongToastText(context: Context, message: String) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        }
        fun ShortToastText(context: Context, message: String) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }
}

class DatabaseStrRef {
    companion object {
        val USERS: String = "Users"
        val PRODUCTS: String = "Products"
        val EMAIL: String = "email"
    }
}

class FragmentUtils : Fragment() {
    companion object {
        fun navigateToFragment(currentFragment :Fragment, other: Fragment) {
            val fragmentManager = currentFragment.requireActivity().supportFragmentManager
            fragmentManager.beginTransaction().replace(R.id.frameContainer, other).commit()
        }
    }
}

class ActivityUtils: AppCompatActivity() {
    companion object {
        fun navigateToFragment(activity: AppCompatActivity, fragment: Fragment) {
            activity.supportFragmentManager.beginTransaction().replace(R.id.frameContainer, fragment).commit()
        }
    }
}