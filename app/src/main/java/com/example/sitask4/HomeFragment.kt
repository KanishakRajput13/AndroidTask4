package com.example.sitask4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation

class HomeFragment : Fragment() {

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        val navOptions = NavOptions.Builder()
            .setLaunchSingleTop(true)
            .setRestoreState(true)
            .setPopUpTo(R.id.nav_graph, true)
            .build()

        val submitButton = view.findViewById<View>(R.id.submitButton)
        val editText = view.findViewById<EditText>(R.id.editTextText)

        submitButton.setOnClickListener {
            val username = editText.text.toString()
            val bundle = Bundle().apply {
                putString("username", username)
            }
            navController.navigate(R.id.submissionFragment2, bundle, navOptions)
        }
    }
}
