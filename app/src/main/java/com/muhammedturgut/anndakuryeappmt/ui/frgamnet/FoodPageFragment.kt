package com.muhammedturgut.anndakuryeappmt.ui.frgamnet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammedturgut.anndakuryeappmt.R
import com.muhammedturgut.anndakuryeappmt.databinding.FragmentFoodPageBinding
import com.muhammedturgut.anndakuryeappmt.ui.Adapter.FoodsPageHeaderAdapter
import com.muhammedturgut.anndakuryeappmt.ui.Adapter.FoodsPopulerAdapter
import com.muhammedturgut.anndakuryeappmt.ui.Model.FoodPagePopulerModel
import dagger.hilt.android.AndroidEntryPoint


class FoodPageFragment : Fragment() {

    private lateinit var binding: FragmentFoodPageBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodPageBinding.inflate(layoutInflater, container, false)


        val foodsHeaderAdapter = FoodsPageHeaderAdapter(requireContext(),listFoodsHeader)
        binding.headerFoodsRecyclerView.adapter = foodsHeaderAdapter
        binding.headerFoodsRecyclerView.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL,false)

       val foodsPageMostPopulerAdapter = FoodsPopulerAdapter(requireContext(),lisFoods)
        binding.mostPopulerFoodsRecyclerview.adapter = foodsPageMostPopulerAdapter
        binding.mostPopulerFoodsRecyclerview.layoutManager = GridLayoutManager(requireContext(),2)



        return binding.root
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

val  lisFoods =listOf(
    FoodPagePopulerModel("Tavuk Döner",140,"Usta Döner",R.drawable.doner,30,4),
    FoodPagePopulerModel("Tantuni",150,"Mersin Tantuni",R.drawable.tantuni,30,4),
    FoodPagePopulerModel("Kokoreç",240,"Mehmet Usta",R.drawable.kokorec,30,4),
    FoodPagePopulerModel("Süt",100,"Çiftiçiden",R.drawable.sut,30,4))