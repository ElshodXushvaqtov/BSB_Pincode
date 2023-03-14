package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences

val PREFERENCE_NAME="Shared Preference"
val PREFERENCE_LANGUAGE="Language"

class MyPreference(context: Context){

    val preference=context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE)

    fun getLanguage(): String? {
        return preference.getString(PREFERENCE_LANGUAGE,"en")
    }

    fun setLanguage(language:String){
        val editor=preference.edit()
        editor.putString(PREFERENCE_LANGUAGE,language)
        editor.apply()

    }

}