package com.muhammedturgut.anndakuryeapp.ui.frgamnet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammedturgut.AnndaKuryeAppMT.R
import com.muhammedturgut.AnndaKuryeAppMT.databinding.FragmentMainPageBinding
import com.muhammedturgut.anndakuryeapp.ui.Adapter.MostPopularAdapter
import com.muhammedturgut.anndakuryeapp.ui.Model.MostPopularModel


class MainPageFragment : Fragment() {

    private lateinit var binding: FragmentMainPageBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMainPageBinding.inflate(inflater,container,false)
// ViewModel burada başlatılıyor ✅




        val foodAdapter = MostPopularAdapter(requireContext(),list)
        binding.recyclerViewMostPopuler.adapter = foodAdapter

        binding.recyclerViewMostPopuler.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)


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