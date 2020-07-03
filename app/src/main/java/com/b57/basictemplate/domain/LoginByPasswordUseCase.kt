package com.b57.basictemplate.domain

import com.b57.basictemplate.data.repository.LoginRepository
import com.b57.architecture.Result

class LoginByPasswordUseCase(
    private val loginRepository: LoginRepository
) {

    suspend operator fun invoke(account: String, pwd: String): Result<Unit> {
        return try {
            loginRepository.loginByPwd(account, pwd)
            Result.Success(Unit)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.Error(e)
        }
    }

}