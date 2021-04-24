package com.marvel999.trellhackathon

import com.marvel999.trellhackathon.utils.CheckVideoConstants
import com.marvel999.trellhackathon.utils.CheckVideoUtils
import com.marvel999.trellhackathon.utils.LikeUtil
import com.marvel999.trellhackathon.utils.RectionConstants
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    //Test if value is -ve the it give null value
    @Test
    fun `Test Get Null Rection`(){
        assertNull(LikeUtil.getRection(-1));
    }

    //Test if value is +ve between 1 To 5 the it give not null value

    @Test
    fun `Test Get Not Null Rection`(){
        for( i in 1..5){
            if(i==0)
                assertEquals(RectionConstants.HEART,LikeUtil.getRection(i));
            else if(i==1)
                assertEquals(RectionConstants.HAPPY,LikeUtil.getRection(i));
            else if(i==2)
                assertEquals(RectionConstants.LIKE,LikeUtil.getRection(i));
            else if(i==3)
                assertEquals(RectionConstants.WOW,LikeUtil.getRection(i));
            else if(i==4)
                assertEquals(RectionConstants.SAD,LikeUtil.getRection(i));
            else if(i==5)
                assertEquals(RectionConstants.ANGRY,LikeUtil.getRection(i));
    }
    }

//    Test mode
    @Test
      fun `Test Mode`(){
          for(i in 1..5){
              for (j in 1..5){
                  if(i<=j){
                      assertEquals(CheckVideoConstants.PORTRAIT_MODE,CheckVideoUtils.getMode(CheckVideoUtils.portrait(i,j)))
                  }
                  else{
                      assertEquals(CheckVideoConstants.LANDSCAPE_MODE,CheckVideoUtils.getMode(CheckVideoUtils.portrait(i,j)))
                  }
              }
          }
      }

}