package com.muhammedturgut.anndakuryeappmt.ui.Adapter

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.muhammedturgut.anndakuryeappmt.data.entity.GetAllFoods
import com.muhammedturgut.anndakuryeappmt.databinding.FoodMostPopulerRowBinding
import com.muhammedturgut.anndakuryeappmt.ui.Model.FoodPagePopulerModel
import com.muhammedturgut.anndakuryeappmt.ui.viewModel.FoodPageViewModel
import com.muhammedturgut.anndakuryeappmt.ui.viewModel.LoginScreenViewModel

class FoodsPopulerAdapter(
    var mContext: Context,
    var list: List<GetAllFoods>,
    var viewModel: FoodPageViewModel,
    var userView: LoginScreenViewModel
) : RecyclerView.Adapter<FoodsPopulerAdapter.RecyclerRow>() {

    private val quantities = mutableMapOf<Int, Int>() // position -> quantity

    inner class RecyclerRow(var design: FoodMostPopulerRowBinding) :
        RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerRow {
        val design = FoodMostPopulerRowBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return RecyclerRow(design)
    }

    override fun onBindViewHolder(holder: RecyclerRow, position: Int) {
        val food = list[position]
        val t = holder.design

        // Miktarı çek, eğer yoksa 1
        var quantity = quantities[position] ?: 1
        t.orderQuantity.text = quantity.toString()

        t.buttonArtR.setOnClickListener {
            quantity++
            quantities[position] = quantity
            t.orderQuantity.text = quantity.toString()
        }

        t.buttonAzalt.setOnClickListener {
            if (quantity > 1) {
                quantity--
                quantities[position] = quantity
                t.orderQuantity.text = quantity.toString()
            }
        }

        // Yemek bilgileri
        t.foodName.text = food.yemek_adi
        t.foodPrice.text = "${food.yemek_fiyat} TL"
        t.foodScore.text = food.yemek_fiyat.toString()
        t.foodShope.text = "Usta Döner"
        t.time.text = "30 Dk"

        showImage(food.yemek_resim_adi, t.foodImage, mContext)

        t.addToCartFood.setOnClickListener {
            val userEmail = userView.user.value?.userEmail
            if (!userEmail.isNullOrEmpty()) {
                println("Sepete eklendi: ${food.yemek_adi}, adet: $quantity")
                viewModel.addToCartFood(
                    yemekAdi = food.yemek_adi,
                    yemekResimAdi = food.yemek_resim_adi,
                    yemekFiyat = food.yemek_fiyat,
                    siparisAdet = quantity,
                    kullaniciAdi = userEmail
                )
            } else {
                println("Kullanıcı bilgisi bulunamadı.")
            }
        }


    }

    override fun getItemCount(): Int = list.size

    private fun showImage(imageName: String, imageView: ImageView, context: Context) {
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/$imageName"
        Glide.with(context)
            .load(url)
            .circleCrop()
            .into(imageView)
    }
}
