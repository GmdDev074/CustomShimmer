package com.client.customshimmer

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val docContainer = findViewById<LinearLayout>(R.id.docContainer)

        val btnHorizontal = findViewById<Button>(R.id.btnHorizontal)
        val btnCircular = findViewById<Button>(R.id.btnCircular)
        val btnAngle = findViewById<Button>(R.id.btnAngle)
        val btnDots = findViewById<Button>(R.id.btnDots)

        btnHorizontal.setOnClickListener {
            CustomShimmer.clearAll(textView, imageView, docContainer)
            CustomShimmer.showHorizontal(textView, imageView, docContainer)
        }

        btnCircular.setOnClickListener {
            CustomShimmer.clearAll(textView, imageView, docContainer)
            CustomShimmer.showCircular(textView, imageView, docContainer)
        }

        btnAngle.setOnClickListener {
            CustomShimmer.clearAll(textView, imageView, docContainer)
            CustomShimmer.showAngle270(textView, imageView, docContainer)
        }

        btnDots.setOnClickListener {
            CustomShimmer.clearAll(textView, imageView, docContainer)
            CustomShimmer.showDots(textView, imageView, docContainer)
        }
    }
}
