package io.jamshid.socialphysiology.common.base

import androidx.fragment.app.Fragment

abstract class BaseFragment<T:BaseViewModel> : Fragment() {

    protected abstract val viewModel:T

}