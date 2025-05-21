package com.muhammedturgut.anndakuryeappmt.data.entity

data class FoodRequest (var yemekler : List<GetAllFoods>,
    var success:Int)

data class FoodRequestCart(var sepet_yemekler : List<CartFood>,
                           var success:Int)