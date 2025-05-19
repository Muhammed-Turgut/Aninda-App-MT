package com.muhammedturgut.anndakuryeappmt.ui.frgamnet

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.muhammedturgut.anndakuryeappmt.R
import com.muhammedturgut.anndakuryeappmt.activity.MainActivity
import com.muhammedturgut.anndakuryeappmt.databinding.FragmentSplasScreenBinding
import com.muhammedturgut.anndakuryeappmt.ui.viewModel.LoginScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplasScreenFragment : Fragment() {

    private var _binding: FragmentSplasScreenBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginScreenViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplasScreenBinding.inflate(inflater, container, false)

        // Ekran görüntüsünü engelle
        requireActivity().window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Kullanıcı bilgisini yükle
        viewModel.user.observe(viewLifecycleOwner) { user ->
            Handler(Looper.getMainLooper()).postDelayed({
                if (!isAdded) return@postDelayed // Fragment hala eklenmiş mi kontrolü

                if (user == null) {
                    findNavController().navigate(R.id.loginScreenFragment)
                } else {
                    val intent = Intent(requireContext(), MainActivity::class.java)
                    startActivity(intent)
                    requireActivity().finish()
                }
            }, 3000)
        }

        viewModel.loadUser()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // memory leak önlemek için binding null'lanmalı
    }
}
