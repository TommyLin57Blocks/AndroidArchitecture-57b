package com.b57.basictemplate.ui.login

import androidx.lifecycle.*
import com.b57.basictemplate.R
import com.b57.basictemplate.domain.login.LoginByPasswordUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.b57.architecture.Result
import com.b57.architecture.succeeded
import com.b57.architecture.LiveEvent
import com.b57.architecture.ext.mapWithDefaultValue

class LoginViewModel constructor(
    private val loginByPwd: LoginByPasswordUseCase
) : ViewModel() {

    val account = MutableLiveData<String>()
    val pwd = MutableLiveData<String>()

    /**
     * login result live Data
     * Succeed ,
     * Error
     * Loading
     */
    val loginResult = MutableLiveData<Result<Unit>>()

    /**
     * Toast event live data
     */
    val toastEvent = MutableLiveData<LiveEvent<Int>>()

    /**
     * Loading event live data
     */
    val loadingEvent = loginResult.mapWithDefaultValue(false) {
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