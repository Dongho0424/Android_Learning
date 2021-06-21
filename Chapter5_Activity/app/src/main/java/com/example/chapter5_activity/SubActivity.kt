package com.example.chapter5_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chapter5_activity.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {

    val binding by lazy { ActivitySubBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.to1.text = intent.getStringExtra("from1")
        binding.to2.text = "${intent.getIntExtra("from2", 0)}"

        binding.buttonClose.setOnClickListener {
            val returnIntent = Intent().apply {
                putExtra("returnValue", binding.editMessage.text.toString())
            }
            setResult(RESULT_OK, returnIntent)
            finish()
        }
    }
}