package com.example.dogsapplication.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.dogsapplication.Model.DogBreed
import com.example.dogsapplication.R
import com.example.dogsapplication.Util.getProgressDrawable
import com.example.dogsapplication.Util.loadImage
import kotlinx.android.synthetic.main.item_dog.view.*

class DogsListAdapter(val dogsList: ArrayList<DogBreed>) :
    RecyclerView.Adapter<DogsListAdapter.DogViewHolder>() {

fun updateDogList(newDogsList: List<DogBreed>) {
    dogsList.clear()
    dogsList.addAll(newDogsList)
    notifyDataSetChanged()
}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_dog, parent, false)
        return DogViewHolder(view)
    }

    override fun getItemCount() = dogsList.size

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.view.name.text = dogsList[position].dogBreed
        holder.view.lifespan.text = dogsList[position].lifeSpan
holder.view.setOnClickListener{
    val action = ListFragmentDirections.actionDetailFragment()
    action.dogUuid = dogsList[position].uuid
    Navigation.findNavController(it).navigate(action)
}
        //load automatically all the dog images into the list
      holder.view.imageView.loadImage(dogsList[position].imageUrl, getProgressDrawable(holder.view.imageView.context))
    }

    class DogViewHolder(var view: View) : RecyclerView.ViewHolder(view)
}