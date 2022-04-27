package io.jamshid.socialphysiology.ui.home.topic.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.jamshid.socialphysiology.R
import io.jamshid.socialphysiology.databinding.RcvChapterItemBinding

class TopicAdapter : RecyclerView.Adapter<TopicAdapter.ViewHolder>() {

    private var binding: RcvChapterItemBinding? = null

    inner class ViewHolder(val binding: RcvChapterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = RcvChapterItemBinding.bind(
            LayoutInflater.from(parent.context).inflate(R.layout.rcv_chapter_item, parent, false)
        )
        return ViewHolder(binding!!)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = 20
}