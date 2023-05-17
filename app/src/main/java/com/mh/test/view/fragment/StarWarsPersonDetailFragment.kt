package com.mh.test.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.mh.test.databinding.FragmentStarWarsPersonDetailBinding
import com.squareup.picasso.Picasso

class StarWarsPersonDetailFragment : Fragment() {

    private lateinit var binding: FragmentStarWarsPersonDetailBinding
    private val args: StarWarsPersonDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStarWarsPersonDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        args.person.let {
            Picasso.with(binding.ivPerson.context)
                .load(it.image)
                .resize(1200, 600)
                .centerInside()
                .into(binding.ivPerson)

            binding.tvName.text = it.name
            binding.tvGender.text = "Gender: ${it.gender}"
            binding.tvHeight.text = "Height: ${it.height}"
            binding.tvSpecie.text = "Specie: ${it.species}"
        }
    }

}