package com.muhammedturgut.anndakuryeappmt.ui.frgamnet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammedturgut.anndakuryeapp.ui.Adapter.CategoryViewAdapter
import com.muhammedturgut.anndakuryeappmt.R
import com.muhammedturgut.anndakuryeappmt.databinding.FragmentMainPageBinding
import com.muhammedturgut.anndakuryeappmt.ui.Adapter.MostPopularAdapter
import com.muhammedturgut.anndakuryeappmt.ui.Model.MostPopularModel
import com.muhammedturgut.anndakuryeappmt.ui.viewModel.MainPageViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class MainPageFragment : Fragment() {

    private lateinit var binding: FragmentMainPageBinding
    private lateinit var viewModel: MainPageViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMainPageBinding.inflate(inflater,container,false)
// ViewModel burada başlatılıyor ✅


        viewModel.foodList.observe(viewLifecycleOwner) {
            val foodAdapter = MostPopularAdapter(requireContext(),it,viewModel)
            binding.recyclerViewMostPopuler.adapter = foodAdapter
        }
        binding.recyclerViewMostPopuler.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

        val foodCategoryViewAdapter = CategoryViewAdapter(requireContext(),categoryList)
        binding.recyclerViewCategory.adapter = foodCategoryViewAdapter
        binding.recyclerViewCategory.layoutManager = GridLayoutManager(requireContext(), 2)


        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: MainPageViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.foodList
    }

}

val categoryList = listOf(
    MostPopularModel(R.drawable.kahvalti,"Kahvaltı"),
    MostPopularModel(R.drawable.icecek,"İçecek"),
    MostPopularModel(R.drawable.hamburger,"Fast Food"),
    MostPopularModel(R.drawable.salata,"Salata"),
    MostPopularModel(R.drawable.baklava,"Tatlı"),
    MostPopularModel(R.drawable.kebabp,"Izgara"),
    MostPopularModel(R.drawable.corba,"Çorba"),
    MostPopularModel(R.drawable.kahve,"Kahve"),
)