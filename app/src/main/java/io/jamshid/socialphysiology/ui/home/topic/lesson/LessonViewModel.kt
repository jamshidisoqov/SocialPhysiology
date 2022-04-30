package io.jamshid.socialphysiology.ui.home.topic.lesson

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.jamshid.socialphysiology.common.base.BaseViewModel
import io.jamshid.socialphysiology.data.local.entities.lesson.Lesson
import io.jamshid.socialphysiology.domain.use_cases.UseCases
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LessonViewModel @Inject constructor(private val useCases: UseCases): BaseViewModel() {

    private var _lesson:MutableStateFlow<Lesson> = MutableStateFlow(Lesson(1,"",1,false))
    val lesson:StateFlow<Lesson> get() = _lesson


    fun getLesson(topicId:Int){
        viewModelScope.launch {
            useCases.getLesson.invoke(topicId).collectLatest {
                _lesson.emit(it)
            }
        }
    }

    fun updateLesson(id:Int,status:Boolean){
        viewModelScope.launch {
            useCases.updateFavorites.invoke(id, status)
        }
    }

}