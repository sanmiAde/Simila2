package com.adetech.simila2.data.network

enum class Status {
    LOADING,
    SUCCESS,
    FAILURE,
    NOTLOADED
}

sealed class NetWorkState {
    class Loading
}

