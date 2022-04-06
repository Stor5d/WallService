package ru.netology

data class Likes(
    var count: Int,
    var userLikes: Boolean,
    var canLike: Boolean,
    var canPublish: Boolean
)