package com.muhammedturgut.anndakuryeappmt.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.muhammedturgut.anndakuryeappmt.data.entity.GetAllFoods
import com.muhammedturgut.anndakuryeappmt.databinding.MostPopularRowBinding
import com.muhammedturgut.anndakuryeappmt.ui.Model.MostPopularModel
import com.muhammedturgut.anndakuryeappmt.ui.viewModel.MainPageViewModel


class MostPopularAdapter(var mContext: Context,
                         var productList: List<GetAllFoods>,
                         var viewModel: MainPageViewModel) : RecyclerView.Adapter<MostPopularAdapter.RecyclerRow>() {

    inner class RecyclerRow(var design: MostPopularRowBinding): RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): RecyclerRow {
        val design = MostPopularRowBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return RecyclerRow(design)
    }

    override fun onBindViewHolder(holder: RecyclerRow, position: Int
    ) {
        val food = productList.get(position)
        val t = holder.design
        t.rowFoodName.text = food.yemek_adi

       showeImage(food.yemek_resim_adi,t.rowFoodImage,mContext)

    }
    override fun getItemCount(): Int {
        return productList.size
    }

    fun showeImage(imageName:String, imageView: ImageView,mContext: Context){
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/$imageName"
        Glide.with(mContext)
            .load(url)
            .circleCrop()
            .into(imageView)
    }

}