package com.example.studyup

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class SaveSharedPreference {
    companion object{
        const val PREF_USER_NAME : String= "Username"
        @JvmStatic
        public fun getSharedPreference(cContext : Context) : SharedPreferences
        {
            return PreferenceManager.getDefaultSharedPreferences(cContext)
        }
        @JvmStatic
        public fun getUsername(cContext: Context) : String?
        {
            return getSharedPreference(cContext).getString(PREF_USER_NAME,"")
        }
        @JvmStatic
        public fun setUsername(cContext: Context,userName : String)
        {
            val editor = getSharedPreference(cContext).edit()
            editor.putString(PREF_USER_NAME,userName)
            editor.commit()
        }@JvmStatic
        public fun deleteAllPreferences(cContext: Context)
        {
            val editor = getSharedPreference(cContext).edit()
            editor.clear()
            editor.commit()
        }
    }
}