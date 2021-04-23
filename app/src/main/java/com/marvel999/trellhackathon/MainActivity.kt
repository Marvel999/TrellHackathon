package com.marvel999.trellhackathon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.github.pgreze.reactions.ReactionPopup
import com.github.pgreze.reactions.dsl.reactionConfig
import com.github.pgreze.reactions.dsl.reactions
import com.marvel999.trellhackathon.utils.LikeUtil
import com.marvel999.trellhackathon.utils.RectionConstants
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {
    public lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController=Navigation.findNavController(findViewById(R.id.hostFrament));
        navController.navigate(R.id.action_likeFragment_self)
    }


}