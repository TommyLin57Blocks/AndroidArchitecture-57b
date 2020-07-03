package com.b57.basictemplate.data.repository

import kotlinx.coroutines.delay

class LoginRepository {
    suspend fun loginByPwd(account: String, pwd: String) {
        delay(2 * 1000)
    }
}