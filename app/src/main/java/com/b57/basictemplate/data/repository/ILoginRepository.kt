package com.b57.basictemplate.data.repository

interface ILoginRepository {

    suspend fun loginByPwd(account: String, pwd: String)
}