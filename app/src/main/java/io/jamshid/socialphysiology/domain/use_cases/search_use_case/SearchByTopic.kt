package io.jamshid.socialphysiology.domain.use_cases.search_use_case

import io.jamshid.socialphysiology.data.local.entities.topic.Topic
import io.jamshid.socialphysiology.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class SearchByTopic(private val repository: Repository) {
    operator fun invoke(query: String): Flow<List<Topic>> = repository.searchByTopic(query)
}