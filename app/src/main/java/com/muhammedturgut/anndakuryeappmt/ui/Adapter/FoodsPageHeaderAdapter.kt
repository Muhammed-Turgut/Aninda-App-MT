package com.muhammedturgut.anndakuryeappmt.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muhammedturgut.anndakuryeappmt.databinding.FoodsHeaderRowBinding
import com.muhammedturgut.anndakuryeappmt.ui.frgamnet.FoodHeaderModel

class FoodsPageHeaderAdapter(var mContext: Context,
                             var list: List<FoodHeaderModel>): RecyclerView.Adapter<FoodsPageHeaderAdapter.RecyclerRow>() {

    inner class  RecyclerRow(var design: FoodsHeaderRowBinding): RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup,
        viewType: Int
    ): RecyclerRow {
        val design = FoodsHeaderRowBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return RecyclerRow(design)
    }

    override fun onBindViewHolder(holder: RecyclerRow,
        position: Int
    ) {
        val foods = list.get(position)
        val t= holder.design

        t.button.text=foods.name
    }

    override fun getItemCount(): Int {
       return list.size
    }



}