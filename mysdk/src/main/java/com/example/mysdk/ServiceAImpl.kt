package com.example.mysdk

import javax.inject.Inject

class ServiceAImpl @Inject constructor(
    private val classA: ClassA
) : ServiceA {
    override fun doSomething() {
        classA.doSomething()
    }
}