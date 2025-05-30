package com.muhammedturgut.anndakuryeappmt.extaniton

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController



fun View.gecisYap(id: Int) {
    Navigation.findNavController(this).navigate(id)
}

fun View.gecisYap(navDirections: NavDirections) {
    Navigation.findNavController(this).navigate(navDirections)
}
