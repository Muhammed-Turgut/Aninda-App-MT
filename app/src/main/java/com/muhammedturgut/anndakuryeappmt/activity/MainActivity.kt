package com.muhammedturgut.anndakuryeappmt.activity


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavHostController
import androidx.navigation.fragment.NavHostFragment

import com.muhammedturgut.anndakuryeappmt.R
import com.muhammedturgut.anndakuryeappmt.databinding.ActivityMainBinding
import com.muhammedturgut.anndakuryeappmt.ui.frgamnet.CartPageFragment
import com.muhammedturgut.anndakuryeappmt.ui.frgamnet.FoodPageFragment
import com.muhammedturgut.anndakuryeappmt.ui.frgamnet.MainPageFragment
import com.muhammedturgut.anndakuryeappmt.ui.frgamnet.ProfileFragment
import com.muhammedturgut.anndakuryeappmt.ui.frgamnet.WherePageFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        println("Activty calisti")
        if (savedInstanceState == null) {
            //Bu uygulama il açıldığında hangi fragment gösterilecek onun adıdır.
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, MainPageFragment())
                .commit()
        }


        // 👇 NavHostFragment olarak cast ediyoruz
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        println("burayi gecti")


        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            var fragment= when(item.itemId){
                R.id.nav_home ->MainPageFragment()
                R.id.nav_food -> FoodPageFragment()

                R.id.nav_where -> WherePageFragment()

                R.id.nav_cart -> CartPageFragment()
                R.id.nav_profile -> ProfileFragment()

                else -> MainPageFragment()
            }

            fragment?.let{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment,it)
                    .commit()
            }
            true
        }


        println("nav calşisti")
        // Detay sayfasında BottomNav'ı gizle
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.detailsFragment -> binding.bottomNavigationView.visibility = View.GONE
                else -> binding.bottomNavigationView.visibility = View.VISIBLE
            }
        }

    }
}
