package com.muhammedturgut.anndakuryeappmt.retrofit

import com.muhammedturgut.anndakuryeappmt.data.entity.FoodRequest
import com.muhammedturgut.anndakuryeappmt.data.entity.GetAllFoods
import retrofit2.http.GET

interface FoodDao {

    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun getAllFoodLoad() : FoodRequest
}