package com.example.myapplication.mvvm

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

/**
 *@Description:
 *@Author: xiongzhuang@fcbox.com
 *@Date:   2020/12/17 2:27 PM
 *@License: Copyright Since 2020 Hive Box Technology. All rights reserved.
 *@Notice: This content is limited to the internal circulation of Hive Box,
 * and it is prohibited to leak or used for other commercial purposes.
 */

fun <T> LifecycleOwner.observe(liveData: MutableLiveData<T>, observer: Observer<in T>) {
    liveData.observe(this, observer)
}