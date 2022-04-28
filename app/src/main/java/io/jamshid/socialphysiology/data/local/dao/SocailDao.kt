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
    @Query("SELECT*FROM topic WHERE chapterId=:chapterId")
    fun getAllTopicByChapter(chapterId:Int):Flow<List<Topic>>
    //lesson
    @Query("SELECT*FROM lesson WHERE topicId=:topicId")
    fun getLessonByTopic(topicId:Int):Flow<Lesson>

    //question
    @Query("SELECT*FROM question WHERE lessonId=:lessonId")
    fun getQuestionByLesson(lessonId:Int):Flow<Question>
    //use_lib
    @Query("SELECT*FROM uselib WHERE lessonId=:lessonId")
    fun getUseLibByLesson(lessonId:Int):Flow<UseLib>
    //favourites
    @Query("SELECT*FROM lesson WHERE status=1")
    fun getFavourites():Flow<List<Lesson>>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateFavouritesByStatus(lesson: Lesson)


}