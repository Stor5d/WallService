package ru.netology

import ru.netology.Exception.CommentNotFoundException
import ru.netology.Exception.PostNotFoundException
import ru.netology.Exception.WrongReasonException

object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var repostsComments = emptyArray<ReportComment>()
    private var nextId: Int = 0

    fun add(post: Post): Post {
        nextId++
        val postNew = post.copy(id = nextId)
        posts += postNew
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, postOrigin) in posts.withIndex()) {
            if (post.id == postOrigin.id) {
                posts[index] = post.copy(date = postOrigin.date)
                return true
            }
        }
        return false
    }

    fun createComment(comment: Comment): Boolean {
        val post: Post =
            findPost(comment.postId) ?: throw PostNotFoundException("Пост с id ${comment.postId} не найден.")
        comments += comment
        return true
    }

    private fun findPost(id: Int): Post? {
        for ((index, postOrigin) in posts.withIndex()) {
            if (id == postOrigin.id) {
                return posts[index]
            }
        }
        return null
    }

    fun createReportComment(reportComment: ReportComment): Boolean {
        if (reportComment.reason in 0..8) {
            val comment: Comment = findComment(reportComment.commentId)
                ?: throw CommentNotFoundException("Комментарий с id ${reportComment.commentId} не найден.")
            repostsComments += reportComment
            return true
        } else {
            throw WrongReasonException("Неверный код причины. ${reportComment.reason}")
        }
    }

    private fun findComment(id: Int): Comment? {
        for ((index, comment) in comments.withIndex()) {
            if (id == comment.id) {
                return comments[index]
            }
        }
        return null
    }

    fun clearPosts() {
        posts = emptyArray()
        nextId = 0
    }

    fun countPosts(): Int {
        return posts.size
    }

}