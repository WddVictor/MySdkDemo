package com.example.mysdk

import dagger.Binds
import dagger.Module

@Module
abstract class BindsModule {
    @ScopeA
    @Binds
    abstract fun bindServiceA(serviceAImpl: ServiceAImpl): ServiceA
}