package com.example.api_fetch

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val heading = intent.getStringExtra("heading")
        val carsContent = intent.getStringExtra("carscontent")
        val imageId = intent.getIntExtra("imageId", R.drawable.ast)

        val headingTV = findViewById<TextView>(R.id.carsHeading)
        val headingIV = findViewById<ImageView>(R.id.carsImage)
        val carsContentTV = findViewById<TextView>(R.id.carsContent)

        headingTV.text = heading
        carsContentTV.text = carsContent
        headingIV.setImageResource(imageId)
    }
}