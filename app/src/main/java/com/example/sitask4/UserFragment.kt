package com.example.sitask4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.sitask4.api.fields.UserProfile
import kotlinx.coroutines.launch

class UserFragment : Fragment() {

    private lateinit var text: TextView
    private lateinit var avatarImageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        text = view.findViewById(R.id.userNameTextView)
        avatarImageView = view.findViewById(R.id.avatarImageView)
        val username = arguments?.getString("username") ?: ""
        apiCall(username)
    }

    private fun apiCall(userName: String) {
        lifecycleScope.launch {
            try {
                val service = retrofit.api.getUserProfile(userName)
                text.text = formatUserProfile(service)
                loadImage(service.avatar)
            } catch (e: Exception) {
                text.text = "Error"
            }
        }
    }

    private fun formatUserProfile(userProfile: UserProfile): String {
        return """
            Username: ${userProfile.username ?: "N/A"}
            Name: ${userProfile.name ?: "N/A"}
            About: ${userProfile.about ?: "N/A"}
            Birthday: ${userProfile.birthday ?: "N/A"}
            Company: ${userProfile.company ?: "N/A"}
            Country: ${userProfile.country ?: "N/A"}
            GitHub: ${userProfile.gitHub ?: "N/A"}
            LinkedIn: ${userProfile.linkedIN ?: "N/A"}
            Ranking: ${userProfile.ranking ?: "N/A"}
            Reputation: ${userProfile.reputation ?: "N/A"}
            School: ${userProfile.school ?: "N/A"}
            Skills: ${userProfile.skillTags?.joinToString(", ") ?: "N/A"}
            Twitter: ${userProfile.twitter ?: "N/A"}
            Website: ${userProfile.website?.joinToString(", ") ?: "N/A"}
        """.trimIndent()
    }

    private fun loadImage(avatarUrl: String?) {
        if (!avatarUrl.isNullOrEmpty()) {
            Glide.with(this)
                .load(avatarUrl)
                .into(avatarImageView)
        }
    }
}