package io.jamshid.socialphysiology.ui.select

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.jamshid.socialphysiology.R

class SelectedFragment : Fragment() {


    private lateinit var viewModel: SelectedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.selected_fragment, container, false)
    }



}