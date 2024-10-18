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

    private val viewModel: LoginViewModel by viewModels()
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews()
        observeViewModel()
    }

    private fun setupViews() {
        binding.loginButton.setOnClickListener {
            val username = binding.usernameEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            val location = getSelectedLocation()

            if (username.isNotBlank() && password.isNotBlank()) {
                viewModel.login(location, username, password)
            } else {
                Toast.makeText(context, "Please enter both username and password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getSelectedLocation(): String {
        return when (binding.locationRadioGroup.checkedRadioButtonId) {
            R.id.footscrayRadioButton -> "footscray"
            R.id.sydneyRadioButton -> "sydney"
            R.id.ortRadioButton -> "ort"
            else -> "footscray" // Default value
        }
    }

    private fun observeViewModel() {
        viewModel.loginResult.observe(viewLifecycleOwner) { result ->
            result.onSuccess { keypass ->
                navigateToDashboard(keypass)
            }.onFailure { error ->
                Toast.makeText(context, "Login failed: ${error.message}", Toast.LENGTH_LONG).show()
            }
        }

        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
            binding.loginButton.isEnabled = !isLoading
        }
    }

    private fun navigateToDashboard(keypass: String) {
        val action = LoginFragmentDirections.actionLoginFragmentToDashboardFragment(keypass)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}