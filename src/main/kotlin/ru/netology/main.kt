package ru.netology

import java.util.*

fun main() {
    val comments = Comments(1, canPost = true, groupsCanPost = true, canClose = true, canOpen = true)
    val copyright = Copyright(1, "www.yandex.ru", "яндекс", "all")
    val likes = Likes(111, userLikes = true, canLike = true, canPublish = true)
    val reposts = Reposts(111, true)
    val views = Views(123)
    val donut = Donut(true, 1234, true, "all")
    val post1 = Post(
        0, 1, 2, 3, Date(), "текст поста 1", 4, 5, true,
        comments, copyright, likes, reposts, views, "post", 1234, canPin = true, canDelete = true,
        canEdit = true, isPinned = true, markedAsAds = true, isFavorite = true, donut = donut, postponedId = 1223
    )
    val audio = Audio(1, 2, "Валерий Леонтьев", "Художник", 223, "www.musik.ru/leo/hudozhnik")
    val attachment1 = AudioAttachment(audio)
    post1.addAttachments(attachment1)
    val video = Video(
        333, 444, "Летящая обезьяна", "обезьяна летит по горам",
        40, 11212121, 13223232, 30, "www.youtube.com"
    )
    val attachment2 = VideoAttachment(video)
    post1.addAttachments(attachment2)
    val post2 = Post(
        0, 1, 2, 3, Date(), "текст поста 2", 4, 5, true,
        comments, copyright, likes, reposts, views, "post", 1234, canPin = true, canDelete = true,
        canEdit = true, isPinned = true, markedAsAds = true, isFavorite = true, donut = donut, postponedId = 1223
    )
    WallService.add(post1)
    WallService.add(post2)

}

object WallService {
    private var posts = emptyArray<Post>()
    private var nextId: Int = 1

    fun add(post: Post): Post {
        post.id = nextId
        nextId++
        posts += post
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, postOrigin) in posts.withIndex()) {
            if (post.id == postOrigin.id) {
                posts[index] = post.copy(id = postOrigin.id, date = postOrigin.date)
                return true
            }
        }
        return false
    }
}

data class Post(
    var id: Int = 0,
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
    val singerId: Int,
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

    fun addAttachments(attachment: Attachment) {
        attachments += attachment
    }
}

data class Comments(
    var count: Int,
    var canPost: Boolean,
    var groupsCanPost: Boolean,
    var canClose: Boolean,
    var canOpen: Boolean
)

data class Copyright(
    var id: Int,
    var link: String,
    var name: String,
    var type: String
)

data class Likes(
    var count: Int,
    var userLikes: Boolean,
    var canLike: Boolean,
    var canPublish: Boolean
)

data class Reposts(
    var count: Int,
    var userReposted: Boolean
)

data class Views(var count: Int)

data class Donut(
    var isDonut: Boolean,
    var paidDuration: Int,
    var canPublishFreeCopy: Boolean,
    var editMode: String
)

sealed class Attachment(val type: String)

data class AudioAttachment(val audio: Audio) : Attachment("audio")

class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int,
    val url: String
)

data class VideoAttachment(val video: Video) : Attachment("video")

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

data class PhotoAttachment(val photo: Photo) : Attachment("photo")

class Photo(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int,
    val text: String,
    val date: Int,
    val width: Int,
    val height: Int,
    val url: String
)

data class FileAttachment(val file: File) : Attachment("file")

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

data class LinkAttachment(val link: Link) : Attachment("link")

class Link(
    val url: String,
    val title: String,
    val caption: String,
    val description: String,
)

