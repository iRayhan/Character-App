package com.irayhan.characterapplication.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.irayhan.characterapplication.R
import com.irayhan.characterapplication.base.BaseFragment
import com.irayhan.characterapplication.databinding.FragmentHomeBinding
import com.irayhan.characterapplication.models.ModelCharacter
import com.irayhan.characterapplication.models.ModelCharacterItem
import com.irayhan.characterapplication.networking.APIService
import com.irayhan.characterapplication.repository.CharacterRepository
import com.irayhan.characterapplication.utils.DataState
import com.irayhan.characterapplication.view.adapters.CharacterAdapter
import com.irayhan.characterapplication.viewmodel.network.CharacterVM
import org.json.JSONArray
import org.json.JSONException

class HomeFragment : BaseFragment<CharacterVM, FragmentHomeBinding, CharacterRepository>() {
    override fun getViewModel() = CharacterVM::class.java
    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?) = FragmentHomeBinding.inflate(inflater, container, false)
    override fun getRepository() = CharacterRepository(remoteDataSource.buildApi(APIService::class.java))

    override fun init(savedInstanceState: Bundle?) {

        // observe api response
        observeGetCharactersResponse()

        // get characters
        viewModel.getCharacters()

    }

    private fun observeGetCharactersResponse() {
        viewModel.getCharactersResponse.observe(viewLifecycleOwner, {
            when (it) {
                is DataState.Success -> {

                    // dismiss
                    binding.progressCircular.isGone = true

                    // get data
                    val body = it.value.body()?.string()!!
                    Log.e("X_API_RES", body)

                    try {
                        val jsonArray = JSONArray(body)
                        showCharacterList(jsonArray)

                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }

                is DataState.Loading -> {
                    binding.progressCircular.isVisible = true
                }

                is DataState.Error -> {
                    if (it.isNetworkError) Toast.makeText(mContext, "No Network", Toast.LENGTH_SHORT).show()
                    else Toast.makeText(mContext, "Error: $it", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun showCharacterList(jsonArray: JSONArray) {
        val characterList = Gson().fromJson(jsonArray.toString(), ModelCharacter::class.java)

        val characterAdapter = CharacterAdapter(mContext, R.layout.row_character, object : CharacterAdapter.OnCardClickListener {
            override fun onClick(character: ModelCharacterItem) {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(character))
            }
        })

        binding.rvCharacter.apply {
            setHasFixedSize(true)
            adapter = characterAdapter
        }
        characterAdapter.addAll(characterList, true)

    }

}