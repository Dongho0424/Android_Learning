package com.example.chapter6_baseactivity

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

abstract class BaseActivity: AppCompatActivity() {
    abstract fun permissionGranted(requestCode: Int)
    abstract fun permissionDenied(requestCode: Int)

    fun requirePermissions(permissions: Array<String>, requestCode: Int) {
        // 마시멜로우 버전 아래면 무조건 승인
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            permissionGranted(requestCode)
        } else {
            // permissions array 에 모든 권한이 승인되었으면 true
            val isAllPermissionGranted = permissions.all {
                checkSelfPermission(it) == PackageManager.PERMISSION_GRANTED
            }

            if (isAllPermissionGranted) {
                permissionGranted(requestCode)
            } else { // 모든 권한이 승인되지 않았으므로 승인할거냐 라고 사용자에게 물어봄
                ActivityCompat.requestPermissions(this, permissions, requestCode)
            }
        }
    }

    // 사용자가 권한을 승인하거나 거부한 뒤 호출되는 메서드
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.all { it == PackageManager.PERMISSION_GRANTED }) {
            permissionGranted(requestCode)
        } else {
            permissionDenied(requestCode)
        }
    }
}