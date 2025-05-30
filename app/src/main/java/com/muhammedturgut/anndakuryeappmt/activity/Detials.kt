package com.muhammedturgut.anndakuryeappmt.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.muhammedturgut.anndakuryeappmt.R
import com.muhammedturgut.anndakuryeappmt.databinding.ActivityDetialsBinding

class Detials : AppCompatActivity() {
    private lateinit var binding: ActivityDetialsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetialsBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}