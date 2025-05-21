package com.muhammedturgut.anndakuryeapp.data.repo

import com.muhammedturgut.anndakuryeappmt.data.dataSource.DataSourceRetrofit
import com.muhammedturgut.anndakuryeappmt.data.entity.CartFood
import com.muhammedturgut.anndakuryeappmt.data.entity.FoodRequestCart
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
    suspend fun addToCartFood(yemekAdi: String,
                              yemekResimAdi: String,
                              yemekFiyat: Int,
                              siparisAdet: Int,
                              kullaniciAdi: String){

        foodDataSource.addToCart(yemekAdi,yemekResimAdi,yemekFiyat,siparisAdet,kullaniciAdi)
    }

    suspend fun getAllCartFoodLoad(kullaniciAdi: String): List<CartFood> {

        return try {
            foodDataSource.getToCartFood(kullaniciAdi)
        } catch (e: Exception) {
            println("repositroy $e")
            emptyList()
        }
    }

    suspend fun subtractToFoodCart(sepet_yemek_id:Int,kullanici_adi: String){
        foodDataSource.subtractToFoodCart(sepet_yemek_id,kullanici_adi)
        getAllCartFoodLoad(kullanici_adi)
    }

}



