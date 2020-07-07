package com.b57.basictemplate

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.b57.architecture.Result
import com.b57.basictemplate.data.repository.ILoginRepository
import com.b57.basictemplate.domain.login.LoginByPasswordUseCase
import com.b57.basictemplate.ui.login.LoginViewModel
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.lang.Exception

class LoginViewModelTest {


    private lateinit var viewModel: LoginViewModel

    private val CORRECT_ACCOUNT = "fakeAccount"
    private val CORRECT_PWD = "123456"

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val testCoroutineDispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        viewModel = LoginViewModel(
            LoginByPasswordUseCase(
                object : ILoginRepository {
                    override suspend fun loginByPwd(account: String, pwd: String) {
                        println("login account = $account, pwd = $pwd")
                        if (account != CORRECT_ACCOUNT || pwd != CORRECT_PWD) {
                            throw Exception("Login Failed")
                        }
                    }
                },
                testCoroutineDispatcher
            )
        )
    }

    @Test
    fun accountEmpty() {
        viewModel.login()
        assert(
            viewModel.toastEvent.getOrAwaitValue()?.peekContent() == R.string.login_empty_account
        )
    }

    @Test
    fun pwdEmpty() {
        viewModel.account.value = "fakeAccount"
        viewModel.login()
        assert(viewModel.toastEvent.getOrAwaitValue()?.peekContent() == R.string.login_empty_pwd)
    }

    @Test
    fun loginSucceed() {
        viewModel.account.value = CORRECT_ACCOUNT
        viewModel.pwd.value = CORRECT_PWD
        val observeResult = viewModel.loginSucceedLiveData.assertValues(2) { index, data ->
            when (index) {
                0 -> data == Result.Loading
                1 -> data is Result.Success
                else -> false
            }
        }
        viewModel.login()
        observeResult.first.await()
        viewModel.loginSucceedLiveData.removeObserver(observeResult.second)
        assert(viewModel.toastEvent.getOrAwaitValue().peekContent() == R.string.login_succeed)
    }

    @Test
    fun loginFailed() {
        viewModel.account.value = "2222"
        viewModel.pwd.value = CORRECT_PWD
        val observeResult = viewModel.loginSucceedLiveData.assertValues(2) { index, data ->
            when (index) {
                0 -> data == Result.Loading
                1 -> data is Result.Error
                else -> false
            }
        }
        viewModel.login()
        observeResult.first.await()
        viewModel.loginSucceedLiveData.removeObserver(observeResult.second)
        assert(viewModel.toastEvent.getOrAwaitValue().peekContent() == R.string.login_failed)
    }

}