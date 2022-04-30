package io.jamshid.socialphysiology.ui.home.topic.lesson

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint
import io.jamshid.socialphysiology.R
import io.jamshid.socialphysiology.common.base.BaseFragment
import io.jamshid.socialphysiology.data.local.entities.lesson.Lesson
import io.jamshid.socialphysiology.databinding.DialogTextBinding
import io.jamshid.socialphysiology.databinding.LessonFragmentBinding
import kotlinx.coroutines.flow.collectLatest


@AndroidEntryPoint
class LessonFragment : BaseFragment<LessonViewModel>() {


    private var _binding: LessonFragmentBinding? = null
    private val binding: LessonFragmentBinding get() = _binding!!
    private val vm: LessonViewModel by viewModels()
    private val args: LessonFragmentArgs by navArgs()
    private var lesson: Lesson? = null


    @SuppressLint("SetTextI18n")
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
            lesson = lesson!!.copy(status = !lesson!!.status)
            vm.updateLesson(lesson!!.id, lesson!!.status)
            if (lesson!!.status) {
                binding.imgSaveLesson.setImageResource(R.drawable.ic_full_star)
            } else {
                binding.imgSaveLesson.setImageResource(R.drawable.ic_star)
            }
        }
        val len = args.topic.name.length
        if (len >= 10)
            (args.topic.name.substring(0, 10) + "...").also { binding.tvTitleAb.text = it }
        else binding.tvTitleAb.text = args.topic.name

        binding.imgBackLesson.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.imgMenuLesson.setOnClickListener {
            openBottomSheet()
        }

        return binding.root
    }

    private fun openBottomSheet() {
        val bd = DialogTextBinding.bind(layoutInflater.inflate(R.layout.dialog_text, null, false))

        var adapter = ArrayAdapter(
            requireContext(), android.R.layout.simple_list_item_1,
            fonts
        )
        bd.actvFontFace.setAdapter(adapter)
        var adapter2 = ArrayAdapter(
            requireContext(), android.R.layout.simple_list_item_1,
            mode
        )
        bd.actvColorMode.setAdapter(adapter2)


        val dialog = BottomSheetDialog(
            requireContext(),
            com.google.android.material.R.style.Base_ThemeOverlay_Material3_BottomSheetDialog
        )
        bd.btnApply.setOnClickListener {
            when (bd.actvFontFace.text.toString()) {
                fonts[0] -> {
                    binding.tvTextLesson.typeface =
                        ResourcesCompat.getFont(requireContext(), R.font.comfortaa_light)
                }
                fonts[1] -> {
                    binding.tvTextLesson.typeface =
                        ResourcesCompat.getFont(requireContext(), R.font.advent_pro_light)
                }
                fonts[2] -> {
                    binding.tvTextLesson.typeface = Typeface.DEFAULT
                }
            }

            when (bd.actvColorMode.text.toString()) {
                mode[0] -> {
                    binding.root.setBackgroundColor(Color.parseColor("#DCCD51"))
                }
                mode[1] -> {
                    binding.root.setBackgroundColor(Color.GRAY)
                }
                mode[2] -> {
                    binding.root.setBackgroundColor(Color.GREEN)
                }
                mode[3] -> {
                    binding.root.setBackgroundColor(Color.parseColor("#f8f8f8"))
                }
            }

            dialog.dismiss()
        }
        var current = 18
        bd.tvTextSize.text = "$current"

        bd.imgDropUp.setOnClickListener {
            current++
            bd.tvTextSize.text = "$current"
            binding.tvTextLesson.textSize = current.toFloat()
        }

        bd.imgDropDown.setOnClickListener {
            current--
            bd.tvTextSize.text = "${current}"
            binding.tvTextLesson.textSize = current.toFloat()
        }

        dialog.setContentView(bd.root)

        dialog.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override val viewModel: LessonViewModel
        get() = vm

    companion object {
        val fonts = arrayOf("Comfortaa", "Advent_pro_light", "none")
        val mode = arrayOf("Sepia", "Gray", "Green", "none")
    }


}