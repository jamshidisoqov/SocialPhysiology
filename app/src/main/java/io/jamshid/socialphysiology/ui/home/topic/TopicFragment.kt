package io.jamshid.socialphysiology.ui.home.topic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import io.jamshid.socialphysiology.R
import io.jamshid.socialphysiology.common.base.BaseFragment
import io.jamshid.socialphysiology.databinding.ActionBarHomeBinding
import io.jamshid.socialphysiology.databinding.TopicFragmentBinding


@AndroidEntryPoint
class TopicFragment : BaseFragment<TopicViewModel>() {


    private var _binding: TopicFragmentBinding? = null
    private val binding: TopicFragmentBinding get() = _binding!!
    private var acBinding: ActionBarHomeBinding? = null
    private val vm: TopicViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = TopicFragmentBinding.inflate(inflater, container, false)
        acBinding = ActionBarHomeBinding.bind(inflater.inflate(R.layout.action_bar_home,container,false))

        acBinding.apply {

        }


        return binding.root
    }

    override val viewModel: TopicViewModel
        get() = vm

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        acBinding = null
    }

}