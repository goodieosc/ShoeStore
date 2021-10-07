package com.udacity.shoestore

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation

class InstructionsViewModel: ViewModel() {

    fun navigateToShoeListFragment(view: View) {
        val action = InstructionsFragmentDirections.actionInstructionsFragmentToShoeListFragment()
        Navigation.findNavController(view).navigate(action)

    }
}