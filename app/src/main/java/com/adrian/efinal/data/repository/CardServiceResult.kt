package com.adrian.efinal.data.repository

sealed class CardServiceResult<T>(data: T? =null, error: java.lang.Exception? =null) {

    data class Success<T>(val data: T): CardServiceResult<T>(null)
    data class Error<T>(val error: Exception): CardServiceResult<T>(null, error)

}