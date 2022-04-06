package ru.netology.Attachments

class File(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val ext: String,
    val size: Int,
    val date: Int,
    val type: Int,
    val url: String
)