package com.fullpagedeveloper.model

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class DogsApiService {

    //https://raw.githubusercontent.com/DevTides/DogsApi/master/dogs.json
    private val BASE_URL = "https://raw.githubusercontent.com"

    private val api = Retrofit.Builder() //object yang dibuat oleh retrofit untuk memungkinkan kita mengambil dan emanggil info dari endpoint
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()) //mengubah json ke gson menjadi model //base: menangani semua komunikasi jaringan dan semua kesalahan
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // dapat di amati //base: yang dapat diamati
        .build() //membuat
        .create(DogsApi::class.java) //membangun berdasarkan interface DogsApi.kt

    //dapat diamati yang mengembalikan informasi dari backend
    fun getDogs(): Single<List<DogBreed>>{
        return api.getDogs()
    }
}