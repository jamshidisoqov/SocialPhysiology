package io.jamshid.socialphysiology.ui.home.topic.lesson

import android.os.Bundle
import androidx.fragment.app.Fragment
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
import io.jamshid.socialphysiology.data.local.entities.lesson.Lesson
import io.jamshid.socialphysiology.databinding.ActionBarHomeBinding
import io.jamshid.socialphysiology.databinding.LessonFragmentBinding
import kotlinx.coroutines.flow.collectLatest


@AndroidEntryPoint
class LessonFragment : BaseFragment<LessonViewModel>() {


    private var _binding: LessonFragmentBinding? = null
    private val binding: LessonFragmentBinding get() = _binding!!
    private val vm: LessonViewModel by viewModels()
    private val args: LessonFragmentArgs by navArgs()
    private var lesson: Lesson? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = LessonFragmentBinding.inflate(inflater, container, false)

        vm.getLesson(args.topic.id)

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            vm.lesson.collectLatest {
                lesson = it
                binding.tvTextLesson.text = it.text
                if (it.status) {
                    binding.imgSaveLesson.setImageResource(R.drawable.ic_full_star)
                }
            }
        }

        binding.imgSaveLesson.setOnClickListener {
            vm.updateLesson(lesson!!.copy(status = !lesson!!.status))
            if (!lesson!!.status) {
                binding.imgSaveLesson.setImageResource(R.drawable.ic_full_star)
            } else {
                binding.imgSaveLesson.setImageResource(R.drawable.ic_star)
            }
        }
        binding.tvTitleAb.text = args.topic.name

        binding.imgBackLesson.setOnClickListener {
            findNavController().navigateUp()
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override val viewModel: LessonViewModel
        get() = vm

}