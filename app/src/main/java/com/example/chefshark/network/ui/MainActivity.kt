package com.example.chefshark.network.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.chefshark.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val leaguesAdapter: LeaguesAdapter by lazy {
        LeaguesAdapter(listOf())
    }

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.rvLeagues.adapter = leaguesAdapter
        viewModel.getLeagues()
        observeItems()
    }

    private fun observeItems() {
        viewModel.leagues.observe(this) {
            leaguesAdapter.leagues = it
            leaguesAdapter.notifyDataSetChanged()
        }
    }
}