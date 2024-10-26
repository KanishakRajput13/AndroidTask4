package com.example.sitask4.api.fields

data class UserSubmissions (
    val count: Int,
    val submission: List<Submission>
)

data class Submission(
    val title: String,
    val titleSlug: String,
    val timestamp: String,
    val statusDisplay: String,
    val lang: String
)