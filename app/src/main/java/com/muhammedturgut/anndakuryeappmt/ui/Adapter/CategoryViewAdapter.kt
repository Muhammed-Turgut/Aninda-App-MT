package com.muhammedturgut.anndakuryeapp.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.muhammedturgut.anndakuryeappmt.databinding.MainCategoryRowBinding
import com.muhammedturgut.anndakuryeappmt.ui.Model.MostPopularModel

class CategoryViewAdapter(var mContext: Context,
                          var productList: List<MostPopularModel>): RecyclerView.Adapter<CategoryViewAdapter.RecyclerRow>() {

    inner class RecyclerRow(var design : MainCategoryRowBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup,
        viewType: Int
    ): RecyclerRow {
      val design = MainCategoryRowBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return RecyclerRow(design)
    }

    override fun onBindViewHolder(holder: RecyclerRow,
        position: Int
    ) {
       val food = productList.get(position)
        val t = holder.design
        t.textViewFoodCategory.text = food.foodName

        t.imageViewFoodImage.setImageResource(food.image)
    }

    override fun getItemCount(): Int {
        return productList.size
    }



}