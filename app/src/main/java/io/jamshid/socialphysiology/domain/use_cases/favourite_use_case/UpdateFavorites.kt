package io.jamshid.socialphysiology.domain.use_cases.favourite_use_case

import io.jamshid.socialphysiology.data.local.entities.lesson.Lesson
import io.jamshid.socialphysiology.domain.repository.Repository

class UpdateFavorites(private val repository: Repository) {
    suspend operator fun invoke(Lesson: Lesson) = repository.updateLesson(Lesson)
}