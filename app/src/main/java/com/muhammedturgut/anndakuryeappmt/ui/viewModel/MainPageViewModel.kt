package com.muhammedturgut.anndakuryeappmt.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.muhammedturgut.anndakuryeapp.data.repo.FoodRepository
import com.muhammedturgut.anndakuryeappmt.data.dataSource.DataSourceRetrofit
import com.muhammedturgut.anndakuryeappmt.data.entity.GetAllFoods
import com.muhammedturgut.anndakuryeappmt.ui.Model.MostPopularModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel @Inject constructor(var foodRepository: FoodRepository) : ViewModel() {

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

}

