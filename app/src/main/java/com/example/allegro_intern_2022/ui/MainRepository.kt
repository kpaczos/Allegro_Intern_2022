package com.example.allegro_intern_2022.ui

import com.example.allegro_intern_2022.api.RepoAPI
import javax.inject.Inject

class MainRepository
    @Inject constructor(private val apiService: RepoAPI){

        suspend fun getRepository() = apiService.getRepos()

}