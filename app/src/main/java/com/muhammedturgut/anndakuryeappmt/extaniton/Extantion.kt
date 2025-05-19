package com.muhammedturgut.anndakuryeappmt.extaniton

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController

fun Navigation.gecisYap(it: View,id:Int){
    findNavController(it).navigate(id)
}

fun Navigation.gecisYap(it: View,id: NavDirections){
    findNavController(it).navigate(id)
}