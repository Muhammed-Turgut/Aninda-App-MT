package com.muhammedturgut.anndakuryeappmt.data.dataSource

import com.muhammedturgut.anndakuryeappmt.data.entity.CartFood
import com.muhammedturgut.anndakuryeappmt.data.entity.GetAllFoods
import com.muhammedturgut.anndakuryeappmt.retrofit.FoodDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.http.Field

class DataSourceRetrofit(var foodDao: FoodDao){
    suspend fun foodLoad(): List<GetAllFoods> = withContext(Dispatchers.IO) {
        return@withContext foodDao.getAllFoodLoad().yemekler }

    suspend fun addToCart(yemekAdi: String,
                          yemekResimAdi: String,
                          yemekFiyat: Int,
                          siparisAdet: Int,
                          kullaniciAdi: String){

        var crudRequest = foodDao.addToCartFood(yemekAdi,yemekResimAdi,yemekFiyat,siparisAdet,kullaniciAdi)

    }

    suspend fun getToCartFood(kullanici_adi:String) : List<CartFood> = withContext(Dispatchers.IO){

        return@withContext foodDao.getToCartFood(kullanici_adi).sepet_yemekler

    }
}