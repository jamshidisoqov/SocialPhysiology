package io.jamshid.socialphysiology.ui.home.topic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import io.jamshid.socialphysiology.R
import io.jamshid.socialphysiology.common.base.BaseFragment
import io.jamshid.socialphysiology.common.core.OnItemClickListener
import io.jamshid.socialphysiology.data.local.entities.topic.Topic
import io.jamshid.socialphysiology.databinding.ActionBarHomeBinding
import io.jamshid.socialphysiology.databinding.TopicFragmentBinding
import io.jamshid.socialphysiology.ui.home.topic.adapters.TopicAdapter
import kotlinx.coroutines.flow.collectLatest


@AndroidEntryPoint
class TopicFragment : BaseFragment<TopicViewModel>() {


    private var _binding: TopicFragmentBinding? = null
    private val binding: TopicFragmentBinding get() = _binding!!
    private var acBinding: ActionBarHomeBinding? = null
    private val vm: TopicViewModel by viewModels()
    private val args: TopicFragmentArgs by navArgs()
    private lateinit var adapter: TopicAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = TopicFragmentBinding.inflate(inflater, container, false)
        acBinding =
            ActionBarHomeBinding.bind(inflater.inflate(R.layout.action_bar_home, null, false))

        adapter = TopicAdapter(object : OnItemClickListener<Topic> {
            override fun onItemClick(data: Topic) {
                val action = TopicFragmentDirections.actionTopicFragmentToLessonFragment(data)
                findNavController().navigate(action)
            }
        })

        acBinding!!.apply {
            imgBack.visibility = View.VISIBLE
            imgBack.setOnClickListener {
                findNavController().navigateUp()
            }
        }


        vm.getAllTopics(args.chapter.id)

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            vm.topics.collectLatest {
                adapter.setData(it)
            }
        }

        binding.rcvTopic.adapter = adapter




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