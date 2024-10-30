package com.example.sitask4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.sitask4.api.fields.UserSolved
import kotlinx.coroutines.launch

class SolvedFragment : Fragment() {

    private lateinit var solvedProblemsTextView: TextView
    private lateinit var solvedProblemsContainer: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_solved, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        solvedProblemsTextView = view.findViewById(R.id.solvedProblemsTextView)
        solvedProblemsContainer = view.findViewById(R.id.solvedProblemsContainer)

        val username = arguments?.getString("username") ?: ""
        apiCall(username)
    }

    fun apiCall(userName: String) {
        lifecycleScope.launch {
            try {
                val service = retrofit.api.getUserSolved(userName)
                displaySolvedProblems(service)
            } catch (e: Exception) {
                solvedProblemsTextView.text = "Error"
            }
        }
    }

    fun displaySolvedProblems(userSolved: UserSolved) {
        solvedProblemsTextView.text = "Solved Problems: ${userSolved.solvedProblem}"

        solvedProblemsContainer.removeAllViews()
        userSolved.acSubmissionNum.forEach { submission ->
            val submissionTextView = TextView(context).apply {
                text = "Difficulty: ${submission.difficulty}, Count: ${submission.count}, Submissions: ${submission.submissions}"
                textSize = 16f
                setPadding(0, 8, 0, 8)
            }
            solvedProblemsContainer.addView(submissionTextView)
        }
    }
}