package io.jamshid.socialphysiology.ui.search

import dagger.hilt.android.lifecycle.HiltViewModel
import io.jamshid.socialphysiology.common.base.BaseViewModel
import io.jamshid.socialphysiology.domain.use_cases.UseCases
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(private val useCases: UseCases): BaseViewModel() {

}