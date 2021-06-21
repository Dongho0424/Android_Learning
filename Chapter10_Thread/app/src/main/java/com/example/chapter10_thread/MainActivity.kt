package com.example.chapter10_thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import com.example.chapter10_thread.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    var total = 0
    var started = false

    // message queue 에서 꺼낸 값을 메인쓰레드에서 처
    val handler = object: Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            val minute = String.format("%02d", total / 60)
            val second = String.format("%02d", total % 60)
            binding.timer.text = "$minute:$second"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonStart.setOnClickListener {
            started = true
            // back ground thread
            thread(start = true) {
                while(started) {
                    Thread.sleep(1000)
                    if (started) {
                        total += 1
                        handler.sendEmptyMessage(0)
                    }
                }
            }
        }

        binding.buttonStop.setOnClickListener {
            if (started) {
                started = false
                total = 0
                binding.timer.text = "00:00"
            }
        }

//        CoroutineScope
    }
}