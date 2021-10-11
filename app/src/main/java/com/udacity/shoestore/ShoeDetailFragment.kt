package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeDetailFragment : Fragment() {

    //Create ViewModel class first.
    // private lateinit var viewModel: SharedViewModel
    private val viewModel: SharedViewModel by activityViewModels()  //activityViewModels() is used when a viewModel needs to be shared between fragments.

    //Create data reference in XML file first
    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Remove standard binding
        //return inflater.inflate(R.layout.fragment_shoe_detail, container, false)

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)



        //Reference (new instance Instance) to ViewModel - Not needed as using a shared viewModel
        //viewModel = ViewModelProvider(this).get(SharedViewModel::class.java)

        //Pass the ViewModel into the data binding:
        binding.sharedViewModel = viewModel
        binding.lifecycleOwner = this

//        binding.saveButton.setOnClickListener {
//
//            val shoeName = binding.sharedViewModel.name
//            val shoeSize: Double = binding.newShoe.size
//            val shoeCompany = binding.newShoe.company
//            val shoeDescription = binding.newShoe.description
//
//            val newShoe: Shoe =
//                Shoe(shoeName, shoeSize, shoeCompany, shoeDescription, listOf("1", "2", "3"))
//
//            Timber.i("New shoe added $newShoe")
//
//            viewModel.addNewShoe(newShoe)
//
//            //Navigate back to list fragment
//            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
//
//        }

        //Needed for data binding at end
        return binding.root
    }


}



