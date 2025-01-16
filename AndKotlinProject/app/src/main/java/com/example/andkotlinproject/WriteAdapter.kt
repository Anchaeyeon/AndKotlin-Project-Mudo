package com.example.andkotlinproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.andkotlinproject.databinding.MessageItemBinding

class WriteViewHolder(val binding: MessageItemBinding): RecyclerView.ViewHolder(binding.root)
class WriteAdapter(val datas: MutableList<Write>?): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
            = WriteViewHolder(MessageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    interface ItemClick { fun onClick(view: View, position: Int) }
    var itemClick: ItemClick? = null

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.setOnClickListener { itemClick?.onClick(it, position)}

        val binding = (holder as WriteViewHolder).binding
        var m: Write = datas!![position]
        binding.toPerson.text = m.team
        binding.fromPerson.text = m.name
        binding.content.text = m.text
    }

    override fun getItemCount(): Int { return datas?.size ?: 0 }
}