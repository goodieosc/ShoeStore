package com.udacity.shoestore

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation


//Class needs to extend ViewModel
class WelcomeViewModel : ViewModel() {


    fun navigateToInstructionsFragment(view: View) {
        val action = welcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment()
        Navigation.findNavController(view).navigate(action)

    }


}