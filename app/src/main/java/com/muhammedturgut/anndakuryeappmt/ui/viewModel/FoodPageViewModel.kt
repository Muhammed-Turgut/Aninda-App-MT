package com.muhammedturgut.anndakuryeappmt.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.muhammedturgut.anndakuryeapp.data.repo.FoodRepository
import com.muhammedturgut.anndakuryeappmt.data.entity.GetAllFoods
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodPageViewModel  @Inject constructor(var foodRepository: FoodRepository) : ViewModel() {
    var foodList = MutableLiveData<List<GetAllFoods>>()


    init {
        foodLoad()
    }

    fun foodLoad(){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                foodList.value = foodRepository.getAllFoodLoad()
            }catch (e: Exception){
                println("bu burası ${e}")
            }
        }
    }

    fun addToCartFood(yemekAdi: String,
                      yemekResimAdi: String,
                      yemekFiyat: Int,
                      siparisAdet: Int,
                      kullaniciAdi: String){

        CoroutineScope(Dispatchers.Main).launch {
            println("Ekleme yapılıyor")
            foodRepository.addToCartFood(yemekAdi,yemekResimAdi,yemekFiyat,siparisAdet,kullaniciAdi)
        }

    }
}