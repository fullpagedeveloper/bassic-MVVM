package com.fullpagedeveloper.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity //kita bisa inputkan nama table pada @Entity(tableName = ) akan jadi seperti ini, jika hanya @Entity maka kita membuat table name sama dengan nama class
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

    //membuat kolom variable untuk datatabel dengan @ColumnInfo dengan nama kolom breed_id, karena ingin dibedakan saja
    @ColumnInfo(name = "breed_id")
    @SerializedName("id")
    val breedId: String?, //pakai ? jika id bisa null atau kosong

    @ColumnInfo(name = "dog_name")
    @SerializedName("name")
    val dogBreed: String?,

    @ColumnInfo(name = "life_span") //dikelola nama2 untuk kolom database tempat @Entity ini disimpan
    @SerializedName("life_span") //informasinya dari backend API
    val lifeSpan: String?, //ia menyimpan informasi

    @ColumnInfo(name = "breed_group")
    @SerializedName("breed_group")
    val breadGroup: String?,

    @ColumnInfo(name = "bred_for")
    @SerializedName("bred_for")
    val bredFor: String?,

    //karena tidak memiliki dua kata gabungan seperti yang lain jadi saya tetap menggunakan nama kolom defult yaitu temperament
    @SerializedName("temperament")
    val temperament: String?,

    @ColumnInfo(name = "dog_url")
    @SerializedName("url")
    val imageUrl: String?
){
    //karena semua value dari backend adalah string maka kita akan membuat primaryKey di dalam body buka di dalam constructor
    //primaryKey ini akan dihasilkan oleh room database,saya tidak ingin kita harus membuat diru setiap waktu
    //kita akan akan membuat variable room dengan var karena datanya dapat berubah
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0 //cara standaard untuk memberi nama identifikasi unik untuk tabel dalam database// type Int nilali default 0
}