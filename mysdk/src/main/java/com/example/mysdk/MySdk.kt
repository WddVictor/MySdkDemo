package com.example.mysdk

import android.content.Context
import android.util.Log

object MySdk {

    private val TAG = MySdk::class.java.simpleName

    @Volatile
    private var isInitialized = false
    private var serviceA: ServiceA? = null

    fun init(context: Context) {
        if (isInitialized) {
            return
        }
        synchronized(this) {
            if (isInitialized) {
                return
            }
            Log.i(TAG, "Initializing MySdk")
            serviceA =
                DaggerComponentA.builder().baseContext(context).build().orkaDeviceClientService()
        }
        isInitialized = true
    }

    fun getServiceA(): ServiceA {
        if (!isInitialized) {
            throw IllegalStateException("MySdk is not initialized")
        }
        return serviceA!!
    }

    fun dispose() {
        if (!isInitialized) {
            return
        }
        synchronized(this) {
            if (!isInitialized) {
                return
            }
            Log.i(TAG, "Deinitializing MySdk")
            serviceA = null
        }
        isInitialized = false
    }
}