package com.ae.rickandmortyapp.ui.characterlist.adapter

import android.view.View
import com.ae.rickandmortyapp.R
import com.ae.rickandmortyapp.databinding.ItemCharacterBinding
import com.ae.rickandmortyapp.dto.ResultsItem
import com.xwray.groupie.viewbinding.BindableItem


class RickAndMortyItem(private val character: ResultsItem): BindableItem<ItemCharacterBinding>() {

    override fun initializeViewBinding(view: View): ItemCharacterBinding {
       return ItemCharacterBinding.bind(view)
    }


    override fun bind(viewBinding: ItemCharacterBinding, position: Int) {
        viewBinding.title.text = character.name
        viewBinding.subtitle.text = character.species
    }

    override fun getLayout(): Int = R.layout.item_character

}