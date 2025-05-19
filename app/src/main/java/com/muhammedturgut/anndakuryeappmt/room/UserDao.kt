package com.muhammedturgut.anndakuryeappmt.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.muhammedturgut.anndakuryeappmt.data.entity.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user WHERE id = 1 LIMIT 1")
    suspend fun getUser(): User?

    @Insert
    suspend fun save(save: User)

    @Delete()
    suspend fun signOut(save: User)

    @Update
    suspend fun update(save: User)
}