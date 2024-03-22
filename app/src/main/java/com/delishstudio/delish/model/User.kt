package com.delishstudio.delish.model

import com.delishstudio.delish.utils.DatabaseStrRef
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class User {
    companion object {
        public var Main: UserModel = UserModel("", "", "")

        public fun Update() {
            val firebaseRef = FirebaseDatabase.getInstance().getReference(DatabaseStrRef.USERS)
            val query = firebaseRef.orderByChild(DatabaseStrRef.EMAIL).equalTo(Main.email)
            query.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (userSnapshot in dataSnapshot.children) {
                        val userKey = userSnapshot.key
                        userKey?.let {
                            firebaseRef.child(it).setValue(Main)
                        }
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {
                }
            })

        }
        public fun Available(callback: (Boolean) -> Unit)
        {
            if (Main.name?.isEmpty() == true)
            {
                val email = FirebaseAuth.getInstance().currentUser!!.email.toString()
                val firebaseRef = FirebaseDatabase.getInstance().getReference(DatabaseStrRef.USERS)
                val query = firebaseRef.orderByChild(DatabaseStrRef.EMAIL).equalTo(email)
                query.addListenerForSingleValueEvent(object : ValueEventListener
                {
                    override fun onDataChange(dataSnapshot: DataSnapshot)
                    {
                        var userFound = false
                        for (userSnapshot in dataSnapshot.children)
                        {
                            val user = userSnapshot.getValue(UserModel::class.java)
                            Main = UserModel(user?.name, user?.phone, user?.email)
                            userFound = true
                        }
                        callback(userFound)
                    }

                    override fun onCancelled(error: DatabaseError)
                    {
                        callback(false)
                    }
                })
            } else
            {
                callback(true)
            }
        }
    }
}