package com.example.allegro_intern_2022.ui

import com.example.allegro_intern_2022.api.RetrofitInstance

class MainRepository {
    suspend fun getRepos() = RetrofitInstance.api.getRepos()
}