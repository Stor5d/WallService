package ru.netology

import org.junit.Test
import org.junit.Assert.*
import java.util.*

class WallServiceTest {

    @Test
    fun add() {
        val expectedId = 0
        val comments = Comments(1, canPost = true, groupsCanPost = true, canClose = true, canOpen = true)
        val copyright = Copyright(1, "www.yandex.ru", "яндекс", "all")
        val likes = Likes(111, userLikes = true, canLike = true, canPublish = true)
        val reposts = Reposts(111, true)
        val views = Views(123)
        val donut = Donut(true, 1234, true, "all")
        val post1 = Post(
            0, 1, 2, 3, Date(), "текст поста 1", 4, 5, true,
            comments, copyright, likes, reposts, views, "post", null, null, 1, canPin = true, canDelete = true,
            canEdit = true, isPinned = true, markedAsAds = true, isFavorite = true, donut = donut, postponedId = 1223
        )
        WallService.add(post1)
        val actualId = post1.id
        assertNotEquals(expectedId, actualId)
    }

    @Test
    fun updateActualId() {
        val comments = Comments(1, canPost = true, groupsCanPost = true, canClose = true, canOpen = true)
        val copyright = Copyright(1, "www.yandex.ru", "яндекс", "all")
        val likes = Likes(111, userLikes = true, canLike = true, canPublish = true)
        val reposts = Reposts(111, true)
        val views = Views(123)
        val donut = Donut(true, 1234, true, "all")
        val post1 = Post(
            0, 1, 2, 3, Date(), "текст поста 1", 4, 5, true,
            comments, copyright, likes, reposts, views, "post", null, null, 1, canPin = true, canDelete = true,
            canEdit = true, isPinned = true, markedAsAds = true, isFavorite = true, donut = donut, postponedId = 1223
        )
        WallService.add(post1)
        val post2 = Post(
            1, 1, 2, 3, Date(), "текст поста 2", 4, 5, true,
            comments, copyright, likes, reposts, views, "post", null, null, 1, canPin = true, canDelete = true,
            canEdit = true, isPinned = true, markedAsAds = true, isFavorite = true, donut = donut, postponedId = 1223
        )
        val actualUpdate = WallService.update(post2)
        assertTrue(actualUpdate)
    }

    @Test
    fun updateNoActualId() {
        val comments = Comments(1, canPost = true, groupsCanPost = true, canClose = true, canOpen = true)
        val copyright = Copyright(1, "www.yandex.ru", "яндекс", "all")
        val likes = Likes(111, userLikes = true, canLike = true, canPublish = true)
        val reposts = Reposts(111, true)
        val views = Views(123)
        val donut = Donut(true, 1234, true, "all")
        val post1 = Post(
            0, 1, 2, 3, Date(), "текст поста 1", 4, 5, true,
            comments, copyright, likes, reposts, views, "post", null, null, 1, canPin = true, canDelete = true,
            canEdit = true, isPinned = true, markedAsAds = true, isFavorite = true, donut = donut, postponedId = 1223
        )
        WallService.add(post1)
        val post2 = Post(
            999, 1, 2, 3, Date(), "текст поста 2", 4, 5, true,
            comments, copyright, likes, reposts, views, "post", null, null, 1, canPin = true, canDelete = true,
            canEdit = true, isPinned = true, markedAsAds = true, isFavorite = true, donut = donut, postponedId = 1223
        )
        val actualUpdate = WallService.update(post2)
        assertFalse(actualUpdate)
    }

    @Test
    fun addAttachmentsAudio() {
        val comments = Comments(1, canPost = true, groupsCanPost = true, canClose = true, canOpen = true)
        val copyright = Copyright(1, "www.yandex.ru", "яндекс", "all")
        val likes = Likes(111, userLikes = true, canLike = true, canPublish = true)
        val reposts = Reposts(111, true)
        val views = Views(123)
        val donut = Donut(true, 1234, true, "all")
        val post = Post(
            0, 1, 2, 3, Date(), "текст поста 1", 4, 5, true,
            comments, copyright, likes, reposts, views, "post", null, null, 1, canPin = true, canDelete = true,
            canEdit = true, isPinned = true, markedAsAds = true, isFavorite = true, donut = donut, postponedId = 1223
        )
        val audio = Audio(1, 2, "Валерий Леонтьев", "Художник", 223, "www.musik.ru/leo/hudozhnik")
        val attachment = AudioAttachment(audio)
        WallService.add(post)
        assertTrue(post.addAttachments(attachment))
    }

    @Test
    fun addAttachmentsVideo() {
        val comments = Comments(1, canPost = true, groupsCanPost = true, canClose = true, canOpen = true)
        val copyright = Copyright(1, "www.yandex.ru", "яндекс", "all")
        val likes = Likes(111, userLikes = true, canLike = true, canPublish = true)
        val reposts = Reposts(111, true)
        val views = Views(123)
        val donut = Donut(true, 1234, true, "all")
        val post = Post(
            0, 1, 2, 3, Date(), "текст поста 1", 4, 5, true,
            comments, copyright, likes, reposts, views, "post", null, null, 1, canPin = true, canDelete = true,
            canEdit = true, isPinned = true, markedAsAds = true, isFavorite = true, donut = donut, postponedId = 1223
        )
        val video = Video(
            333, 444, "Летящая обезьяна", "обезьяна летит по горам",
            40, 11212121, 13223232, 30, "www.youtube.com"
        )
        val attachment = VideoAttachment(video)
        WallService.add(post)
        assertTrue(post.addAttachments(attachment))
    }

    @Test
    fun addAttachmentsPhoto() {
        val comments = Comments(1, canPost = true, groupsCanPost = true, canClose = true, canOpen = true)
        val copyright = Copyright(1, "www.yandex.ru", "яндекс", "all")
        val likes = Likes(111, userLikes = true, canLike = true, canPublish = true)
        val reposts = Reposts(111, true)
        val views = Views(123)
        val donut = Donut(true, 1234, true, "all")
        val post = Post(
            0, 1, 2, 3, Date(), "текст поста 1", 4, 5, true,
            comments, copyright, likes, reposts, views, "post", null, null, 1, canPin = true, canDelete = true,
            canEdit = true, isPinned = true, markedAsAds = true, isFavorite = true, donut = donut, postponedId = 1223
        )
        val photo = Photo(1, 1, 1, 1, "собака", 1, 300, 250, "www.photo.ru")
        val attachment = PhotoAttachment(photo)
        WallService.add(post)
        assertTrue(post.addAttachments(attachment))
    }

    @Test
    fun addAttachmentsFile() {
        val comments = Comments(1, canPost = true, groupsCanPost = true, canClose = true, canOpen = true)
        val copyright = Copyright(1, "www.yandex.ru", "яндекс", "all")
        val likes = Likes(111, userLikes = true, canLike = true, canPublish = true)
        val reposts = Reposts(111, true)
        val views = Views(123)
        val donut = Donut(true, 1234, true, "all")
        val post = Post(
            0, 1, 2, 3, Date(), "текст поста 1", 4, 5, true,
            comments, copyright, likes, reposts, views, "post", null, null, 1, canPin = true, canDelete = true,
            canEdit = true, isPinned = true, markedAsAds = true, isFavorite = true, donut = donut, postponedId = 1223
        )
        val file = File(1, 1, "ds", "txt", 100, 1, 1, "www.files.ru")
        val attachment = FileAttachment(file)
        WallService.add(post)
        assertTrue(post.addAttachments(attachment))
    }

    @Test
    fun addAttachmentsLink() {
        val comments = Comments(1, canPost = true, groupsCanPost = true, canClose = true, canOpen = true)
        val copyright = Copyright(1, "www.yandex.ru", "яндекс", "all")
        val likes = Likes(111, userLikes = true, canLike = true, canPublish = true)
        val reposts = Reposts(111, true)
        val views = Views(123)
        val donut = Donut(true, 1234, true, "all")
        val post = Post(
            0, 1, 2, 3, Date(), "текст поста 1", 4, 5, true,
            comments, copyright, likes, reposts, views, "post", null, null, 1, canPin = true, canDelete = true,
            canEdit = true, isPinned = true, markedAsAds = true, isFavorite = true, donut = donut, postponedId = 1223
        )
        val link = Link("www.links.com", "заголовок", "заголовок", "ссылка на заголовок")
        val attachment = LinkAttachment(link)
        WallService.add(post)
        assertTrue(post.addAttachments(attachment))
    }

    @Test
    fun postGetId() {
        val comments = Comments(1, canPost = true, groupsCanPost = true, canClose = true, canOpen = true)
        val copyright = Copyright(1, "www.yandex.ru", "яндекс", "all")
        val likes = Likes(111, userLikes = true, canLike = true, canPublish = true)
        val reposts = Reposts(111, true)
        val views = Views(123)
        val donut = Donut(true, 1234, true, "all")
        val post = Post(
            0, 1, 2, 3, Date(), "текст поста 1", 4, 5, true,
            comments, copyright, likes, reposts, views, "post", null, null, 1, canPin = true, canDelete = true,
            canEdit = true, isPinned = true, markedAsAds = true, isFavorite = true, donut = donut, postponedId = 1223
        )
        val expectedId = 0
        assertEquals(post.id, expectedId)
    }

    @Test
    fun postGetText() {
        val comments = Comments(1, canPost = true, groupsCanPost = true, canClose = true, canOpen = true)
        val copyright = Copyright(1, "www.yandex.ru", "яндекс", "all")
        val likes = Likes(111, userLikes = true, canLike = true, canPublish = true)
        val reposts = Reposts(111, true)
        val views = Views(123)
        val donut = Donut(true, 1234, true, "all")
        val post = Post(
            0, 1, 2, 3, Date(), "текст поста 1", 4, 5, true,
            comments, copyright, likes, reposts, views, "post", null, null, 1, canPin = true, canDelete = true,
            canEdit = true, isPinned = true, markedAsAds = true, isFavorite = true, donut = donut, postponedId = 1223
        )
        val expectedText = "текст поста 1"
        assertEquals(post.text, expectedText)
    }

}