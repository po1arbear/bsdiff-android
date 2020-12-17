package com.example.myapplication.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 *@Description:
 *@Author: xiongzhuang@fcbox.com
 *@Date:   2020/12/17 5:51 PM
 *@License: Copyright Since 2020 Hive Box Technology. All rights reserved.
 *@Notice: This content is limited to the internal circulation of Hive Box,
 * and it is prohibited to leak or used for other commercial purposes.
 */

fun ViewModel.launchIO(block: suspend CoroutineScope.() -> Unit) = run {
    viewModelScope.launch {
        withContext(Dispatchers.IO) {
            block()
        }
    }
}

