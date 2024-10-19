package com.example.assignment_25.home.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment_25.databinding.FragmentDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    // ViewModel instance for the DashboardFragment
    private val viewModel: DashboardViewModel by viewModels()

    // View binding for the fragment, nullable backing property
    private var _binding: FragmentDashboardBinding? = null

    // Non-nullable view binding accessed via getter
    private val binding get() = _binding!!

    // Navigation arguments passed to the fragment
    private val args: DashboardFragmentArgs by navArgs()

    // Adapter for displaying entities in a RecyclerView
    private lateinit var adapter: EntityAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment using view binding
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up RecyclerView and observe ViewModel data
        setupRecyclerView()
        observeViewModel()
        // Fetch dashboard data using the keypass argument
        viewModel.getDashboard(args.keypass)
    }

    private fun setupRecyclerView() {
        // Initialize the adapter with a click listener for navigation
        adapter = EntityAdapter { entity ->
            val action = DashboardFragmentDirections.actionDashboardFragmentToDetailsFragment(entity)
            findNavController().navigate(action)
        }
        // Set the adapter and layout manager for the RecyclerView
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun observeViewModel() {
        // Observe the list of entities and update the UI
        viewModel.entities.observe(viewLifecycleOwner) { result ->
            result.onSuccess { entities ->
                adapter.submitList(entities)
                // Show empty state if no entities are available
                binding.emptyStateTextView.visibility = if (entities.isEmpty()) View.VISIBLE else View.GONE
            }.onFailure { error ->
                // Show error message if data fetch fails
                Toast.makeText(context, "Error: ${error.message}", Toast.LENGTH_LONG).show()
            }
        }

        // Observe loading state and show/hide progress bar
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Clear the binding to avoid memory leaks
        _binding = null
    }
}