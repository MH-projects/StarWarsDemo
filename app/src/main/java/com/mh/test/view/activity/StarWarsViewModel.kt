package com.mh.test.view.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mh.domain.use_case.GetStarWarsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StarWarsViewModel @Inject constructor(
    private val starWarsUseCase: GetStarWarsUseCase
) : ViewModel() {

    private val _starWarsStatus = MutableLiveData<StarWarsStatus>()
    val starWarsStatus: LiveData<StarWarsStatus> get() = _starWarsStatus

    val searchPerson = MutableLiveData<String>()

    fun getStarWars() {

        viewModelScope.launch {
            _starWarsStatus.postValue(StarWarsStatus.LOADING)
            val result = starWarsUseCase()

            if (result.isEmpty()) {
                _starWarsStatus.postValue(StarWarsStatus.FAILURE("No hay personajes"))
            } else {
                _starWarsStatus.postValue(StarWarsStatus.SUCCESS(result))
            }
        }
    }


}