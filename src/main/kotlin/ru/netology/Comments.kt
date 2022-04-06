package ru.netology

data class Comments(
    val count: Int,
    var canPost: Boolean,
    var groupsCanPost: Boolean,
    var canClose: Boolean,
    var canOpen: Boolean
)