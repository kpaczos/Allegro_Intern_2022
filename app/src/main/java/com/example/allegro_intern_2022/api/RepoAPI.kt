package com.example.allegro_intern_2022.api

import com.example.allegro_intern_2022.models.RepoResponse
import retrofit2.Response
import retrofit2.http.GET

interface RepoAPI {

    @GET("orgs/allegro/repos?per_page=110")
    suspend fun getRepos(): Response<RepoResponse>
}