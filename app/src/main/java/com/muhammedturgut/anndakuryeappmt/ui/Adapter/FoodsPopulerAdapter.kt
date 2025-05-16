package com.muhammedturgut.anndakuryeappmt.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muhammedturgut.anndakuryeappmt.databinding.FoodMostPopulerRowBinding
import com.muhammedturgut.anndakuryeappmt.ui.Model.FoodPagePopulerModel

class FoodsPopulerAdapter(var mContext: Context,
                          var list: List<FoodPagePopulerModel>) : RecyclerView.Adapter<FoodsPopulerAdapter.RecyclerRwo>() {

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

        t.foodName.text = foods.name
        t.foodPrice.text = "${foods.price}TL"
        t.foodScore.text = foods.score.toString()
        t.foodShope.text = foods.shopeNmae
        t.time.text = "${foods.time}Dk"
        t.foodImage.setImageResource(foods.imge)
    }

    override fun getItemCount(): Int {
        return list.size
    }


}