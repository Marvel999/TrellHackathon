package com.marvel999.trellhackathon.Fragments

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.marvel999.trellhackathon.R
import com.marvel999.trellhackathon.utils.CheckVideoConstants
import com.marvel999.trellhackathon.utils.CheckVideoUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import java.net.HttpURLConnection
import java.net.URL


class CheckVideoFragment : Fragment() {


    private lateinit var viewModel: CheckVideoViewModel
    private lateinit var result:TextView;
    private lateinit var nextBtn:ImageView;
    private lateinit var portrait:ImageView;
    private lateinit var landscape:ImageView;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.check_video_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CheckVideoViewModel::class.java)

        val videoUrl="https://www.youtube.com/embed/qvcgjPdYZ6E";




        portrait.setOnClickListener {
            val bit=BitmapFactory.decodeResource(context?.getResources(),
                    R.drawable.potrate);

            val isPortrait=CheckVideoUtils.portrait(bit.width,bit.height);

            val mode=CheckVideoUtils.getMode(isPortrait)

            Toast.makeText(this.requireContext(),""+mode,Toast.LENGTH_LONG).show()
            setText("Width=${bit.width}\n"+"Height=${bit.height}\n"+mode);

        }
        landscape.setOnClickListener {
            val bit=BitmapFactory.decodeResource(context?.getResources(),
                    R.drawable.landscape);

            val isPortrait=CheckVideoUtils.portrait(bit.width,bit.height);

            val mode=CheckVideoUtils.getMode(isPortrait);

            Toast.makeText(this.requireContext(),""+mode,Toast.LENGTH_LONG).show()
            setText("Width=${bit.width}\n"+"Height=${bit.height}\n"+mode);
        }

        nextBtn.setOnClickListener{
            findNavController().navigate(R.id.action_videoFragment)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        result=view.findViewById(R.id.result)
        portrait=view.findViewById(R.id.portrait)
        landscape=view.findViewById(R.id.landscape)
        nextBtn=view.findViewById(R.id.next_btn)

    }

    private fun setText(str:String){
        result.setText(str)
    }




}