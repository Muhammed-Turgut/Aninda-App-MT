package com.muhammedturgut.anndakuryeappmt.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.muhammedturgut.anndakuryeapp.data.repo.FoodRepository
import com.muhammedturgut.anndakuryeappmt.data.dataSource.DataSource
import com.muhammedturgut.anndakuryeappmt.data.dataSource.DataSourceRetrofit
import com.muhammedturgut.anndakuryeappmt.data.repo.SaveRepostiory
import com.muhammedturgut.anndakuryeappmt.retrofit.ApiUtils
import com.muhammedturgut.anndakuryeappmt.retrofit.FoodDao
import com.muhammedturgut.anndakuryeappmt.room.UserDao
import com.muhammedturgut.anndakuryeappmt.room.UserDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideSaveRepostory(userDataSource: DataSource): SaveRepostiory{
        return SaveRepostiory(userDataSource)
    }

    @Provides
    @Singleton
    fun provideSaveDataSource(userDao: UserDao): DataSource{
        return DataSource(userDao)
    }

    @Provides
    @Singleton
    fun provideSaveDao(@ApplicationContext context: Context): UserDao{

       val dataBase = Room.databaseBuilder(context, UserDataBase::class.java,"userDb.db")
           .createFromAsset("userDb.db")
           .build()

        return dataBase.getSaveDao()
    }

    @Provides
    @Singleton
    fun provideFoodRepository(foodDataSource: DataSourceRetrofit) : FoodRepository{
        return FoodRepository(foodDataSource)
    }

    @Provides
    @Singleton
    fun provideFoodDataSource(foodDao: FoodDao) : DataSourceRetrofit {
        return DataSourceRetrofit(foodDao)
    }

    @Provides
    @Singleton
    fun provideFoodDao() : FoodDao {
        return ApiUtils.getFoodDao()
    }
}