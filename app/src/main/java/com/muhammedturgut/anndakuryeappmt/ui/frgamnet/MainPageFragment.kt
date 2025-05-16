package com.muhammedturgut.anndakuryeappmt.ui.frgamnet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammedturgut.anndakuryeapp.ui.Adapter.CategoryViewAdapter
import com.muhammedturgut.anndakuryeappmt.R
import com.muhammedturgut.anndakuryeappmt.databinding.FragmentMainPageBinding
import com.muhammedturgut.anndakuryeappmt.ui.Adapter.MostPopularAdapter
import com.muhammedturgut.anndakuryeappmt.ui.Model.MostPopularModel


class MainPageFragment : Fragment() {

    private lateinit var binding: FragmentMainPageBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMainPageBinding.inflate(inflater,container,false)
// ViewModel burada başlatılıyor ✅




        val foodMostPopularAdapterAdapter = MostPopularAdapter(requireContext(),list)
        binding.recyclerViewMostPopuler.adapter = foodMostPopularAdapterAdapter
        binding.recyclerViewMostPopuler.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

        val foodCategoryViewAdapter = CategoryViewAdapter(requireContext(),categoryList)
        binding.recyclerViewCategory.adapter = foodCategoryViewAdapter
        binding.recyclerViewCategory.layoutManager = GridLayoutManager(requireContext(), 2)


        return binding.root
    }

}
val list = listOf(
    MostPopularModel(R.drawable.sut, "Süt"),
    MostPopularModel(R.drawable.doner, "Döner"),
    MostPopularModel(R.drawable.camasir_suyu, "Çamaşır Suyu"),
    MostPopularModel(R.drawable.ekmek, "Ekmek"),
    MostPopularModel(R.drawable.cerez, "Çerez"),
    MostPopularModel(R.drawable.kokorec, "Kokoreç"),
    MostPopularModel(R.drawable.tantuni, "Tantuni")
)

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