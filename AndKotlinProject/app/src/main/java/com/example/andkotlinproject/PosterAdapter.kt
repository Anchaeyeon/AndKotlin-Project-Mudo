package com.example.andkotlinproject

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.andkotlinproject.databinding.MainItemBinding

data class Poster(var image: Drawable, var title: String)
class MyViewHolder(val binding: MainItemBinding) : RecyclerView.ViewHolder(binding.root)
class PosterAdapter(val datas: MutableList<Poster>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = MainItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    //리사이클러뷰 아이템 이벤트 처리를 위한 구현
    interface ItemClick { fun onClick(view: View, position: Int) }
    var itemClick: ItemClick? = null

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.setOnClickListener { itemClick?.onClick(it, position) }
        val binding = (holder as MyViewHolder).binding
        var m: Poster = datas[position]
        binding.gayoName.text = m.title
        binding.poster.setImageDrawable(m.image)
    }

    override fun getItemCount(): Int { return datas.size; }
}