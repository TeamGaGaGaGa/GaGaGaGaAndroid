package com.example.gagagagaandroid.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gagagagaandroid.HomeListData
import com.example.gagagagaandroid.databinding.ItemHomeBinding

class HomeListAdapter: RecyclerView.Adapter<HomeListAdapter.HomeListViewHolder>() {
    val homeList = mutableListOf<HomeListData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListViewHolder {
        val binding = ItemHomeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return HomeListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeListViewHolder, position: Int) {
        holder.onBind(homeList[position])
    }

    override fun getItemCount(): Int = homeList.size

    class HomeListViewHolder(
        private val binding: ItemHomeBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(homeListData: HomeListData) {
            binding.name.text = homeListData.name
            binding.completeResult.text = "{homeListData.place}에서 만난 {homeListData.face}"
            binding.tag1.text = homeListData.part
            binding.tag2.text = homeListData.mbti
            binding.tag3.text = homeListData.ybob
        }
    }
}