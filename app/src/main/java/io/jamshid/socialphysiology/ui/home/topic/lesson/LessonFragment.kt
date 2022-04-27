package io.jamshid.socialphysiology.ui.home.topic.lesson

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import io.jamshid.socialphysiology.R
import io.jamshid.socialphysiology.databinding.ActionBarHomeBinding
import io.jamshid.socialphysiology.databinding.LessonFragmentBinding

class LessonFragment : Fragment() {


    private var _binding: LessonFragmentBinding? = null
    private val binding: LessonFragmentBinding get() = _binding!!
    private var acBinding: ActionBarHomeBinding? = null
    private val vm: LessonViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = LessonFragmentBinding.inflate(inflater, container, false)
        acBinding =
            ActionBarHomeBinding.bind(inflater.inflate(R.layout.action_bar_home, container, false))

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}