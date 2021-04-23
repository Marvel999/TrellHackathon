package com.marvel999.trellhackathon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast

import com.github.pgreze.reactions.ReactionPopup
import com.github.pgreze.reactions.dsl.reactionConfig
import com.github.pgreze.reactions.dsl.reactions
import com.marvel999.trellhackathon.utils.LikeUtil
import com.marvel999.trellhackathon.utils.RectionConstants
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val likeButton=findViewById<Button>(R.id.button);

        val config = reactionConfig(this) {
            reactions {
                resId    { R.drawable.ic_heart }
                resId    { R.drawable.ic_happy }
                resId    { R.drawable.ic_like }
                reaction { R.drawable.ic_surprised scale ImageView.ScaleType.FIT_XY }
                reaction { R.drawable.ic_sad scale ImageView.ScaleType.FIT_XY }
                reaction { R.drawable.ic_angry scale ImageView.ScaleType.FIT_XY }
            }
        }

        val popup = ReactionPopup(this, config) { position -> true.also {
            // position = -1 if no selection
            if(LikeUtil.getRection(position)!=null)
                   Toast.makeText(this, LikeUtil.getRection(position),Toast.LENGTH_LONG ).show();

        } }

        likeButton.setOnClickListener {
            likeButton.setOnTouchListener(popup);

        }

    }


}