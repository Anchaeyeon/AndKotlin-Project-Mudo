package com.example.andkotlinproject

import android.content.Intent
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

        // btnSee 눌렀을 때 SongActivity로 이동
        binding.btnSee.setOnClickListener {
            val context = binding.root.context
            val intent = Intent(context, SongActivity::class.java)
            intent.putExtra("Gayo_Title", m.title)  // 데이터 전달
            context.startActivity(intent)
        }

        // 아이템 클릭 이벤트 처리
        holder.itemView.setOnClickListener { itemClick?.onClick(it, position) }
    }

    override fun getItemCount(): Int { return datas.size; }
}