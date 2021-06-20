package com.example.chapter5_customtextwidget

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class DonghoText: AppCompatTextView {
    private fun process(delimeter: String) {
        val part1 = text.substring(0, 4)
        val part2 = text.substring(4, 6)
        val part3 = text.substring(6)

        setText("$part1 $delimeter $part2 $delimeter $part3")
    }


    constructor(context: Context): super(context) {

    }
    constructor(context: Context, attrs: AttributeSet): super(context, attrs) {
        val typed = context.obtainStyledAttributes(attrs, R.styleable.DonghoText)
        val size = typed.indexCount

        for (i in 0 until size) {
            when(typed.getIndex(i)) {
                R.styleable.DonghoText_delimeter -> {
                    val delimeter = typed.getString(typed.getIndex(i)) ?: "-"
                    process(delimeter)
                }
            }
        }

    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int):
            super(context, attrs, defStyleAttr) {

    }
}