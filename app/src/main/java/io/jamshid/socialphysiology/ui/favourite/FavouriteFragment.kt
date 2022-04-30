package io.jamshid.socialphysiology.ui.favourite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import io.jamshid.socialphysiology.R
import io.jamshid.socialphysiology.common.base.BaseFragment
import io.jamshid.socialphysiology.common.core.OnItemClickListener
import io.jamshid.socialphysiology.data.local.entities.topic.Topic
import io.jamshid.socialphysiology.databinding.SelectedFragmentBinding
import io.jamshid.socialphysiology.ui.home.topic.adapters.TopicAdapter
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class FavouriteFragment : BaseFragment<FavouriteViewModel>() {

    private var _binding: SelectedFragmentBinding? = null
    private val binding: SelectedFragmentBinding get() = _binding!!
    private val vm: FavouriteViewModel by viewModels()
    private lateinit var adapter: TopicAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        vm.getFavouriteTopics()

        _binding = SelectedFragmentBinding.inflate(inflater, container, false)
            adapter = TopicAdapter(object :OnItemClickListener<Topic>{
                override fun onItemClick(data: Topic) {
                    findNavController().navigate(FavouriteFragmentDirections.actionFavouriteFragmentToLessonFragment(data))
                }
            })

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            vm.topics.collectLatest {
                adapter.setData(it)
            }
        }

        binding.imgBackLesson.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.rcvFavourite.adapter = adapter

        return binding.root
    }

    override val viewModel: FavouriteViewModel
        get() = vm

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}