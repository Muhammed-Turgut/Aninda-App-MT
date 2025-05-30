package com.muhammedturgut.anndakuryeappmt.ui.frgamnet

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.muhammedturgut.anndakuryeappmt.activity.MainActivity
import com.muhammedturgut.anndakuryeappmt.databinding.FragmentLoginScreenBinding
import com.muhammedturgut.anndakuryeappmt.ui.viewModel.LoginScreenViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class LoginScreenFragment : Fragment() {
    private lateinit var binding: FragmentLoginScreenBinding
    private lateinit var viewModel: LoginScreenViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding= FragmentLoginScreenBinding.inflate(layoutInflater,container,false)

         binding.btnSignUp.setOnClickListener {
             val newUserName = binding.etName.text.toString()
             val newUserEmail = binding.etEmail.text.toString()
             val newUserPassword = binding.etPassword.text.toString()

             if(newUserEmail.isNotEmpty() && newUserEmail.isNotEmpty() && newUserPassword.isNotEmpty()){
                 viewModel.save(newUserName,newUserEmail,newUserPassword)
             }
             else{
                 Toast.makeText(requireContext(),"Lütfen gerekli alanları doldurun", Toast.LENGTH_SHORT).show()
             }
         }

        viewModel.registerResult.observe(viewLifecycleOwner) { isSucces ->
            if(isSucces){
                Toast.makeText(requireContext(), "Kayıt başarılı!", Toast.LENGTH_SHORT).show()
                val intent = Intent(requireContext(), MainActivity::class.java)
                startActivity(intent)
                requireActivity().finish()

            }
            else{
                Toast.makeText(requireContext(), "Kayıt başarısız!", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: LoginScreenViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.user
    }


}