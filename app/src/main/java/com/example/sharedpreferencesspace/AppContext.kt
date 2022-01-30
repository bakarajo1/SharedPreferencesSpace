package com.example.sharedpreferencesspace

import android.app.Application

class AppContext:Application() {
    companion object{
        lateinit var prefs:SharedPreferences
    }
    override fun onCreate() {
        super.onCreate()
         prefs=SharedPreferences(applicationContext)

    }


}