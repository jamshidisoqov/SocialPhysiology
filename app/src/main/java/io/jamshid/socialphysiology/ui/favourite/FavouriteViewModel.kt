package io.jamshid.socialphysiology.ui.favourite

import dagger.hilt.android.lifecycle.HiltViewModel
import io.jamshid.socialphysiology.common.base.BaseViewModel
import io.jamshid.socialphysiology.domain.use_cases.UseCases
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel @Inject constructor(private val useCases: UseCases) : BaseViewModel() {

}