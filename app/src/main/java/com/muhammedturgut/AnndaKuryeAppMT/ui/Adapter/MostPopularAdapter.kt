package com.muhammedturgut.anndakuryeapp.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.muhammedturgut.AnndaKuryeAppMT.databinding.MostPopularRowBinding
import com.muhammedturgut.anndakuryeapp.ui.Model.MostPopularModel


class MostPopularAdapter(var mContext: Context,
                         var productList: List<MostPopularModel>) : RecyclerView.Adapter<MostPopularAdapter.RecyclerRow>() {

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
        t.rowFoodName.text = food.foodName

        Glide.with(mContext)
                .load(food.image) // food.image = drawable/int/url olabilir
                .circleCrop()
                .into(t.rowFoodImage)

    }
    override fun getItemCount(): Int {
        return productList.size
    }


}