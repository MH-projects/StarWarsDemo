package com.mh.test.view.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.mh.domain.model.StarWarsModel
import com.mh.test.databinding.ItemProductBinding
import com.squareup.picasso.Picasso

class StarWarsViewHolder(
    private val binding: ItemProductBinding
) : RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(person: StarWarsModel, onProductClickListener: (StarWarsModel) -> Unit) {
        binding.itemProduct.setOnClickListener { onProductClickListener(person) }

        Picasso.with(binding.ivPerson.context)
            .load(person.image)
            .resize(600, 600)
            .centerInside()
            .into(binding.ivPerson)

        binding.tvName.text = person.name
        binding.tvGender.text = "Gender: ${person.gender}"
        binding.tvSpecie.text = "Specie: ${person.species}"
    }
}