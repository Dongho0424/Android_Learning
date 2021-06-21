package com.example.chapter5_customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

import android.graphics.RectF

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.chapter5_customview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val customView = CustomView("Hi Dongho!",this)

    }
}


class CustomView(text:String, context: Context): View(context) {
    val text: String
    init {
        this.text = text
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val paint = Paint()
        paint.color = Color.BLACK
        paint.textSize = 100f
        canvas?.drawText(text, 0f, 100f, paint)

        val cyanPaint = Paint().apply {
            style = Paint.Style.FILL
            color = Color.CYAN
        }
        val rectF = RectF(200f, 300f, 450f, 550f)
        canvas?.drawRoundRect(rectF, 50f, 50f, cyanPaint)

    }
}