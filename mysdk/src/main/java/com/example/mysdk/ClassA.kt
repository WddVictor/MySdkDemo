package com.example.mysdk

import android.util.Log
import javax.inject.Inject

class ClassA @Inject constructor() {
    fun doSomething() {
        Log.i("ClassA", "Doing something")
    }
}