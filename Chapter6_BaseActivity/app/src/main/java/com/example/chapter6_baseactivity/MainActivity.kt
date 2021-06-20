package com.example.chapter6_baseactivity

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.chapter6_baseactivity.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonCamera.setOnClickListener {
            Log.d("camera", "clicked")
            binding.textView.text = "CAMERA Clicked"
            requirePermissions(arrayOf(Manifest.permission.CAMERA), 10)
        }
    }

    override fun permissionGranted(requestCode: Int) {

//        val requestActivity: ActivityResultLauncher<Intent> =
//            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
//                if (activityResult.resultCode == Activity.RESULT_OK) {
//                    Log.d("camera", "picture success")
//                } else {
//                    Log.d("camera", "picture fail")
//                }
//            }

        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//        requestActivity.launch(intent)
        startActivityForResult(intent, requestCode)
    }

    override fun permissionDenied(requestCode: Int) {
//        Toast.makeText(this, "Permission Denied.", Toast.LENGTH_SHORT).show()
        Toast.makeText(baseContext, "Permission Denied.", Toast.LENGTH_SHORT).show()
    }

//     다른 Activity 가 종료되고, 넘겨주는 값을 받아 처리하는 메서드
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("camera", "come back. requestCode: $requestCode")
        if (requestCode == 10) {
            if (resultCode == Activity.RESULT_OK) {
                Log.d("camera", "picture success")
            } else {
                Log.d("camera", "picture fail")
            }
        }
    }

}