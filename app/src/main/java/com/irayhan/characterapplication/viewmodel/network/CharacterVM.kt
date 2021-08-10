package com.irayhan.characterapplication.viewmodel.network


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irayhan.characterapplication.repository.CharacterRepository
import com.irayhan.characterapplication.utils.DataState
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Response

class CharacterVM(private val repository: CharacterRepository) : ViewModel() {

    private val _getCharactersResponse: MutableLiveData<DataState<Response<ResponseBody>>> = MutableLiveData()
    val getCharactersResponse: LiveData<DataState<Response<ResponseBody>>> get() = _getCharactersResponse

    fun getCharacters() = viewModelScope.launch {
        _getCharactersResponse.value = DataState.Loading
        _getCharactersResponse.value = repository.getCharacters()
    }

}