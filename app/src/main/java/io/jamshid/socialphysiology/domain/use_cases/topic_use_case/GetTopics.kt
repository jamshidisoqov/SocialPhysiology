package io.jamshid.socialphysiology.domain.use_cases.topic_use_case

import io.jamshid.socialphysiology.data.local.entities.topic.Topic
import io.jamshid.socialphysiology.domain.repository.Repository
import kotlinx.coroutines.flow.Flow


class GetTopics(private val repository: Repository) {
    operator fun invoke(chapterId: Int): Flow<List<Topic>> =
        repository.getAllTopicByChapter(chapterId)
}