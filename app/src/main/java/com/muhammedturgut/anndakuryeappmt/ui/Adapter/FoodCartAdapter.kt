package com.muhammedturgut.anndakuryeappmt.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.muhammedturgut.anndakuryeappmt.data.entity.CartFood
import com.muhammedturgut.anndakuryeappmt.databinding.MyCartRowBinding
import com.muhammedturgut.anndakuryeappmt.ui.viewModel.CartPageViewModel

class FoodCartAdapter(var mContext: Context,
                      var viewModel: CartPageViewModel,
                      var list: List<CartFood>) : RecyclerView.Adapter<FoodCartAdapter.RecyclerRowFood>() {

    inner class RecyclerRowFood(var design: MyCartRowBinding): RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerRowFood {
        val design = MyCartRowBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return RecyclerRowFood(design)
    }

    override fun onBindViewHolder(
        holder: RecyclerRowFood,
        position: Int
    ) {
        val food = list.get(position)
        val t = holder.design

        t.foodNameCart.text = food.yemek_adi
        t.foodPriceCart.text = food.yemek_fiyat.toString()
        t.foodQuentityCart.text = food.yemek_siparis_adet.toString()
        showeImage(food.yemek_resim_adi,t.foodImageCart,mContext)

        t.deleteFoodCart.setOnClickListener {

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