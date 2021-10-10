package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    //Create ViewModel class first.
    private lateinit var viewModel: SharedViewModel

    //Create data reference in XML file first
    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Remove standard binding
        //return inflater.inflate(R.layout.fragment_shoe_detail, container, false)

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_detail,container,false)

        //Reference (new instance Instance) to ViewModel
        Timber.i("Called ViewModelProvider")
        viewModel = ViewModelProvider(this).get(SharedViewModel::class.java)

        //Pass the ViewModel into the data binding:
        binding.sharedViewModel = viewModel
        binding.lifecycleOwner = this


        binding.saveButton.setOnClickListener {

            val shoeName = binding.shoeNameEditText.text.toString()
            val shoeSize :Double = binding.shoeSizeEditText.text.toString().toDouble()
            val shoeCompany = binding.companyEditText.text.toString()
            val shoeDecription = binding.descriptionEditText.text.toString()

            val newShoe : Shoe = Shoe(shoeName,shoeSize,shoeCompany,shoeDecription, listOf("1","2","3"))

            Timber.i("New shoe added $newShoe")

            viewModel.addNewShoe(newShoe)

            //Navigate back to list fragment
           findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())

        }






        //Needed for data binding at end
        return binding.root
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ShoeDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ShoeDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}