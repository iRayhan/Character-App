package com.irayhan.characterapplication.view.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.irayhan.characterapplication.base.BaseFragment
import com.irayhan.characterapplication.databinding.FragmentDetailBinding
import com.irayhan.characterapplication.networking.APIService
import com.irayhan.characterapplication.repository.CharacterRepository
import com.irayhan.characterapplication.viewmodel.network.CharacterVM
import com.irayhan.characterapplication.models.ModelCharacterItem


class DetailFragment : BaseFragment<CharacterVM, FragmentDetailBinding, CharacterRepository>() {
    override fun getViewModel() = CharacterVM::class.java
    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?) = FragmentDetailBinding.inflate(inflater, container, false)
    override fun getRepository() = CharacterRepository(remoteDataSource.buildApi(APIService::class.java))

    override fun init(savedInstanceState: Bundle?) {

        // get character
        getCharacter()

    }

    private fun getCharacter() {
        arguments?.getSerializable("character")?.let {
            val character = it as ModelCharacterItem
            showCharacterDetail(character)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showCharacterDetail(character: ModelCharacterItem) {

        // image
        Glide.with(mContext).load(character.image).into(binding.imgCharacter)

        // name
        binding.txtName.text = character.name

        // house
        binding.txtHouse.text = "House: ${character.house}"

        // ancestry
        binding.txtAncestry.text = "Ancestry: ${character.ancestry}"

        // dob
        binding.txtDob.text = "Date-of-Birth: ${character.dateOfBirth}"

        // patronus
        binding.txtPatronus.text = "Patronus: ${character.patronus}"

        // eye color
        binding.txtEyeColor.text = "Eye color: ${character.eyeColour}"

        // species
        binding.txtSpecies.text = "Species: ${character.species}"

        // wand
        binding.txtWand.text = "Wand: ${character.wand?.core} - ${character.wand?.wood} - ${character.wand?.length} "

    }
}