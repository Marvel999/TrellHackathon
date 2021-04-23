package com.marvel999.trellhackathon.utils

object  LikeUtil {
    fun getRection(position: Int): String? {

        if (position==0)
            return RectionConstants.HEART;
        else if(position==1)
            return RectionConstants.HAPPY;
        else if(position==2)
            return RectionConstants.LIKE;
        else if(position==3)
            return RectionConstants.WOW;
        else if(position==4)
            return RectionConstants.SAD;
        else if(position==5)
            return RectionConstants.ANGRY;
        else
            return null;
    }
}