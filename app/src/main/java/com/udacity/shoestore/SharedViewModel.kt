package com.udacity.shoestore

import android.os.Parcelable
import android.view.View
import androidx.databinding.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.udacity.shoestore.models.Shoe
import timber.log.Timber
import android.widget.TextView

import androidx.databinding.BindingAdapter
import kotlinx.android.parcel.Parcelize


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



