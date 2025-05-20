package com.muhammedturgut.anndakuryeappmt.data.dataSource

import com.muhammedturgut.anndakuryeappmt.data.entity.GetAllFoods
import com.muhammedturgut.anndakuryeappmt.retrofit.FoodDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DataSourceRetrofit(var foodDao: FoodDao){
    suspend fun foodLoad(): List<GetAllFoods> = withContext(Dispatchers.IO) {
        return@withContext foodDao.getAllFoodLoad().yemekler

    }
}