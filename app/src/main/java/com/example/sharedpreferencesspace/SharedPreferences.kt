package com.example.sharedpreferencesspace

import android.content.Context

class SharedPreferences(val context: Context) {


    val PREFERENCES_NAME="mypref"
    val SHARED_USER_NAME="username"
    val SHARED_PASSWORD="password"
    val SHARED_STATE="state"
    val SHARED_NUMBER="numberSum"


    val storage=context.getSharedPreferences(PREFERENCES_NAME,0)


    fun saveName(name:String){
        storage.edit().putString(SHARED_USER_NAME,name).apply()
    }
    fun saveSurname(surname:String){
        storage.edit().putString(SHARED_PASSWORD,surname).apply()

    }
    fun saveSwitchState(state:Boolean){
        storage.edit().putBoolean(SHARED_STATE,state).apply()
    }

    fun saveCalculatorAnswer(num:Int){
        storage.edit().putInt(SHARED_NUMBER,num).apply()

    }
    fun getCalculatorAnswer():Int{
        return storage.getInt(SHARED_NUMBER,0)

    }
    fun getName(): String {
        return storage.getString(SHARED_USER_NAME,"")!!

    }
    fun getSurname(): String {
        return storage.getString(SHARED_PASSWORD,"")!!

    }
    fun getSwitchState(): Boolean {
        return storage.getBoolean(SHARED_STATE,false)

    }
    fun deleteAll(){
        storage.edit().clear().apply()
    }

}