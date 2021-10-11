package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.shoe_text_view.view.*
import timber.log.Timber

class ShoeListFragment : Fragment() {

    //Create ViewModel class first.
   // private lateinit var viewModel: SharedViewModel
     private val viewModel: SharedViewModel by activityViewModels()  //activityViewModels() is used when a viewModel needs to be shared between fragments.

    //Create data reference in XML file first
    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Remove standard binding
        //return inflater.inflate(R.layout.fragment_shoe_list, container, false)

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_list,container,false)

        //Reference (new instance Instance) to ViewModel - Not needed as using a shared viewModel
        //viewModel = ViewModelProvider(this).get(SharedViewModel::class.java)

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

                Timber.i(textViewString)

                textView.shoe.text = textViewString

                frameLayout.addView(textView)

                Timber.i("Shoe added: $textView")

            }
        })


        //add menu button
        setHasOptionsMenu(true)

        //Needed for data binding at end
        return binding.root
    }



    //inflate menu button
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    //nativate to about fragment
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}