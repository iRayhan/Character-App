package com.irayhan.characterapplication.networking

import com.irayhan.characterapplication.core.AppConstants
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET(AppConstants.API_URL)
    suspend fun getCharacters(): Response<ResponseBody>
}