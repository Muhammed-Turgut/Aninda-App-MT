package com.muhammedturgut.anndakuryeappmt.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.muhammedturgut.anndakuryeappmt.R
import com.muhammedturgut.anndakuryeappmt.databinding.ActivityLoginScreensBinding
import com.muhammedturgut.anndakuryeappmt.ui.frgamnet.MainPageFragment
import com.muhammedturgut.anndakuryeappmt.ui.frgamnet.SplasScreenFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginScreens : AppCompatActivity() {
    private lateinit var binding: ActivityLoginScreensBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginScreensBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }
}