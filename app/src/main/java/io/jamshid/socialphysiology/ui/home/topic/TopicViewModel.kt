package io.jamshid.socialphysiology.ui.home.topic

import dagger.hilt.android.lifecycle.HiltViewModel
import io.jamshid.socialphysiology.common.base.BaseViewModel
import io.jamshid.socialphysiology.domain.use_cases.UseCases
import javax.inject.Inject

@HiltViewModel
class TopicViewModel @Inject constructor(private val useCases: UseCases) : BaseViewModel() {



}