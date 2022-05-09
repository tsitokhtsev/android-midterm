package com.tsitokhtsev.midterm.fragments

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.tsitokhtsev.midterm.R

class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var profileButton: ImageButton
    private lateinit var nameEditText: EditText
    private lateinit var loginButton: ImageButton

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)

        profileButton = view.findViewById(R.id.profileButton)
        nameEditText = view.findViewById(R.id.nameEditText)
        loginButton = view.findViewById(R.id.loginButton)

        profileButton.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToProfileFragment(null)
            navController.navigate(action)
        }

        loginButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val action = LoginFragmentDirections.actionLoginFragmentToProfileFragment(name)

            navController.navigate(action)
        }
    }
}