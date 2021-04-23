package com.marvel999.trellhackathon.Fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.github.pgreze.reactions.ReactionPopup
import com.github.pgreze.reactions.dsl.reactionConfig
import com.github.pgreze.reactions.dsl.reactions
import com.marvel999.trellhackathon.R
import com.marvel999.trellhackathon.utils.LikeUtil

class LikeFragment : Fragment() {



    private lateinit var viewModel: LikeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.like_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LikeViewModel::class.java)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val likeButton=view.findViewById<Button>(R.id.button);
        val nextBtn=view.findViewById<ImageView>(R.id.next_btn)

        val config = reactionConfig(this.requireContext()) {
            reactions {
                resId    { R.drawable.ic_heart }
                resId    { R.drawable.ic_happy }
                resId    { R.drawable.ic_like }
                reaction { R.drawable.ic_surprised scale ImageView.ScaleType.FIT_XY }
                reaction { R.drawable.ic_sad scale ImageView.ScaleType.FIT_XY }
                reaction { R.drawable.ic_angry scale ImageView.ScaleType.FIT_XY }
            }
        }

        val popup = ReactionPopup(this.requireContext(), config) { position -> true.also {
            // position = -1 if no selection
            if(LikeUtil.getRection(position)!=null)
                Toast.makeText(this.requireContext(), LikeUtil.getRection(position), Toast.LENGTH_LONG ).show();

        } }

        likeButton.setOnClickListener {
            likeButton.setOnTouchListener(popup);

        }

        nextBtn.setOnClickListener{
            findNavController().navigate(R.id.action_checkVideoFragment);
        }
    }

}