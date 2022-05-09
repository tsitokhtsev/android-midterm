package com.tsitokhtsev.midterm.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.tsitokhtsev.midterm.R

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private lateinit var backButton: ImageButton
    private lateinit var nameTextView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)
        val sharedPreferences = activity?.getSharedPreferences("Profile", Context.MODE_PRIVATE)
        val nameArg = ProfileFragmentArgs.fromBundle(requireArguments()).name

        if (nameArg != null) {
            if (nameArg.isBlank()) sharedPreferences?.edit()?.putString("Name", "Your name")?.apply()
            else sharedPreferences?.edit()?.putString("Name", nameArg)?.apply()
        }

        val name = sharedPreferences?.getString("Name", "Your name")

        backButton = view.findViewById(R.id.backButton)
        nameTextView = view.findViewById(R.id.nameTextView)
        nameTextView.text = "Hello, $name"

        backButton.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileFragmentToLoginFragment()
            navController.navigate(action)
        }
    }
}