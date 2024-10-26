package com.example.sitask4.api.fields

data class UserProfile(
    val username: String,
    val name: String,
    val birthday: String?,
    val avatar: String,
    val ranking: Int,
    val reputation: Int,
    val gitHub: String?,
    val twitter: String?,
    val linkedIN: String?,
    val website: List<String>,
    val country: String?,
    val company: String?,
    val school: String?,
    val skillTags: List<String>,
    val about: String
)