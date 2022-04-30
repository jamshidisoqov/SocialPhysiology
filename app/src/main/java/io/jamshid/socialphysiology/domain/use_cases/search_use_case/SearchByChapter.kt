package io.jamshid.socialphysiology.domain.use_cases.search_use_case

import io.jamshid.socialphysiology.data.local.entities.chapter.Chapter
import io.jamshid.socialphysiology.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class SearchByChapter(private val repository: Repository) {
    operator fun invoke(query:String): Flow<List<Chapter>> = repository.searchByChapter(query)
}