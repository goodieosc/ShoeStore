package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import android.util.Log.i
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber
import kotlinx.android.synthetic.main.shoe_text_view.view.*
import androidx.fragment.app.activityViewModels

class ShoeListFragment : Fragment() {

    //Create ViewModel class first.
    //private lateinit var viewModel: SharedViewModel

     private val viewModel: SharedViewModel by activityViewModels()

    //Create data reference in XML file first
    private lateinit var binding: FragmentShoeListBinding

    private lateinit var shoeDataClass: Shoe

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Remove standard binding
        //return inflater.inflate(R.layout.fragment_shoe_list, container, false)

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_list,container,false)

        //Reference (new instance Instance) to ViewModel
        Timber.i("Called ViewModelProvider")
        viewModel = ViewModelProvider(this).get(SharedViewModel::class.java)

        //Pass the ViewModel into the data binding:
        binding.sharedViewModel = viewModel
        binding.lifecycleOwner = this




        //Observe changes to 'shoeName' using LiveData observer
        viewModel.shoesList.observe(viewLifecycleOwner, Observer {
            Timber.i("LiveData observed")

            it.forEach {

                //Add textview.xml as a child to the linear layout in fragment_shoe_list.xml
                val frameLayout = binding.linearLayout  //Bind to linearLayout in fragment_shoe_list.xml

                val textView = View.inflate(context,R.layout.shoe_text_view, null)  //Inflate shoe_text_view within LinearLayout

                //Edit the new textView
                val textViewString =
                        "Shoe name: ${it.name.toString()}" +
                        "\n Brand: ${it.company}" +
                        "\n Size: ${it.size}" +
                        "\n Description: ${it.description}"

                textView.shoe.text = textViewString

                frameLayout.addView(textView)
                Timber.i("Name of shoe added ${it.name}")

            }


        })

        //Needed for data binding at end
        return binding.root
    }



}