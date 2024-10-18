package com.example.assignment_25.home.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.assignment_25.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayEntityDetails()
    }

    private fun displayEntityDetails() {
        val entity = args.entity
        with(binding) {
            property1TextView.text = "Property 1: ${entity.property1}"
            property2TextView.text = "Property 2: ${entity.property2}"
            descriptionTextView.text = "Description: ${entity.description}"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}