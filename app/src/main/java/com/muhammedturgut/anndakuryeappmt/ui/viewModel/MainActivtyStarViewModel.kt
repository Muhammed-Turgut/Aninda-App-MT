package com.muhammedturgut.anndakuryeappmt.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.muhammedturgut.anndakuryeappmt.data.entity.GetAllFoods

class MainActivtyStarViewModel :ViewModel() {
    private val _selectedFood = MutableLiveData<GetAllFoods>()
    val selectedFood: LiveData<GetAllFoods> get() = _selectedFood

    fun setFood(food: GetAllFoods) {
        _selectedFood.value = food
    }
}