package com.example.myapplication.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlin.concurrent.thread

/**
 *@Description:
 *@Author: xiongzhuang@fcbox.com
 *@Date:   2020/12/17 11:32 AM
 *@License: Copyright Since 2020 Hive Box Technology. All rights reserved.
 *@Notice: This content is limited to the internal circulation of Hive Box,
 * and it is prohibited to leak or used for other commercial purposes.
 */
class UserViewModel : ViewModel() {
    val userLiveData = MutableLiveData<User>()
    private val userSource: UserSource by lazy { UserSourceImpl() }

    fun getUser() {
        launchIO {
            delay(3000)
            val user = userSource.getUser()
            userLiveData.postValue(user)
        }
    }
}


