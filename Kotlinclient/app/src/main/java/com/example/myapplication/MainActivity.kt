package com.example.myapplication

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import java.io.IOException
import java.io.InputStream

class MainActivity : AppCompatActivity() {


    private var digitClassifier = Classifier(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        digitClassifier
            .initialize()
            .addOnFailureListener { e -> Log.e(TAG, "Error to setting up digit classifier.", e) }


        val bitmap = getAssetImage("zero.PNG")

        var predict: Int? = null


        while (true) {
            if ((bitmap != null) && (digitClassifier.isInitialized)) {
                val str = digitClassifier
                    .classifyAsync(bitmap)

                Log.e("predic",str )
            }

        }

    }

    fun getAssetImage(path: String): Bitmap? {

        val assetManager = applicationContext.assets
        val istr: InputStream
        var bitmap: Bitmap? = null
        try {
            istr = assetManager.open("fox.jpg")
            bitmap = BitmapFactory.decodeStream(istr)
            bitmap = Bitmap.createScaledBitmap(bitmap, 28, 28, true)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return bitmap
    }
    override fun onDestroy() {
        digitClassifier.close()
        super.onDestroy()
    }
    companion object {
        private const val TAG = "MainActivity"
    }

}
