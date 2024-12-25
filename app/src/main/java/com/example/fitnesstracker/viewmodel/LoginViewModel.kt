package com.example.fitnesstracker.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var login by mutableStateOf("")
    var name by mutableStateOf("")
    var password by mutableStateOf("")
    var repassword by mutableStateOf("")

    fun onLoginChange(newLogin: String) {
        login = newLogin
    }

    fun onNameChange(newName: String) {
        name = newName
    }

    fun onPasswordChange(newPassword: String) {
        password = newPassword
    }

    fun onRepasswordChange(newRepassword: String) {
        repassword = newRepassword
    }
}