package io.jamshid.socialphysiology.ui.search

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.jamshid.socialphysiology.common.base.BaseViewModel
import io.jamshid.socialphysiology.data.local.entities.chapter.Chapter
import io.jamshid.socialphysiology.domain.use_cases.UseCases
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(private val useCases: UseCases): BaseViewModel() {

    private var _chapters: MutableStateFlow<List<Chapter>> = MutableStateFlow(emptyList())
    val chapters: StateFlow<List<Chapter>> get() = _chapters

    fun getAllChapters() {
        viewModelScope.launch {
            useCases.getAllChapter.invoke().collectLatest {
                _chapters.emit(it)
            }
        }
    }

    fun adapterChange(newText:String){
        viewModelScope.launch {
            useCases.searchByChapter.invoke(newText).collectLatest {
                _chapters.emit(it)
            }
        }
    }


}