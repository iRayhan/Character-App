package com.irayhan.characterapplication.view.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.card.MaterialCardView
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

        holder.apply {

            // img
            Glide.with(mContext).load(character.image).into(imgCharacter)

            // name
            txtName.text = character.name

            // click listener
            cardRoot.setOnClickListener {
                listener.onClick(character)
            }
        }

    }

    class CharacterAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardRoot: MaterialCardView = itemView.findViewById(R.id.card_root)
        val imgCharacter: ImageView = itemView.findViewById(R.id.img_character)
        val txtName: TextView = itemView.findViewById(R.id.txt_name)
    }


    interface OnCardClickListener {
        fun onClick(character: ModelCharacterItem)
    }
}