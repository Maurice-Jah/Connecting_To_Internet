package com.example.connectingtointernet.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.connectingtointernet.api.Info
import com.example.connectingtointernet.databinding.ItemRvBinding

class MainAdapter (private val info: List<Info>):RecyclerView.Adapter<MainAdapter.MainViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(info[position])
    }

    inner class MainViewHolder(private val binding: ItemRvBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(info: Info) {
            binding.name.text = info.infoName
            binding.ImageIv.load(info.infoImage)
            binding.species.text = info.infoSpecies
            binding.status.text = info.infoStatus
        }
    }

    override fun getItemCount(): Int {
        return info.size

    }
}