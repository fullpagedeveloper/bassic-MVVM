package com.fullpagedeveloper.model

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
    val breedId: String?, //pakai ? jika id bisa null atau kosong
    val dogBreed: String?,
    val lifeSpan: String?,
    val breadGroup: String?,
    val bredFor: String?,
    val temperament: String?,
    val imageUrl: String?
)