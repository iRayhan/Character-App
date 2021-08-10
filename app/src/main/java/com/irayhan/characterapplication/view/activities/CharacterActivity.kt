package com.irayhan.characterapplication.view.activities

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.irayhan.characterapplication.R
import com.irayhan.characterapplication.base.BaseActivity
import com.irayhan.characterapplication.databinding.ActivityCharacterBinding

class CharacterActivity : BaseActivity<ActivityCharacterBinding>() {

    override val contentView: Int get() = R.layout.activity_character
    private lateinit var navController: NavController

    override fun init(savedInstanceState: Bundle?) {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController
    }
}