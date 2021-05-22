package com.example.gagagagaandroid.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gagagagaandroid.ListClickListener
import com.example.gagagagaandroid.databinding.ListItemBinding
import com.example.gagagagaandroid.ui.list.ListData

class ListAdapter(
    private val itemClick: ItemClick
): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    private var dataList = mutableListOf<ListData>()

    inner class ListViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(list: ListData) {
            //Glide.with(binding.root).load(list.image).into(binding.profileImg)
            binding.name.text = list.name
            binding.description.text = list.description
            binding.tag1.text = list.tags[0]
            binding.tag2.text = list.tags[0]
            binding.tag3.text = list.tags[0]
            binding.root.setOnClickListener { itemClick.onClick() }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.onBind(dataList[position])
    }

    override fun getItemCount() = dataList.size

    fun replaceList(newList: MutableList<ListData>) {
        dataList = newList.toMutableList()
        notifyDataSetChanged()
    }

    interface ItemClick {
        fun onClick()
    }
}