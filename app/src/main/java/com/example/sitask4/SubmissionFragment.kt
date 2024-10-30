package com.example.sitask4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sitask4.api.fields.Submission
import kotlinx.coroutines.launch

class SubmissionFragment : Fragment() {

    private lateinit var submissionAdapter : SubmissionAdapter
    private val submissions = mutableListOf<Submission>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_submission, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.submissionRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        submissionAdapter = SubmissionAdapter(submissions)
        recyclerView.adapter = submissionAdapter

        // Test with dummy data
        submissions.add(Submission("Test Title", "test-title", "1234567890", "Accepted", "cpp"))
    }

    private fun apiCall(username : String){
        lifecycleScope.launch {
            try {
                val service = retrofit.api.getUserSubmissions(username)
                val submissionList = service.submission
                submissions.addAll(submissionList ?: emptyList())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


}
