package com.example.andkotlinproject

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.andkotlinproject.databinding.SongItemBinding

data class Song(val image: Drawable, val title: String, val singer: String)

class SongViewHolder(val binding: SongItemBinding) : RecyclerView.ViewHolder(binding.root)

class SongAdapter(val datas: MutableList<Song>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = SongItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SongViewHolder(binding)
    }

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.setOnClickListener { itemClick?.onClick(it, position) }
        val binding = (holder as SongViewHolder).binding
        val song = datas[position]
        binding.teamName.text = song.singer
        binding.songTitle.text = song.title
        binding.songImg.setImageDrawable(song.image)
    }

    override fun getItemCount(): Int = datas.size
}
