package com.example.sitask4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sitask4.api.fields.Submission

class SubmissionAdapter(private val submissions: List<Submission>) :
    RecyclerView.Adapter<SubmissionAdapter.SubmissionViewHolder>() {

    inner class SubmissionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tvTitle)
        val status: TextView = itemView.findViewById(R.id.tvStatus)
        val language: TextView = itemView.findViewById(R.id.tvLanguage)
        val timestamp: TextView = itemView.findViewById(R.id.tvTimestamp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubmissionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.submission_list, parent, false)
        return SubmissionViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubmissionViewHolder, position: Int) {
        val submission = submissions[position]
        holder.title.text = submission.title
        holder.status.text = submission.statusDisplay
        holder.language.text = submission.lang
        holder.timestamp.text = submission.timestamp.toString()
    }

    override fun getItemCount(): Int = submissions.size
}
