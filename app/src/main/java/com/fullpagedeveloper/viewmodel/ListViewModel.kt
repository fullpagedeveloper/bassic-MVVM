package com.fullpagedeveloper.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fullpagedeveloper.model.DogBreed

class ListViewModel: ViewModel() {

    //memiliki 3 variable LiveData
    //MutableLiveData = data yang dapat berubah dari API
    val dogs = MutableLiveData<List<DogBreed>>()
    val dogLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh(){
        val dog1 = DogBreed("1", "Corgi", "15 Years", "breadGroup", "breadFor", "Temperament", "")
        val dog2 = DogBreed("2", "Ahay", "16 Years", "breadGroup", "breadFor", "Temperament", "")
        val dog3 = DogBreed("3", "Anjay", "11 Years", "breadGroup", "breadFor", "Temperament", "")
        val dogList = arrayListOf<DogBreed>(dog1, dog2, dog3)

        dogs.value = dogList
        dogLoadError.value = false
        loading.value = false
    }
}