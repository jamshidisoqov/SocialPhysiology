package io.jamshid.socialphysiology.domain.use_cases.favourite_use_case

import io.jamshid.socialphysiology.data.local.entities.lesson.Lesson
import io.jamshid.socialphysiology.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class GetFavourites(private val repository: Repository) {
    operator fun invoke(): Flow<List<Lesson>> = repository.getFavouriteByLesson()
}