package com.muhammedturgut.anndakuryeappmt.ui.frgamnet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammedturgut.anndakuryeappmt.R
import com.muhammedturgut.anndakuryeappmt.data.entity.User
import com.muhammedturgut.anndakuryeappmt.databinding.FragmentCartPageBinding
import com.muhammedturgut.anndakuryeappmt.room.UserDao
import com.muhammedturgut.anndakuryeappmt.ui.Adapter.FoodCartAdapter
import com.muhammedturgut.anndakuryeappmt.ui.viewModel.CartPageViewModel
import com.muhammedturgut.anndakuryeappmt.ui.viewModel.LoginScreenViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue


@AndroidEntryPoint
class CartPageFragment : Fragment() {
    private lateinit var binding: FragmentCartPageBinding
    private lateinit var viewModel: CartPageViewModel
    private lateinit var viewModelUser: LoginScreenViewModel

    private var userName: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel: CartPageViewModel by viewModels()
        viewModel = tempViewModel

        val tempViewModelUser: LoginScreenViewModel by viewModels()
        viewModelUser = tempViewModelUser
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartPageBinding.inflate(inflater, container, false)

        viewModel.foodCartList.observe(viewLifecycleOwner) {
            val foodAdapter = FoodCartAdapter(
                requireContext(),
                viewModel,
                it,
                viewModelUser
            )
            binding.rcartPageView.adapter = foodAdapter
        }

        binding.rcartPageView.layoutManager = LinearLayoutManager(requireContext())

        viewModelUser.user.observe(viewLifecycleOwner) { user ->
            if (user != null) {
                userName = user.userEmail // Burada güncelliyoruz
                viewModel.foodCartLoad(userName)
                println(userName)
            } else {
                println("Kullanıcı null geldi")
            }
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        println("User name: $userName")

        if (userName.isNotEmpty()) {
            viewModel.foodCartLoad(userName)
            viewModelUser.user
        }
    }
}

