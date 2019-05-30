package com.dalisyron.supoffice.di

import com.dalisyron.supoffice.MainActivity
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}