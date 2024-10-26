package com.example.sitask4.api.fields

data class Submission(
    val lang: String,
    val statusDisplay: String,
    val timestamp: String,
    val title: String,
    val titleSlug: String
)