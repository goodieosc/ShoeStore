package com.udacity.shoestore

import android.view.View
import android.widget.EditText
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class SharedViewModel : ViewModel() {

    @InverseBindingAdapter(attribute = "android:text")
    fun EditText.getFloatFromBinding(): Float? {
        val result=text.toString()

        return result.toFloat()
    }

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

