package com.muhammedturgut.anndakuryeappmt.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.muhammedturgut.anndakuryeappmt.data.entity.GetAllFoods
import com.muhammedturgut.anndakuryeappmt.databinding.FoodMostPopulerRowBinding
import com.muhammedturgut.anndakuryeappmt.ui.Model.FoodPagePopulerModel
import com.muhammedturgut.anndakuryeappmt.ui.viewModel.FoodPageViewModel
import com.muhammedturgut.anndakuryeappmt.ui.viewModel.LoginScreenViewModel

class FoodsPopulerAdapter(var mContext: Context,
                          var list: List<GetAllFoods>,
                          var viewModel: FoodPageViewModel,
                          var userView: LoginScreenViewModel) : RecyclerView.Adapter<FoodsPopulerAdapter.RecyclerRwo>() {

    inner class RecyclerRwo(var design: FoodMostPopulerRowBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup,
        viewType: Int
    ): RecyclerRwo {
        val design = FoodMostPopulerRowBinding.inflate(LayoutInflater.from(mContext), parent,false)
        return RecyclerRwo(design)
    }

    override fun onBindViewHolder(holder: RecyclerRwo,
        position: Int
    ) {
        val foods =list.get(position)
        val t = holder.design

        t.foodName.text = foods.yemek_adi
        t.foodPrice.text = "${foods.yemek_fiyat}TL"
        t.foodScore.text = foods.yemek_fiyat.toString()
        t.foodShope.text = "Usta Döner"
        t.time.text = "30Dk"
        showeImage(foods.yemek_resim_adi,t.foodImage,mContext)

        t.addToCartFood.setOnClickListener {
            println("Ekleme tuşuna basıldı")
            viewModel.addToCartFood(yemekAdi = foods.yemek_adi,
                yemekResimAdi =foods.yemek_resim_adi,
                yemekFiyat = foods.yemek_fiyat,
                siparisAdet = t.orderQuantity.toString().toIntOrNull() ?:1,
                kullaniciAdi = userView.user.value!!.userEmail)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun showeImage(imageName:String, imageView: ImageView,mContext: Context){
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/$imageName"
        Glide.with(mContext)
            .load(url)
            .circleCrop()
            .into(imageView)
    }


}