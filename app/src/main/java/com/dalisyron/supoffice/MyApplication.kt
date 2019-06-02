package com.dalisyron.supoffice

import android.app.Application
import com.dalisyron.supoffice.di.AppComponent
import com.dalisyron.supoffice.di.AppModule
import com.dalisyron.supoffice.di.DaggerAppComponent

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder().appModule(
            AppModule(
                this
            )
        ).build()
    }

    companion object {
        lateinit var component: AppComponent
    }
}
