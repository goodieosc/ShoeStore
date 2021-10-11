package com.udacity.shoestore

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


class SharedViewModel : ViewModel(){

    //LiveData created for all the EditText Views
    private var _name = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _name
    var shoeName = ""

    private var _size = MutableLiveData<Double>()
    val size: LiveData<Double>
        get() = _size
    var shoeSize = 0.0

    private var _description = MutableLiveData<String>()
    val description: LiveData<String>
        get() = _description
    var shoeDescription = ""

    private var _company = MutableLiveData<String>()
    val company: LiveData<String>
        get() = _company
    var shoeCompany = ""

        //Internal class list
        private val _shoesList = MutableLiveData<MutableList<Shoe>>(mutableListOf())
        //Public class list
        val shoesList: LiveData<MutableList<Shoe>>
            get() = _shoesList



        fun saveNewShoeToList() {

            _name.value = shoeName
            _size.value = shoeSize
            _description.value = shoeDescription
            _company.value = shoeCompany

            val newShoe: Shoe = Shoe(shoeName, shoeSize, shoeCompany, shoeDescription, listOf("1", "2", "3"))

            Timber.i("New shoe added $newShoe")

            addNewShoe(newShoe)

            //Navigate back to list fragment
            val action = ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
            //Navigation.findNavController(view).navigate(action)

        }

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

