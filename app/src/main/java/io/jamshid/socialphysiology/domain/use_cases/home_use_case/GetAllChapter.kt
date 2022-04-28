package io.jamshid.socialphysiology.domain.use_cases.home_use_case

import io.jamshid.socialphysiology.data.local.entities.chapter.Chapter
import io.jamshid.socialphysiology.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class GetAllChapter(private val repository: Repository) {
    operator fun invoke(): Flow<List<Chapter>> = repository.getAllChapter()
}