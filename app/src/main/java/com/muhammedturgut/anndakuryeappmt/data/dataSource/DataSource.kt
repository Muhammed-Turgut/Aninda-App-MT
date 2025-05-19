package com.muhammedturgut.anndakuryeappmt.data.dataSource

import com.muhammedturgut.anndakuryeappmt.data.entity.User
import com.muhammedturgut.anndakuryeappmt.room.UserDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DataSource(var userDao: UserDao) {
    suspend fun save(userName:String,userEmail:String, userPassword:String){
        val newSave = User(0,userName,userEmail,userPassword)
        userDao.save(newSave)
    }

    suspend fun update(id:Int,userName:String,userEmail:String, userPassword:String){
        val updateSave = User(id,userName,userEmail, userPassword)
        userDao.update(updateSave)
    }

    suspend fun deleteUser(id:Int){
        val deleteSave = User(id,"","","")
        userDao.signOut(deleteSave)
    }

    suspend fun getUser(): User? = withContext(Dispatchers.IO){

        return@withContext userDao.getUser()
    }
}