package com.muhammedturgut.anndakuryeappmt.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object{
        fun getClient(basUrl:String): Retrofit{
            return Retrofit.Builder()
                .baseUrl(basUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}