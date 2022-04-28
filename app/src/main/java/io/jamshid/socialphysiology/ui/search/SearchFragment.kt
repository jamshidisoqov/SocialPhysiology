package io.jamshid.socialphysiology.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import io.jamshid.socialphysiology.common.base.BaseFragment
import io.jamshid.socialphysiology.databinding.SearchFragmentBinding

@AndroidEntryPoint
class SearchFragment : BaseFragment<SearchViewModel>() {

    private var _binding: SearchFragmentBinding? = null
    private val binding: SearchFragmentBinding get() = _binding!!
    private val vm: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = SearchFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override val viewModel: SearchViewModel
        get() = vm
}