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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val likeButton=findViewById<ImageButton>(R.id.button);

        val config = reactionConfig(this) {
            reactions {
                resId    { R.drawable.ic_android_black_24dpc }
                resId    { R.drawable.ic_android_black_24dp }
                resId    { R.drawable.ic_android_black_24dp }
                reaction { R.drawable.ic_android_black_24dp scale ImageView.ScaleType.FIT_XY }
                reaction { R.drawable.ic_android_black_24dp scale ImageView.ScaleType.FIT_XY }
                reaction { R.drawable.ic_android_black_24dp scale ImageView.ScaleType.FIT_XY }
            }
        }

        val popup = ReactionPopup(this, config) { position -> true.also {
            // position = -1 if no selection
            Toast.makeText(this,"Postion: "+position,Toast.LENGTH_LONG ).show()
        } }

        likeButton.setOnClickListener {
            likeButton.setOnTouchListener(popup);

        }

    }
}