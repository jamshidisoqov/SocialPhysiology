package io.jamshid.socialphysiology.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint
import io.jamshid.socialphysiology.R
import io.jamshid.socialphysiology.common.base.BaseFragment
import io.jamshid.socialphysiology.common.core.OnItemClickListener
import io.jamshid.socialphysiology.data.local.entities.chapter.Chapter
import io.jamshid.socialphysiology.databinding.HomeFragmentBinding
import io.jamshid.socialphysiology.ui.home.adapters.ChapterAdapter
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeViewModel>(),
    BottomNavigationView.OnNavigationItemSelectedListener {


    private var _binding: HomeFragmentBinding? = null
    private val binding: HomeFragmentBinding get() = _binding!!
    private val vm: HomeViewModel by viewModels()
    private lateinit var adapter: ChapterAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = HomeFragmentBinding.inflate(inflater, container, false)

        vm.getAllChapters()

        binding.bottomNavView.setOnNavigationItemSelectedListener(this)


        adapter = ChapterAdapter(object : OnItemClickListener<Chapter> {
            override fun onItemClick(data: Chapter) {
                val action = HomeFragmentDirections.actionHomeFragmentToTopicFragment(data)
                findNavController().navigate(action)
            }
        })

        binding.rcvChapter.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            vm.chapters.collectLatest {
                adapter.setData(it)
            }
        }

        binding.apply {
            searchViewContainer.setOnClickListener {
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToSearchFragment(
                        1
                    )
                )
            }
            imgInfo.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_infoFragment)
            }
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override val viewModel: HomeViewModel
        get() = vm

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.save -> {
                if (binding.bottomNavView.selectedItemId != R.id.save)
                    findNavController().navigate(R.id.favouriteFragment)
            }
        }
        return true
    }

    override fun onResume() {
        super.onResume()
        binding.bottomNavView.selectedItemId=R.id.home
    }
}