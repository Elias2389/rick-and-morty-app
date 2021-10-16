package com.ae.rickandmortyapp.ui.characterlist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ae.rickandmortyapp.common.reponse.Status
import com.ae.rickandmortyapp.databinding.ActivityMainBinding
import com.ae.rickandmortyapp.dto.ResultsItem
import com.ae.rickandmortyapp.ui.characterlist.adapter.RickAndMortyItem
import com.ae.rickandmortyapp.ui.characterlist.viewmodel.CharacterListViewModel
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterListActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val groupAdapter: GroupAdapter<GroupieViewHolder> by lazy {
        GroupAdapter<GroupieViewHolder>()
    }

    private val viewModel: CharacterListViewModel  by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getCharacterList()
    }


    private fun getCharacterList() {
        viewModel.getAllCharacters().observe(this, Observer { result ->
            when(result.status) {
                Status.SUCCESS -> {
                    result.data?.results?.let(::responseSuccess)
                }
                Status.ERROR -> {

                }
                else -> {}
            }
        })
    }

    private fun responseSuccess(resultItems: List<ResultsItem>) {
        val list: List<RickAndMortyItem> = resultItems.map { RickAndMortyItem(it) }
        groupAdapter.addAll(list)
        setupAdapter()
    }

    private fun setupAdapter() {
        binding.characterRv.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@CharacterListActivity)
            adapter = groupAdapter
        }
    }
}

