package com.irayhan.characterapplication.view.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.irayhan.characterapplication.R
import com.irayhan.characterapplication.base.BaseRecycleAdapter
import com.irayhan.characterapplication.models.ModelCharacterItem

class CharacterAdapter(
    context: Context,
    layoutResource: Int,
    private val listener: OnCardClickListener
) :
    BaseRecycleAdapter<CharacterAdapter.CharacterAdapterViewHolder, ModelCharacterItem>(
        context,
        layoutResource
    ) {

    override fun onCreateView(viewHolder: View?): CharacterAdapterViewHolder {
        return CharacterAdapterViewHolder(viewHolder!!)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CharacterAdapterViewHolder, position: Int) {
        val character = get(position)

        holder.btnCharacter.apply {

            // name
            text = character.name

            // click listener
            setOnClickListener {
                listener.onClick(character)
            }

        }

    }

    class CharacterAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val btnCharacter: MaterialButton = itemView.findViewById(R.id.btn_character)
    }


    interface OnCardClickListener {
        fun onClick(character: ModelCharacterItem)
    }
}