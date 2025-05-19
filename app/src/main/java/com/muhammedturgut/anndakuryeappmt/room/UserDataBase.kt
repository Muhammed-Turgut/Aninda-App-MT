package com.muhammedturgut.anndakuryeappmt.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.muhammedturgut.anndakuryeappmt.data.entity.User

@Database(entities = [User::class], version = 1)
abstract class UserDataBase: RoomDatabase() {
    abstract fun getSaveDao(): UserDao
}