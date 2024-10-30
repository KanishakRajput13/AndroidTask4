import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.lifecycleScope
import com.example.sitask4.R
import com.example.sitask4.SubmissionAdapter
import com.example.sitask4.api.fields.Submission
import com.example.sitask4.retrofit
import kotlinx.coroutines.launch

class SubmissionsFragment : Fragment() {

    private lateinit var submissionAdapter: SubmissionAdapter
    private val submissions = mutableListOf<Submission>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sub, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.submissionRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        submissionAdapter = SubmissionAdapter(submissions)
        recyclerView.adapter = submissionAdapter

        val username = arguments?.getString("username") ?: ""
        apiCall(username)
    }

    private fun apiCall(userName: String) {
        lifecycleScope.launch {
            try {
                val service = retrofit.api.getUserSubmissions(userName)
                val submissionList = service.submission
                submissions.addAll(submissionList ?: emptyList())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
