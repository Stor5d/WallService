package ru.netology.Attachments

class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val description: String,
    val duration: Int,
    val date: Int,
    val addingDate: Int,
    val views: Int,
    val url: String
)