package com.marvel999.trellhackathon.utils

import android.content.Context
import android.content.pm.ActivityInfo
import android.graphics.Bitmap
import android.media.MediaMetadataRetriever
import com.bumptech.glide.Glide


object CheckVideoUtils{

    fun portrait(width:Int,height:Int):Boolean{
        return width<=height;

    }

    fun getMode(boolean: Boolean):String{
        if (boolean)
            return CheckVideoConstants.PORTRAIT_MODE;
        else
            return CheckVideoConstants.LANDSCAPE_MODE;
    }


}