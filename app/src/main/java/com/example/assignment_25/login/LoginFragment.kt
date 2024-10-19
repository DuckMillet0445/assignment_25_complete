package com.example.assignment_25.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.assignment_25.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import com.example.assignment_25.R

@AndroidEntryPoint
class LoginFragment : Fragment() {

    // ViewModel for managing login operations
    private val viewModel: LoginViewModel by viewModels()

    // View binding for the fragment, nullable backing property
    private var _binding: FragmentLoginBinding? = null

    // Non-nullable view binding accessed via getter
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment using view binding
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // set up views and observe the ViewModel
        setupViews()
        observeViewModel()
    }

    private fun setupViews() {
        // Set click listener for the login button
        binding.loginButton.setOnClickListener {
            val username = binding.usernameEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            val location = getSelectedLocation()

            // Check if username and password are not blank
            if (username.isNotBlank() && password.isNotBlank()) {
                // Trigger login in ViewModel
                viewModel.login(location, username, password)
            } else {
                // Show a toast message if fields are empty
                Toast.makeText(context, "Please enter both username and password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Get the selected location from the radio group
    private fun getSelectedLocation(): String {
        return when (binding.locationRadioGroup.checkedRadioButtonId) {
            R.id.footscrayRadioButton -> "footscray"
            R.id.sydneyRadioButton -> "sydney"
            R.id.ortRadioButton -> "ort"
            else -> "footscray" // Default value
        }
    }

    private fun observeViewModel() {
        // observe login results from the ViewModel
        viewModel.loginResult.observe(viewLifecycleOwner) { result ->
            result.onSuccess { keypass ->
                // navigate to the dashboard on successful login
                navigateToDashboard(keypass)
            }.onFailure { error ->
                // show error message on login failure
                Toast.makeText(context, "Login failed: ${error.message}", Toast.LENGTH_LONG).show()
            }
        }

        // Observe loading state and update UI accordingly
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
            binding.loginButton.isEnabled = !isLoading
        }
    }

    // Navigate to the dashboard fragment
    private fun navigateToDashboard(keypass: String) {
        val action = LoginFragmentDirections.actionLoginFragmentToDashboardFragment(keypass)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Clear the binding to avoid memory leaks
        _binding = null
    }
}