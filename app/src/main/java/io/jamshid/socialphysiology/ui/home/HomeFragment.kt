package io.jamshid.socialphysiology.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import io.jamshid.socialphysiology.R
import io.jamshid.socialphysiology.common.base.BaseFragment
import io.jamshid.socialphysiology.databinding.ActionBarHomeBinding
import io.jamshid.socialphysiology.databinding.HomeFragmentBinding
import io.jamshid.socialphysiology.ui.home.adapters.ChapterAdapter

class HomeFragment : BaseFragment<HomeViewModel>() {


    private var _binding: HomeFragmentBinding? = null
    private val binding: HomeFragmentBinding get() = _binding!!
    private val vm: HomeViewModel by viewModels()
    private lateinit var adapter: ChapterAdapter
    private var acBinding: ActionBarHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)

        acBinding = ActionBarHomeBinding.bind(inflater.inflate(R.layout.action_bar_home,container,false))

        adapter = ChapterAdapter()

        binding.rcvChapter.adapter = adapter

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override val viewModel: HomeViewModel
        get() = vm
}