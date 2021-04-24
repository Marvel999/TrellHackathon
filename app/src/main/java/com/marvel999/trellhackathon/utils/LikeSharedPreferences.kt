package com.marvel999.trellhackathon.utils

import android.content.Context
import android.content.SharedPreferences

class LikeSharedPreferences(context: Context) {

    val sharedPreferences: SharedPreferences = context.getSharedPreferences(RectionConstants.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
    val editor:SharedPreferences.Editor =  sharedPreferences.edit()

    fun setLike(like:String){
        editor.putString(RectionConstants.Like,like)
        editor.apply()
        editor.commit()
    }

    fun getLike():String?{
        val sharedNameValue = sharedPreferences.getString(RectionConstants.Like,"0")
       return sharedNameValue;
    }

}