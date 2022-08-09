package com.example.chefshark.network.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.chefshark.R
import com.example.chefshark.databinding.LayoutItemLeagueBinding
import com.example.chefshark.network.data.model.League

class LeaguesAdapter(
    var leagues: List<League>
) : RecyclerView.Adapter<LeaguesAdapter.LeaguesViewHolder>() {

    inner class LeaguesViewHolder(val binding: LayoutItemLeagueBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(league: League) {
            binding.league = league
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaguesViewHolder {
        val binding: LayoutItemLeagueBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.layout_item_league,
            parent,
            false
        )
        return LeaguesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LeaguesViewHolder, position: Int) {
        holder.bind(leagues[position])
    }

    override fun getItemCount() = leagues.size
}