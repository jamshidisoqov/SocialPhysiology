package io.jamshid.socialphysiology.domain.repository

import io.jamshid.socialphysiology.data.local.dao.SocailDao
import io.jamshid.socialphysiology.data.local.entities.chapter.Chapter
import io.jamshid.socialphysiology.data.local.entities.lesson.Lesson
import io.jamshid.socialphysiology.data.local.entities.question.Question
import io.jamshid.socialphysiology.data.local.entities.topic.Topic
import io.jamshid.socialphysiology.data.local.entities.use_lib.UseLib
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(private val socialDao: SocailDao) {

    fun getAllChapter(): Flow<List<Chapter>> = socialDao.getAllChapter()

    fun getAllTopicByChapter(chapterId: Int): Flow<List<Topic>> =
        socialDao.getAllTopicByChapter(chapterId)

    fun getAllLessonByTopic(topicId: Int): Flow<Lesson> = socialDao.getLessonByTopic(topicId)

    fun getQuestionsByLesson(lessonId: Int): Flow<Question> =
        socialDao.getQuestionByLesson(lessonId)

    fun getUseLibsByLesson(lessonId: Int): Flow<UseLib> = socialDao.getUseLibByLesson(lessonId)

    fun getFavouriteByLesson():Flow<List<Lesson>> = socialDao.getFavourites()

    suspend fun updateLesson(lesson: Lesson) = socialDao.updateFavouritesByStatus(lesson)

}