package com.example.mysdk

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@ScopeA
@Component(
    modules = [
        BindsModule::class,
    ]
)
interface ComponentA {
    @Component.Builder
    interface Builder {
        fun build(): ComponentA

        @BindsInstance
        fun baseContext(baseContext: Context): Builder
    }

    fun orkaDeviceClientService(): ServiceA
}