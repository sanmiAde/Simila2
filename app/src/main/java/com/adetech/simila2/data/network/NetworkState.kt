package com.adetech.simila2.data.network


sealed class NetWorkState {
    class Loading : NetWorkState()
    class Success : NetWorkState()
    class NotLoaded : NetWorkState()
    data class Error(val errorMessage: String?) : NetWorkState()
}

