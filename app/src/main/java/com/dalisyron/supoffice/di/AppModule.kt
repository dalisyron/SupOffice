package com.dalisyron.supoffice.di

import android.app.Application
import android.content.Context
import com.dalisyron.supoffice.MyApplication
import dagger.Module
import dagger.Provides

@Module
class AppModule(val myApp: MyApplication) {

    @Provides
    fun providesContext(): Context {
        return myApp.applicationContext
    }
}
