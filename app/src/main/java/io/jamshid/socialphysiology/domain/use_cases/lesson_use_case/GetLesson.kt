package io.jamshid.socialphysiology.domain.use_cases.lesson_use_case

import io.jamshid.socialphysiology.data.local.entities.lesson.Lesson
import io.jamshid.socialphysiology.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class GetLesson(private val repository: Repository) {
    operator fun invoke(topicId: Int): Flow<Lesson> = repository.getAllLessonByTopic(topicId)
}