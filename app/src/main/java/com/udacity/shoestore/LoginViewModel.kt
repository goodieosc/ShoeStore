package com.udacity.shoestore

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation

//Class needs to extend ViewModel
class LoginViewModel : ViewModel() {


    fun navigateToWelcomeFragment(view: View) {
        val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
        Navigation.findNavController(view).navigate(action)

    }

}