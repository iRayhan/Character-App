package com.irayhan.characterapplication.core

class AppConstants {

    companion object {
        private const val API_PROTOCOL = "https"
        private const val API_DOMAIN = "hp-api.herokuapp.com/api/characters"
        const val API_URL = "$API_PROTOCOL://$API_DOMAIN/"
    }
}