package com.udacity.shoestore

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.udacity.shoestore.models.Shoe

class SharedViewModel : ViewModel() {

        //Internal class list
        private val _shoesList = MutableLiveData<MutableList<Shoe>>(mutableListOf())
        //Public class list
        val shoesList: LiveData<MutableList<Shoe>>
            get() = _shoesList

        //Add a new shoe to live data list
        fun addNewShoe(detail: Shoe?) {
            detail?.let {
                _shoesList.value?.add(it)
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

