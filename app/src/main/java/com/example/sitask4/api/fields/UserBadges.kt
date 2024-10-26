package com.example.sitask4.api.fields

data class UserBadges(
    val activeBadge: Any,
    val badges: List<Badge>,
    val badgesCount: Int,
    val upcomingBadges: List<UpcomingBadge>
)