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
            comments, copyright, likes, reposts, views, "post", 1234, canPin = true, canDelete = true,
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
            comments, copyright, likes, reposts, views, "post", 1234, canPin = true, canDelete = true,
            canEdit = true, isPinned = true, markedAsAds = true, isFavorite = true, donut = donut, postponedId = 1223
        )
        WallService.add(post1)
        val post2 = Post(
            1, 1, 2, 3, Date(), "текст поста 2", 4, 5, true,
            comments, copyright, likes, reposts, views, "post", 1234, canPin = true, canDelete = true,
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
            comments, copyright, likes, reposts, views, "post", 1234, canPin = true, canDelete = true,
            canEdit = true, isPinned = true, markedAsAds = true, isFavorite = true, donut = donut, postponedId = 1223
        )
        WallService.add(post1)
        val post2 = Post(
            999, 1, 2, 3, Date(), "текст поста 2", 4, 5, true,
            comments, copyright, likes, reposts, views, "post", 1234, canPin = true, canDelete = true,
            canEdit = true, isPinned = true, markedAsAds = true, isFavorite = true, donut = donut, postponedId = 1223
        )
        val actualUpdate = WallService.update(post2)
        assertFalse(actualUpdate)
    }

}