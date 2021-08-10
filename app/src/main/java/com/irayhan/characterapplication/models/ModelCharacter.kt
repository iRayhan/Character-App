package com.irayhan.characterapplication.models
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class ModelCharacter : ArrayList<ModelCharacterItem>()

data class ModelCharacterItem(
    @SerializedName("actor")
    val actor: String?,
    @SerializedName("alive")
    val alive: Boolean?,
    @SerializedName("ancestry")
    val ancestry: String?,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String?,
    @SerializedName("eyeColour")
    val eyeColour: String?,
    @SerializedName("gender")
    val gender: String?,
    @SerializedName("hairColour")
    val hairColour: String?,
    @SerializedName("hogwartsStaff")
    val hogwartsStaff: Boolean?,
    @SerializedName("hogwartsStudent")
    val hogwartsStudent: Boolean?,
    @SerializedName("house")
    val house: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("patronus")
    val patronus: String?,
    @SerializedName("species")
    val species: String?,
    @SerializedName("wand")
    val wand: Wand?,
    @SerializedName("yearOfBirth")
    val yearOfBirth: String?
) : Serializable

data class Wand(
    @SerializedName("core")
    val core: String?,
    @SerializedName("length")
    val length: String?,
    @SerializedName("wood")
    val wood: String?
) : Serializable