package io.jamshid.socialphysiology.ui.favourite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import io.jamshid.socialphysiology.R
import io.jamshid.socialphysiology.common.base.BaseFragment
import io.jamshid.socialphysiology.common.core.OnItemClickListener
import io.jamshid.socialphysiology.data.local.entities.chapter.Chapter
import io.jamshid.socialphysiology.databinding.SelectedFragmentBinding
import io.jamshid.socialphysiology.ui.favourite.adapters.FavouriteAdapter

@AndroidEntryPoint
class FavouriteFragment : BaseFragment<FavouriteViewModel>() {

    private var _binding: SelectedFragmentBinding? = null
    private val binding: SelectedFragmentBinding get() = _binding!!
    private val vm: FavouriteViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = SelectedFragmentBinding.inflate(inflater, container, false)
            val adapter = FavouriteAdapter(0,object :OnItemClickListener<Chapter>{
                override fun onItemClick(data: Chapter) {

                }
            })
        return binding.root
    }

    override val viewModel: FavouriteViewModel
        get() = vm

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}