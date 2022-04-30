package io.jamshid.socialphysiology.ui.home.topic.search

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import io.jamshid.socialphysiology.R
import io.jamshid.socialphysiology.common.base.BaseFragment
import io.jamshid.socialphysiology.common.core.OnItemClickListener
import io.jamshid.socialphysiology.data.local.entities.topic.Topic
import io.jamshid.socialphysiology.databinding.TopicSearchFragmentBinding
import io.jamshid.socialphysiology.ui.home.topic.adapters.TopicAdapter
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class TopicSearchFragment : BaseFragment<TopicSearchViewModel>() {


    private var _binding: TopicSearchFragmentBinding? = null
    private val binding: TopicSearchFragmentBinding get() = _binding!!
    private val vm: TopicSearchViewModel by viewModels()
    private val args: TopicSearchFragmentArgs by navArgs()
    private lateinit var adapter: TopicAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = TopicSearchFragmentBinding.inflate(inflater, container, false)

        vm.getAllTopics(args.chapter.id)

        adapter = TopicAdapter(object : OnItemClickListener<Topic> {
            override fun onItemClick(data: Topic) {
                findNavController().navigate(
                    TopicSearchFragmentDirections.actionTopicSearchFragmentToLessonFragment(
                        data
                    )
                )
            }
        })

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            vm.topics.collectLatest {
                adapter.setData(it)
            }
        }

        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.homeSearchIc.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                vm.adapterChange(query!!)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                vm.adapterChange(newText!!)
                return true
            }
        })

        binding.rcvSearch.adapter = adapter




        return binding.root
    }

    override val viewModel: TopicSearchViewModel
        get() = vm


}