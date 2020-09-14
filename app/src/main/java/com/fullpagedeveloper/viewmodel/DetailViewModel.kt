package com.fullpagedeveloper.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fullpagedeveloper.model.DogBreed

class DetailViewModel: ViewModel(){

    val dogLiveData = MutableLiveData<DogBreed>()

    fun fetch() {
        val dog = DogBreed("1", "Corgi", "15 Years", "breadGroup", "breadFor", "Temperament", "")

        dogLiveData.value = dog
    }
}