package ru.netology

import ru.netology.Attachments.Attachment

data class Comment(
    val id: Int,
    val postId: Int,
    val fromId: Int,
    val date: Int,
    val text: String,
    val donut: Donut?,
    val replyToUser: Int?,
    val replyToComment: Int?,
    val ParentsStack: Array<Int>?,
    val thread: Thread
) {
    val attachments = emptyArray<Attachment>()
}