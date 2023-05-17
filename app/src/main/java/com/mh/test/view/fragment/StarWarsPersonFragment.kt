package com.mh.test.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mh.domain.model.StarWarsModel
import com.mh.test.databinding.FragmentStarWarsPersonBinding
import com.mh.test.view.activity.StarWarsStatus
import com.mh.test.view.activity.StarWarsViewModel
import com.mh.test.view.adapter.StarWarsAdapter

class StarWarsPersonFragment : Fragment() {

    private lateinit var binding: FragmentStarWarsPersonBinding
    private val viewModel: StarWarsViewModel by activityViewModels()

    private lateinit var productAdapter: StarWarsAdapter

    private lateinit var persons: List<StarWarsModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStarWarsPersonBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.starWarsStatus.observe(viewLifecycleOwner) {
            if (it != null) {
                when (it) {
                    is StarWarsStatus.LOADING -> {
                        binding.pbLoading.visibility = View.VISIBLE
                    }
                    is StarWarsStatus.SUCCESS -> {
                        binding.pbLoading.visibility = View.GONE
                        setRecyclerView(it.items)
                        persons = it.items
                    }
                    is StarWarsStatus.FAILURE -> {
                        binding.pbLoading.visibility = View.GONE
                    }
                }
            }
        }

        viewModel.searchPerson.observe(viewLifecycleOwner) {
//            productAdapter.filter.filter(it)
            filter(it)
        }
    }

    private fun setRecyclerView(items: List<StarWarsModel>) {

        productAdapter = StarWarsAdapter(items, ::onProductClickListener)

        binding.rvProducts.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = productAdapter
        }
    }

    private fun onProductClickListener(person: StarWarsModel) {
        val action = StarWarsPersonFragmentDirections.toStarWarsPersonDetailFragment(person)
        findNavController().navigate(action)
    }

    private fun filter(text: String) {
        val filteredlist: ArrayList<StarWarsModel> = ArrayList()

        for (item in persons) {
            if (item.name.toLowerCase().contains(text.toLowerCase()) ||
                item.species.toLowerCase().contains(text.toLowerCase())
            ) {
                filteredlist.add(item)
            }
        }
        if (filteredlist.isEmpty()) {
            setRecyclerView(persons)
        } else {
            setRecyclerView(filteredlist)
        }
    }
}