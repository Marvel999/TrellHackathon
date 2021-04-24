package com.marvel999.trellhackathon.Fragments

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import com.marvel999.trellhackathon.R

open class VideoFragment : Fragment() {

    companion object {
        fun newInstance() = VideoFragment()
    }
    val url ="https://www.sample-videos.com/video123/mp4/480/big_buck_bunny_480p_1mb.mp4"
    private lateinit var viewModel: VideoViewModel
//    private lateinit var mediaPlayer: MediaPlayer
    val mediaPlayer = MediaPlayer().apply {
    setDataSource(url)
    prepare() // might take long! (for buffering, etc)
    start()
}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.video_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(VideoViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private val gestureDetector = GestureDetector(object : GestureDetector.SimpleOnGestureListener() {
        override fun onLongPress(e: MotionEvent) {
            mediaPlayer.pause();
        }
    })

     fun onTouchEvent(event: MotionEvent?): Boolean {
         return if (gestureDetector.onTouchEvent(event)) {
             true
         } else {
             if(!mediaPlayer.isPlaying){
                 mediaPlayer.start();
             }
             onTouchEvent(event)
         }
    }

}