package com.udacity.shoestore

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class SharedViewModel : ViewModel() {


    //internal list
    private val _shoesList = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    //external list
    val shoesList: LiveData<MutableList<Shoe>>
        get() = _shoesList


    //Add a new shoe to live data list
    fun addNewShoe(shoe: Shoe?) {
        shoe?.let {
            _shoesList.value?.add(it)
            Timber.i(_shoesList.value.toString())



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

