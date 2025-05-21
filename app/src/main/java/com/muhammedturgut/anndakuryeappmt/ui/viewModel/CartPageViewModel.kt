package com.muhammedturgut.anndakuryeappmt.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.muhammedturgut.anndakuryeapp.data.repo.FoodRepository
import com.muhammedturgut.anndakuryeappmt.data.entity.CartFood
import com.muhammedturgut.anndakuryeappmt.data.repo.SaveRepostiory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CartPageViewModel @Inject constructor(var foodRepository: FoodRepository,saveRepostiory: SaveRepostiory) : ViewModel(){
    var foodCartList = MutableLiveData<List<CartFood>>()


    fun foodCartLoad(kullanici_adi: String){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                foodCartList.value = foodRepository.getAllCartFoodLoad(kullanici_adi)
            }catch (e: Exception){

            }
        }
    }
}