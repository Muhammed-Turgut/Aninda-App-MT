package com.muhammedturgut.anndakuryeappmt.ui.frgamnet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammedturgut.anndakuryeappmt.R
import com.muhammedturgut.anndakuryeappmt.databinding.FragmentFoodPageBinding
import com.muhammedturgut.anndakuryeappmt.ui.Adapter.FoodsPageHeaderAdapter
import com.muhammedturgut.anndakuryeappmt.ui.Adapter.FoodsPopulerAdapter
import com.muhammedturgut.anndakuryeappmt.ui.Model.FoodPagePopulerModel
import com.muhammedturgut.anndakuryeappmt.ui.viewModel.FoodPageViewModel
import com.muhammedturgut.anndakuryeappmt.ui.viewModel.LoginScreenViewModel
import com.muhammedturgut.anndakuryeappmt.ui.viewModel.MainActivtyStarViewModel
import com.muhammedturgut.anndakuryeappmt.ui.viewModel.MainPageViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class FoodPageFragment : Fragment() {

    private lateinit var binding: FragmentFoodPageBinding
    private lateinit var viewModel: FoodPageViewModel
    private lateinit var viewModelUser: LoginScreenViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodPageBinding.inflate(layoutInflater, container, false)


        val foodsHeaderAdapter = FoodsPageHeaderAdapter(requireContext(),listFoodsHeader)
        binding.headerFoodsRecyclerView.adapter = foodsHeaderAdapter
        binding.headerFoodsRecyclerView.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL,false)

       viewModel.foodList.observe(viewLifecycleOwner) {
           val foodAdapter = FoodsPopulerAdapter(requireContext(),it,viewModel,viewModelUser)
           binding.mostPopulerFoodsRecyclerview.adapter = foodAdapter
       }

        binding.mostPopulerFoodsRecyclerview.layoutManager = GridLayoutManager(requireContext(),2)



        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: FoodPageViewModel by viewModels()
        viewModel = tempViewModel

        val tempViewModelUser: LoginScreenViewModel by viewModels()
        viewModelUser = tempViewModelUser
    }

    override fun onResume() {
        super.onResume()
        viewModel.foodList
        viewModelUser.user
    }
}

 val listFoodsHeader = listOf(
     FoodHeaderModel("Tavuk Döner"),
     FoodHeaderModel("Tantuni"),
     FoodHeaderModel("Süt"),
     FoodHeaderModel("Döner"),
     FoodHeaderModel("Suşi"),
     FoodHeaderModel("Lahmacun"),
     FoodHeaderModel("Şeker"),
     FoodHeaderModel("İçecekler"))

data class FoodHeaderModel(val name:String)

