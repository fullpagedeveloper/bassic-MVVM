package com.fullpagedeveloper.model

import com.google.gson.annotations.SerializedName

data class DogBreed(
    /**
     *  {
    "bred_for": "Small rodent hunting, lapdog",
    "breed_group": "Toy",
    "height": {
    "imperial": "9 - 11.5",
    "metric": "23 - 29"
    },
    "id": 1,
    "life_span": "10 - 12 years",
    "name": "Affenpinscher",
    "origin": "Germany, France",
    "temperament": "Stubborn, Curious, Playful, Adventurous, Active, Fun-loving",
    "weight": {
    "imperial": "6 - 13",
    "metric": "3 - 6"
    },
    "url": "https://raw.githubusercontent.com/DevTides/DogsApi/master/1.jpg"
    }
     */

    @SerializedName("id")
    val breedId: String?, //pakai ? jika id bisa null atau kosong

    @SerializedName("name")
    val dogBreed: String?,

    @SerializedName("life_span")
    val lifeSpan: String?,

    @SerializedName("breed_group")
    val breadGroup: String?,

    @SerializedName("bred_for")
    val bredFor: String?,

    @SerializedName("temperament")
    val temperament: String?,

    @SerializedName("url")
    val imageUrl: String?
)