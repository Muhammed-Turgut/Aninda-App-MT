package com.muhammedturgut.anndakuryeappmt.data.repo

import com.muhammedturgut.anndakuryeappmt.data.dataSource.DataSource
import com.muhammedturgut.anndakuryeappmt.data.entity.User


class SaveRepostiory(var saveDataSource: DataSource) {

    suspend fun save(userName:String,userEmail:String, userPassword:String){ saveDataSource.save(userName,userEmail,userPassword)}

    suspend fun update(id:Int,userName:String,userEmail:String, userPassword:String) = saveDataSource.update(id,userName,userEmail, userPassword)

    suspend fun signOut(saveId:Int) = saveDataSource.deleteUser(saveId)

    suspend fun userSave(): User? = saveDataSource.getUser()

    suspend fun getUserOrNull(): User? = saveDataSource.getUser()
}