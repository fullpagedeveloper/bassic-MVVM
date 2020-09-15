package com.fullpagedeveloper.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fullpagedeveloper.model.DogBreed
import com.fullpagedeveloper.model.DogsApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ListViewModel: ViewModel() {

    private val dogsService = DogsApiService()
    private val disposable = CompositeDisposable()

    //memiliki 3 variable LiveData
    //MutableLiveData = data yang dapat berubah dari API
    val dogs = MutableLiveData<List<DogBreed>>()
    val dogLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh(){
        fetchFromRemote()
    }

    private fun fetchFromRemote(){
        loading.value = true
        //sekali pakai
        disposable.add(
            dogsService.getDogs() //kode ini kita panggil untuk mendapatkan info dari backend
                .subscribeOn(Schedulers.newThread()) //in background thread
                .observeOn(AndroidSchedulers.mainThread()) //jawaban respons di proses pada mainThread
                .subscribeWith(object : DisposableSingleObserver<List<DogBreed>>(){ //menggunakan pengamat/obsetve yang dapat diamati yang mendapat nilao
                    override fun onSuccess(dogsList: List<DogBreed>) { //success
                        dogs.value = dogsList //menaruhnya ke data yang dapat berubah
                        dogLoadError.value = false
                        loading.value = false

                    }

                    override fun onError(e: Throwable) { //error
                        dogLoadError.value = true
                        loading.value = false
                        e.printStackTrace()
                    }

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}