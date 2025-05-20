package com.muhammedturgut.anndakuryeapp.data.repo

import com.muhammedturgut.anndakuryeappmt.data.dataSource.DataSourceRetrofit
import com.muhammedturgut.anndakuryeappmt.data.entity.GetAllFoods


class FoodRepository(var foodDataSource: DataSourceRetrofit) {


    suspend fun getAllFoodLoad(): List<GetAllFoods> {

        return try {
            foodDataSource.foodLoad()
        } catch (e: Exception) {
            println("repositroy $e")
            emptyList()
        }
    }
}



