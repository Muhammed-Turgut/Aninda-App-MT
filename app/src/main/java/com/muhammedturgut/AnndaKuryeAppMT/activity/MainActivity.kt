package com.muhammedturgut.anndakuryeapp.activity


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.muhammedturgut.AnndaKuryeAppMT.R
import com.muhammedturgut.AnndaKuryeAppMT.databinding.ActivityMainBinding
import com.muhammedturgut.anndakuryeapp.ui.frgamnet.CartPageFragment
import com.muhammedturgut.anndakuryeapp.ui.frgamnet.FoodPageFragment
import com.muhammedturgut.anndakuryeapp.ui.frgamnet.MainPageFragment
import com.muhammedturgut.anndakuryeapp.ui.frgamnet.ProfileFragment
import com.muhammedturgut.anndakuryeapp.ui.frgamnet.WherePageFragment


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            //Bu uygulama il açıldığında hangi fragment gösterilecek onun adıdır.
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, MainPageFragment())
                .commit()
        }

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

    }
}