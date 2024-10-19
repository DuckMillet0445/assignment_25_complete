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

    // View binding for the fragment, nullable backing property
    private var _binding: FragmentDetailsBinding? = null

    // Non-nullable view binding accessed via getter
    private val binding get() = _binding!!

    // Navigation arguments passed to the fragment
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment using view binding
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Display the details of the entity
        displayEntityDetails()
    }

    // Function to display details of the entity passed as arguments
    private fun displayEntityDetails() {
        val entity = args.entity
        with(binding) {
            // Set text views with entity details, providing default values if null
            dishNameTextView.text = "Dish Name: ${entity.dishName ?: "N/A"}"
            originTextView.text = "Origin: ${entity.origin ?: "N/A"}"
            mainIngredientTextView.text = "Main Ingredient: ${entity.mainIngredient ?: "N/A"}"
            mealTypeTextView.text = "Meal Type: ${entity.mealType ?: "N/A"}"
            descriptionTextView.text = "Description: ${entity.description ?: "N/A"}"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Clear the binding to avoid memory leaks
        _binding = null
    }
}