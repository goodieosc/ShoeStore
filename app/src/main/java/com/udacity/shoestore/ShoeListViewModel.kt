package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListViewModel : ViewModel() {


    val shoeName = MutableLiveData<String>()



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
        shoeName.value = ""
    }

    fun newShoe(newbrand: String){
        shoeName.value = newbrand

    }


}