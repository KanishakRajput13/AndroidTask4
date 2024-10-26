package com.example.sitask4.api.fields

data class UserBadges(
    val id: String,
    val displayName: String,
    val icon: String,
    val creationDate: String
)

data class UpcomingBadge(
    val name: String,
    val icon: String
)

data class BadgeResponse(
    val badgesCount: Int,
    val badges: List<UserBadges>,
    val upcomingBadges: List<UpcomingBadge>? = null,
    val activeBadge: String? = null
)
