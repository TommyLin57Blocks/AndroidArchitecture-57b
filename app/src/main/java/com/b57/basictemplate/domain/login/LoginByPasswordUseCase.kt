package com.b57.basictemplate.domain.login

import com.b57.architecture.Result
import com.b57.basictemplate.data.repository.ILoginRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Login by pwd
 * we handle exception in this class,
 * when catch exception, return a Result.Error
 */
class LoginByPasswordUseCase(
    private val loginRepository: ILoginRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
) {

    suspend operator fun invoke(account: String, pwd: String): Result<Unit> =
        withContext(dispatcher) {
            try {
                loginRepository.loginByPwd(account, pwd)
                Result.Success(Unit)
            } catch (e: Exception) {
                e.printStackTrace()
                Result.Error(e)
            }
        }

}