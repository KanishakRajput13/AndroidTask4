package com.example.sitask4.api.fields

data class UserSolved (
    val solvedProblem: Int,
    val easySolved: Int,
    val mediumSolved: Int,
    val hardSolved: Int,
    val totalSubmissionNum: List<SubmissionStats>,
    val acSubmissionNum: List<SubmissionStats>
)

data class SubmissionStats(
    val difficulty: String,
    val count: Int,
    val submissions: Int
)
