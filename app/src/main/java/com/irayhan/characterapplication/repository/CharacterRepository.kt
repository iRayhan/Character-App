package com.irayhan.characterapplication.repository

import com.irayhan.characterapplication.base.BaseRepository
import com.irayhan.characterapplication.networking.APIService

class CharacterRepository(private val api: APIService) : BaseRepository() {

    suspend fun getCharacters() = safeApiCall {
        api.getCharacters()
    }

}