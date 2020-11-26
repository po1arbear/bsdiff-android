package com.example.myapplication

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream


class MainActivity : AppCompatActivity() {
    private val REQUEST_EXTERNAL_STORAGE = 1
    private val PERMISSIONS_STORAGE = arrayOf(
        Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.btn).setOnClickListener {

//            verifyStoragePermissions(this)
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }


    private fun applyAPK() {


//        var oldpath = (Environment.getExternalStorageDirectory().absolutePath + File.separator
//                + "bs_old.apk")

        // 获取旧apk路径   applicationInfo.sourceDir
        var oldpath = applicationInfo.sourceDir;

        var newpath = (Environment.getExternalStorageDirectory().absolutePath + File.separator
                + "composed_apk.apk")

        var patchpath = (Environment.getExternalStorageDirectory().absolutePath + File.separator
                + "bs_patch")


//       val patchpath = stream2file(
//            Environment.getExternalStorageDirectory().absolutePath,
//            "bs_patch",
//            this
//        ).absolutePath

        Log.d("bstest", "patchpath---->$patchpath  oldpath---->$oldpath   newpath---->$newpath");



        PatchUtils.patch(oldpath, newpath, patchpath);

    }


    private fun stream2file(path: String, fileName: String, context: Context): File {

        val `is`: InputStream = context.assets.open("bs_patch")
        val dir: File = File(path)
        if (!dir.exists()) dir.mkdirs()
        val file: File = File(path, fileName)
        if (!file.exists()) file.createNewFile()
        val os = FileOutputStream(file)
        val buffer = ByteArray(1024)
        var length = -1
        var currentLength: Long = 0
        while (`is`.read(buffer).also { length = it } != -1) {
            os.write(buffer, 0, length)
            currentLength += length.toLong()
        }

        return file


    }


    private fun verifyStoragePermissions(activity: Activity?) {
        try {
            //检测是否有写的权限
            val permission = ActivityCompat.checkSelfPermission(
                activity!!,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // 没有写的权限，去申请写的权限，会弹出对话框
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, 3)

            } else {
                applyAPK()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 3) {

            applyAPK()


        }


    }

}