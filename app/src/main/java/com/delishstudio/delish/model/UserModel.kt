package com.delishstudio.delish.model

class UserModel(name: String, phone: String) {
    var imgSrc: Int = 0
    var phoneNumber: String = phone
    lateinit var address: String
}