package io.jamshid.socialphysiology.ui.home.topic.search

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.jamshid.socialphysiology.common.base.BaseViewModel
import io.jamshid.socialphysiology.data.local.entities.topic.Topic
import io.jamshid.socialphysiology.domain.use_cases.UseCases
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopicSearchViewModel @Inject constructor(private val useCases: UseCases) : BaseViewModel() {

    private var _topics: MutableStateFlow<List<Topic>> = MutableStateFlow(emptyList())
    val topics: StateFlow<List<Topic>> get() = _topics

    fun getAllTopics(chapterId: Int) {
        viewModelScope.launch {
            useCases.getTopics.invoke(chapterId).collectLatest {
                _topics.emit(it)
            }
        }
    }

    fun adapterChange(newString: String) {
        viewModelScope.launch {
            useCases.searchByTopic.invoke(newString).collectLatest {
                _topics.emit(it)
            }
        }
    }

}