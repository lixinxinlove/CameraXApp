package com.lixinxinlove.cameraxapp

import android.Manifest
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lixinxinlove.cameraxapp.databinding.ActivityWelcomeBinding
import com.permissionx.guolindev.PermissionX

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initEvent()


        startActivity(Intent(this, CameraActivity::class.java))
    }


    private fun initEvent() {
        binding.loginBtn.setOnClickListener {

            requestPermissions()
        }
    }

    private fun requestPermissions() {
        PermissionX
            .init(this)
            .permissions(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA,
                Manifest.permission.RECORD_AUDIO
            ).onExplainRequestReason { scope, deniedList ->
                scope.showRequestReasonDialog(deniedList, "ni meid", "llll", "")
            }
            .request { allGranted, grantedList, deniedList ->

                if (allGranted) {

                    startActivity(Intent(this, CameraActivity::class.java))
                } else {

                }
            }
    }
}