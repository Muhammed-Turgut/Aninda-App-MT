package com.muhammedturgut.anndakuryeapp.ui.viewModel

import androidx.lifecycle.MutableLiveData
import com.muhammedturgut.anndakuryeapp.ui.Model.MostPopularModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainPageViewModel {
    var foodList = MutableLiveData<List<MostPopularModel>>()

    fun foodLoad(){
        CoroutineScope(Dispatchers.Main).launch {

        }
    }
}

