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

        val UserButton = view.findViewById<View>(R.id.userprofileButton)
        val BadgesButton = view.findViewById<View>(R.id.badgesButton)
        val SolvedButton = view.findViewById<View>(R.id.solvedButton)
        val SubmissionButton = view.findViewById<View>(R.id.submissionsButton)
        val editText = view.findViewById<EditText>(R.id.editTextText)

        UserButton.setOnClickListener {
            val username = editText.text.toString()
            val bundle = Bundle().apply {
                putString("username", username)
            }
            navController.navigate(R.id.userFragment2, bundle, navOptions)
        }

        BadgesButton.setOnClickListener {
            val username = editText.text.toString()
            val bundle = Bundle().apply {
                putString("username", username)
            }
            navController.navigate(R.id.badgeFragment2, null, navOptions)
        }

        SolvedButton.setOnClickListener {
            val username = editText.text.toString()
            val bundle = Bundle().apply {
                putString("username", username)
            }
            navController.navigate(R.id.solvedFragment2, null, navOptions)
        }

        SubmissionButton.setOnClickListener {
            val username = editText.text.toString()
            val bundle = Bundle().apply {
                putString("username", username)
            }
            navController.navigate(R.id.submissionFragment2, null, navOptions)
        }
    }
}
