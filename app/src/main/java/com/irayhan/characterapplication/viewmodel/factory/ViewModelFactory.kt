package com.irayhan.characterapplication.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.irayhan.characterapplication.base.BaseRepository
import com.irayhan.characterapplication.repository.CharacterRepository
import com.irayhan.characterapplication.viewmodel.network.CharacterVM

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val repository: BaseRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(CharacterVM::class.java) -> CharacterVM(repository as CharacterRepository) as T
            else -> throw IllegalArgumentException("ViewModelClass Not Found")
        }
    }
}