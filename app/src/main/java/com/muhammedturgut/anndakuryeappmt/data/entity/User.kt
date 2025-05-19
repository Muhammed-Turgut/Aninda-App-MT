package com.muhammedturgut.anndakuryeappmt.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") @NotNull val id:Int,

    @ColumnInfo("userNmae")
    @NotNull val userName:String,

    @ColumnInfo("userEmail")
    @NotNull val userEmail:String,

    @ColumnInfo("userPassword")
    @NotNull val userPassword:String
)
