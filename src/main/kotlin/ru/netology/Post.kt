package ru.netology

import ru.netology.Attachments.Attachment
import java.util.*

data class Post(
    val id: Int = 0,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Date = Date(),
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val comments: Comments?,
    val copyright: Copyright?,
    val likes: Likes?,
    val reposts: Reposts?,
    val views: Views?,
    val postType: String,
    val postSource: PostSource?,
    val geo: Geo?,
    val singerId: Int,
    val copyHistory: Array<String>?,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val donut: Donut?,
    val postponedId: Int
) {
    private var attachments = emptyArray<Attachment>()

    fun addAttachments(attachment: Attachment): Boolean {
        attachments += attachment
        return true
    }
}