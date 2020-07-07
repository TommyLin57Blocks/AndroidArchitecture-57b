package com.b57.architecture.okhttp

data class ApiResult<T>(
    val code : Int,
    val message : String,
    val data : T
)