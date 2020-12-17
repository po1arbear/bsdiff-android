package com.example.myapplication.mvvm

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

/**
 *@Description:
 *@Author: xiongzhuang@fcbox.com
 *@Date:   2020/12/17 11:28 AM
 *@License: Copyright Since 2020 Hive Box Technology. All rights reserved.
 *@Notice: This content is limited to the internal circulation of Hive Box,
 * and it is prohibited to leak or used for other commercial purposes.
 */
class UserActivity : AppCompatActivity() {
    private val viewModel: UserViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
//        viewModel.getUser()
        viewModel.userLiveData.observe(this, {
            Toast.makeText(this, "getUserIn", Toast.LENGTH_LONG).show()

        })

        observe(viewModel.userLiveData) {

        }

        findViewById<View>(R.id.btn_get_user).setOnClickListener {
            viewModel.getUser()
        }
    }
}