package com.marvel999.trellhackathon.Fragments

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marvel999.trellhackathon.utils.LikeSharedPreferences

class LikeViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private var _like:MutableLiveData<String> = MutableLiveData();
    val like:LiveData<String> =_like
    fun getLike(context: Context){
        LikeSharedPreferences(context).getLike().let {
            _like.postValue(it)
        }
    }

    fun setLike(context: Context,like:String){
        LikeSharedPreferences(context).setLike(like)
    }
}