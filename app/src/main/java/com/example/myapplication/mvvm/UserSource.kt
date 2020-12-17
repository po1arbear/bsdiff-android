package com.example.myapplication.mvvm

/**
 *@Description:
 *@Author: xiongzhuang@fcbox.com
 *@Date:   2020/12/17 2:14 PM
 *@License: Copyright Since 2020 Hive Box Technology. All rights reserved.
 *@Notice: This content is limited to the internal circulation of Hive Box,
 * and it is prohibited to leak or used for other commercial purposes.
 */
interface UserSource {
    suspend fun getUser(): User
}


class UserSourceImpl : UserSource {
    override suspend fun getUser(): User {
        return User()
    }
}