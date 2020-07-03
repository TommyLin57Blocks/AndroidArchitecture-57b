package com.b57.basictemplate.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.b57.basictemplate.R
import com.b57.basictemplate.domain.LoginByPasswordUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.b57.architecture.Result
import com.b57.architecture.succeeded
import com.b57.architecture.LiveEvent

class LoginViewModel(
    private val loginByPwd: LoginByPasswordUseCase
) : ViewModel() {

    val account = MutableLiveData<String>()
    val pwd = MutableLiveData<String>()
    val loginResult = MutableLiveData<Result<Unit>>()
    val toastEvent = MutableLiveData<LiveEvent<Int>>()
    val loadingEvent = loginResult.map {
        it is Result.Loading
    }

    fun login() {
        viewModelScope.launch(Dispatchers.IO) {
            if (account.value.isNullOrEmpty()) {
                toastEvent.postValue(LiveEvent(R.string.login_empty_account))
                return@launch
            }
            if (pwd.value.isNullOrEmpty()) {
                toastEvent.postValue(LiveEvent(R.string.login_empty_pwd))
                return@launch
            }
            loginResult.postValue(Result.Loading)
            val result = loginByPwd(account.value!!, pwd.value!!)
            when {
                result.succeeded -> toastEvent.postValue(
                    LiveEvent(
                        R.string.login_succeed
                    )
                )
                result is Result.Error -> toastEvent.postValue(
                    LiveEvent(
                        R.string.login_failed
                    )
                )
            }
            loginResult.postValue(result)
        }
    }

}