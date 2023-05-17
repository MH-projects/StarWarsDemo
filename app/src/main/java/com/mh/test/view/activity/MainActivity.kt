package com.mh.test.view.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.mh.test.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: StarWarsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.getStarWars()

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

//                val navOptions: NavOptions =
//                    NavOptions.Builder().setPopUpTo(R.id.starWarsPersonFragment, true).build()
//
//                Navigation.findNavController(this@MainActivity, R.id.navHost)
//                    .navigate(R.id.starWarsPersonFragment, null, navOptions)

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.searchPerson.value = newText
                return false
            }
        })
    }
}