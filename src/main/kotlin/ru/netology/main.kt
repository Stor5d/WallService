package ru.netology

import ru.netology.Attachments.Audio
import ru.netology.Attachments.AudioAttachment
import ru.netology.Attachments.Video
import ru.netology.Attachments.VideoAttachment
import java.util.*

fun main() {
    val thread = Thread(999, canPost = true, showRetlyButton = true, groupsCanPost = true)
    val comments = Comments(1, canPost = true, groupsCanPost = true, canClose = true, canOpen = true)
    val post = Post(
        0, 1, 2, 3, Date(), "здесь тектс поста", 4, 5,
        true, comments, null, null, null, null, "post", null,
        null, 7676, copyHistory = null, canPin = true, canDelete = true, canEdit = true, isPinned = true,
        markedAsAds = true, isFavorite = true, donut = null, postponedId = 2323
    )
    val audio = Audio(1, 2, "Валерий Леонтьев", "Художник", 223, "www.musik.ru/leo/hudozhnik")
    val attachmentAudio = AudioAttachment(audio)
    post.addAttachments(attachmentAudio)
    val video = Video(
        333, 444, "Летящая обезьяна", "обезьяна летит по горам", 40,
        11212121, 13223232, 30, "www.youtube.com"
    )
    val attachmentVideo = VideoAttachment(video)
    post.addAttachments(attachmentVideo)
    WallService.add(post)
    val comment = Comment(
        666, 1, 23000, 111, "тут текст комментария", null, null,
        null, null, thread
    )
    WallService.createComment(comment)
    val reportComment = ReportComment(222, 666, 1)
    WallService.createReportComment(reportComment)
}

