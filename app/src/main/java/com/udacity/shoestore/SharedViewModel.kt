package com.udacity.shoestore

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.udacity.shoestore.models.Shoe

class SharedViewModel : ViewModel() {


    //Store list of shoes as live data
    private val _shoes = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes

    //Add a new shoe to live data list
    fun saveCurrentDetail(detail: Shoe?) {
        detail?.let {
            _shoes.value?.add(it)
        }
    }

    fun navigateToShoeDetailFragment(view: View) {
        val action = ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
        Navigation.findNavController(view).navigate(action)

    }


    fun navigateToShoeListFragment(view: View) {
        val action = ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
        Navigation.findNavController(view).navigate(action)

    }



    }

