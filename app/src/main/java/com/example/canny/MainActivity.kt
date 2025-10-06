package com.example.canny

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.canny.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var src: Bitmap? = null
    var dst: Bitmap? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        src = BitmapFactory.decodeResource(resources, R.drawable.mountain)
        dst = src!!.copy(src!!.config ?: Bitmap.Config.ARGB_8888, true)

        binding.imageView5.setImageBitmap(dst)
    }

    fun btnedge(view: android.view.View) {

        edgeDetection(src!!, dst!!)
        binding.imageView5.setImageBitmap(dst)
    }

    /**
     * A native method that is implemented by the 'canny' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    external fun edgeDetection(bitmap1: Bitmap, bitmap2: Bitmap)

    companion object {
        // Used to load the 'canny' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}