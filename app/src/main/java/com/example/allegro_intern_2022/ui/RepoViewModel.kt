package com.example.allegro_intern_2022.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.allegro_intern_2022.models.RepoResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepoViewModel
@Inject
constructor(private val repository: MainRepository) : ViewModel() {

    private val _response = MutableLiveData<RepoResponse>()
    val repoResponse: LiveData<RepoResponse>
        get() = _response

    init {
        getRecipe()
    }

    private fun getRecipe() = viewModelScope.launch {
        repository.getRepository().let { response ->

            if (response.isSuccessful) {
                _response.postValue(response.body())
            } else {
                Log.d("response", "error: ${response.code()}")
            }
        }
    }


}