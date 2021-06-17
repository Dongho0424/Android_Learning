package com.example.chapter4_widgetsprogressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import com.example.chapter4_widgetsprogressbar.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        showProgress(true)
        thread(start = true) {
            Thread.sleep(3000)
            runOnUiThread {
                showProgress(false)
            }
        }

        binding.seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.textView.text = "$progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
//                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
//                TODO("Not yet implemented")
            }
        })
    }

    fun showProgress(show: Boolean) {
        binding.progressLayout.visibility = if(show) View.VISIBLE else View.GONE
        binding.seekBar.visibility = if(show) View.GONE else View.VISIBLE
        binding.textView.visibility = if(show) View.GONE else View.VISIBLE
    }
}

