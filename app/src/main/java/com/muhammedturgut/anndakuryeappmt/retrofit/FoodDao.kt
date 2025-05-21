package com.muhammedturgut.anndakuryeappmt.retrofit

import com.muhammedturgut.anndakuryeappmt.data.entity.CRUDRequest
import com.muhammedturgut.anndakuryeappmt.data.entity.CartFood
import com.muhammedturgut.anndakuryeappmt.data.entity.FoodRequest
import com.muhammedturgut.anndakuryeappmt.data.entity.FoodRequestCart
import com.muhammedturgut.anndakuryeappmt.data.entity.GetAllFoods
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface FoodDao {

    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun getAllFoodLoad() : FoodRequest


    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    suspend fun addToCartFood(
        @Field("yemek_adi") yemekAdi: String,
        @Field("yemek_resim_adi") yemekResimAdi: String,
        @Field("yemek_fiyat") yemekFiyat: Int,
        @Field("yemek_siparis_adet") siparisAdet: Int,
        @Field("kullanici_adi") kullaniciAdi: String
    ): CRUDRequest

    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    suspend fun getToCartFood(@Field("kullanici_adi") kullanici_adi: String): FoodRequestCart

    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    suspend fun subtractToFoodCart( @Field("sepet_yemek_id") sepet_yemek_id: Int,
                                    @Field("kullanici_adi") kullanici_adi: String)



}