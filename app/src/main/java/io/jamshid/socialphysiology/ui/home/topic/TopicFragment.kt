package io.jamshid.socialphysiology.ui.home.topic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import io.jamshid.socialphysiology.R
import io.jamshid.socialphysiology.common.base.BaseFragment
import io.jamshid.socialphysiology.common.core.OnItemClickListener
import io.jamshid.socialphysiology.data.local.entities.topic.Topic
import io.jamshid.socialphysiology.databinding.DialogBottomSheetBinding
import io.jamshid.socialphysiology.databinding.TopicFragmentBinding
import io.jamshid.socialphysiology.ui.home.topic.adapters.TopicAdapter
import kotlinx.coroutines.flow.collectLatest


@AndroidEntryPoint
class TopicFragment : BaseFragment<TopicViewModel>() {


    private var _binding: TopicFragmentBinding? = null
    private val binding: TopicFragmentBinding get() = _binding!!
    private val vm: TopicViewModel by viewModels()
    private val args: TopicFragmentArgs by navArgs()
    private lateinit var adapter: TopicAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = TopicFragmentBinding.inflate(inflater, container, false)

        vm.getQuestion(args.chapter.id)

        adapter = TopicAdapter(object : OnItemClickListener<Topic> {
            override fun onItemClick(data: Topic) {
                val action = TopicFragmentDirections.actionTopicFragmentToLessonFragment(data)
                findNavController().navigate(action)
            }
        })

        binding.apply {

            searchViewContainer.setOnClickListener {
                findNavController().navigate(
                    TopicFragmentDirections.actionTopicFragmentToTopicSearchFragment(
                        args.chapter
                    )
                )
            }

            imgBack.setOnClickListener {
                findNavController().navigateUp()
            }



        }
        binding.imgQuestion.setOnClickListener {
            openQuestions()
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
    }

    private fun openQuestions() {
        val bd = DialogBottomSheetBinding.bind(layoutInflater.inflate(R.layout.dialog_bottom_sheet, null, false))

        val dialog = BottomSheetDialog(requireContext(), com.google.android.material.R.style.Base_ThemeOverlay_Material3_BottomSheetDialog)
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            vm.question.collectLatest {
                bd.tvQuestionText.text = it.text
            }
        }
        dialog.setContentView(bd.root)
        dialog.show()

    }

}