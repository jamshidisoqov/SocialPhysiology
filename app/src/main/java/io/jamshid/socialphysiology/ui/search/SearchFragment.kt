package io.jamshid.socialphysiology.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import io.jamshid.socialphysiology.common.base.BaseFragment
import io.jamshid.socialphysiology.common.core.OnItemClickListener
import io.jamshid.socialphysiology.data.local.entities.chapter.Chapter
import io.jamshid.socialphysiology.databinding.SearchFragmentBinding
import io.jamshid.socialphysiology.ui.home.adapters.ChapterAdapter
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class SearchFragment : BaseFragment<SearchViewModel>() {

    private var _binding: SearchFragmentBinding? = null
    private val binding: SearchFragmentBinding get() = _binding!!
    private val vm: SearchViewModel by viewModels()
    private val args: SearchFragmentArgs by navArgs()
    private lateinit var adapter: ChapterAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = SearchFragmentBinding.inflate(inflater, container, false)

        vm.getAllChapters()

        adapter = ChapterAdapter(object : OnItemClickListener<Chapter> {
            override fun onItemClick(data: Chapter) {
                findNavController().navigate(
                    SearchFragmentDirections.actionSearchFragmentToTopicFragment(
                        data
                    )
                )
            }
        })

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            vm.chapters.collectLatest {
                adapter.setData(it)
            }
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


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override val viewModel: SearchViewModel
        get() = vm
}