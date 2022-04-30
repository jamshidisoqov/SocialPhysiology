package io.jamshid.socialphysiology.data.local.dao

import androidx.room.*
import io.jamshid.socialphysiology.data.local.entities.chapter.Chapter
import io.jamshid.socialphysiology.data.local.entities.lesson.Lesson
import io.jamshid.socialphysiology.data.local.entities.question.Question
import io.jamshid.socialphysiology.data.local.entities.topic.Topic
import io.jamshid.socialphysiology.data.local.entities.use_lib.UseLib
import kotlinx.coroutines.flow.Flow


@Dao
interface SocailDao {
    //chapter
    @Query("SELECT*FROM chapter")
    fun getAllChapter(): Flow<List<Chapter>>

    //topic
    @Query("SELECT*FROM paragraph WHERE chapter_id=:chapterId")
    fun getAllTopicByChapter(chapterId: Int): Flow<List<Topic>>

    //lesson
    @Query("SELECT*FROM lesson WHERE paragraph_id=:topicId")
    fun getLessonByTopic(topicId: Int): Flow<Lesson>

    //questions
    @Query("SELECT*FROM question WHERE chapter_id=:chapterId")
    fun getQuestionByLesson(chapterId: Int): Flow<Question>

    //use_lib
    @Query("SELECT*FROM uselib")
    fun getUseLibByLesson(): Flow<UseLib>

    //favourites
    @Query("SELECT*FROM lesson WHERE status=1")
    fun getFavourites(): Flow<List<Lesson>>

    @Update(entity = Lesson::class)
    suspend fun updateFavouritesByStatus(lesson: Lesson)

    //search by chapter
    @Transaction
    @Query("SELECT*FROM chapter WHERE name like '%' ||:query||'%'")
    fun searchByChapter(query: String): Flow<List<Chapter>>

    //search by topic
    @Transaction
    @Query("SELECT*FROM paragraph WHERE name like '%' ||:query||'%'")
    fun searchByTopic(query: String): Flow<List<Topic>>

    //
    @Transaction
    @Query("SELECT paragraph.chapter_id,paragraph.id,paragraph.name FROM lesson INNER JOIN paragraph on lesson.paragraph_id=paragraph.id where lesson.status=1")
    fun getFavouritesList(): Flow<List<Topic>>

    @Query("UPDATE lesson SET status=:status WHERE id=:lessonId")
    suspend fun updateLesson(lessonId: Int, status: Boolean)

}