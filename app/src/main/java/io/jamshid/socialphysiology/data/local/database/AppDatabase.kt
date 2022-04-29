package io.jamshid.socialphysiology.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import io.jamshid.socialphysiology.data.local.dao.SocailDao
import io.jamshid.socialphysiology.data.local.entities.chapter.Chapter
import io.jamshid.socialphysiology.data.local.entities.lesson.Lesson
import io.jamshid.socialphysiology.data.local.entities.question.Question
import io.jamshid.socialphysiology.data.local.entities.topic.Topic
import io.jamshid.socialphysiology.data.local.entities.use_lib.UseLib
import io.jamshid.socialphysiology.data.utils.Constants

@Database(
    entities = [Chapter::class, Lesson::class, Question::class, Topic::class, UseLib::class],
    version = Constants.DB_VERSION,
)
abstract class AppDatabase : RoomDatabase(){

    abstract fun socialDao(): SocailDao

}