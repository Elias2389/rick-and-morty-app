package com.ae.rickandmortyapp.ui.characterlist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.ae.rickandmortyapp.R
import com.ae.rickandmortyapp.common.reponse.Status
import com.ae.rickandmortyapp.databinding.ActivityMainBinding
import com.ae.rickandmortyapp.ui.characterlist.viewmodel.CharacterListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterListActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    val viewModel: CharacterListViewModel  by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getCharacterList()
    }

    private fun getCharacterList() {
        viewModel.getAllCharacters().observe(this, Observer { result ->
            when(result.status) {
                Status.SUCCESS -> {
                    result.data?.results?.let {

                    }
                }
                Status.ERROR -> {

                }
                else -> {}
            }
        })
    }
}