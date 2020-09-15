package com.fullpagedeveloper.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.fullpagedeveloper.dugs.R
import com.fullpagedeveloper.model.DogBreed
import com.fullpagedeveloper.util.getProgressDrawable
import com.fullpagedeveloper.util.loadImage
import kotlinx.android.synthetic.main.item_dogs.view.*

class DogListAdapter(val dogList: ArrayList<DogBreed>): RecyclerView.Adapter<DogListAdapter.DogViewHolder>() {

    //
    fun updateDogList(newDogList: List<DogBreed>){
        dogList.clear()
        dogList.addAll(newDogList)
        notifyDataSetChanged() //update dataset
    }

    class DogViewHolder(var view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_dogs, parent, false)
        return DogViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.view.name.text = dogList[position].dogBreed
        holder.view.lifespan.text = dogList[position].lifeSpan
        holder.view.setOnClickListener {
            Navigation.findNavController(it).navigate(ListFragmentDirections.actionDetailFragment())
        }
        holder.view.imageView.loadImage(dogList[position].imageUrl, getProgressDrawable(holder.view.imageView.context))
    }

    override fun getItemCount() = dogList.size
}