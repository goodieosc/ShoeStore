package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class SharedViewModel : ViewModel() {





    val shoeList = mutableListOf<String>(
        "Nike",
        "Puma",
        "Addidas",
        "Reebok",
        "New Balance",
        "Asics",
        "Brooks",
        "Skechers",
        "Under Armour",
        "Merrell",
        "Veja",
    )


    init {

    }

    private val _shoes = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes


    fun saveCurrentDetail(detail: Shoe?) {
        detail?.let {
            _shoes.value?.add(it)
        }
    }



    }

