package com.mh.test.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mh.domain.model.StarWarsModel
import com.mh.test.databinding.ItemProductBinding

class StarWarsAdapter(
    private var products: List<StarWarsModel>,
    private val onProductClickListener: (StarWarsModel) -> Unit
) : RecyclerView.Adapter<StarWarsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarWarsViewHolder {

        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return StarWarsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StarWarsViewHolder, position: Int) {
        val category = products[position]
        holder.bind(category, onProductClickListener)
    }

    override fun getItemCount(): Int = products.size

}