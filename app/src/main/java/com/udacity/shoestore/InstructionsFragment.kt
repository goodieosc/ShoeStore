package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.databinding.FragmentInstructionsBinding
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import timber.log.Timber

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [InstructionsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InstructionsFragment : Fragment() {
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

    private lateinit var viewModel: InstructionsViewModel

    private lateinit var binding: FragmentInstructionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Remove standard binding
        //return inflater.inflate(R.layout.fragment_instructions, container, false)

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_instructions,container,false)

        //Reference (new instance Instance) to ViewModel
        Timber.i("Called ViewModelProvider")
        viewModel = ViewModelProvider(this).get(InstructionsViewModel::class.java)

        //Pass the ViewModel into the data binding:
        binding.instructionsViewModel = viewModel
        binding.lifecycleOwner = this



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
         * @return A new instance of fragment InstructionsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            InstructionsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}