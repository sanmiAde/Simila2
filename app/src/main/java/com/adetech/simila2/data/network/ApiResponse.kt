package com.adetech.simila2.data.network

import android.util.Log
import retrofit2.Response
import java.io.IOException

class ApiResponse<T>(response: Response<T>) {

    private var code: Int = 500
    private var body: T? = null
    private var error: Throwable? = null


    init {
        code = response.code()
        if (response.isSuccessful) {
            body = response.body()
            error = null
        } else {
            var message: String? = null
            if (response.errorBody() != null) {
                try {
                    message = response.errorBody()!!.string()
                } catch (ioE: IOException) {
                    Log.e("Error", "Error while parsing reponse", ioE)
                }
            }
            if (message == null || message.trim().isEmpty()) {
                message = response.message()
            }
            error = IOException(message)
            body = null

        }
    }

    fun isSuccessful(): Boolean = code in 200..299


}