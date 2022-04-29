package io.jamshid.socialphysiology.ui.home.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.jamshid.socialphysiology.R
import io.jamshid.socialphysiology.common.core.OnItemClickListener
import io.jamshid.socialphysiology.common.core.TextWatcher
import io.jamshid.socialphysiology.data.local.entities.chapter.Chapter
import io.jamshid.socialphysiology.databinding.RcvChapterItemBinding

class ChapterAdapter(private val onItemClickListener: OnItemClickListener<Chapter>) : RecyclerView.Adapter<ChapterAdapter.ViewHolder>() {

    private lateinit var binding: RcvChapterItemBinding
    private var chapterList: List<Chapter> = emptyList()

    inner class ViewHolder(val binding: RcvChapterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(chapter: Chapter) {
            binding.tvTitle.text = TextWatcher.textSubstring(chapter.name)
            binding.root.setOnClickListener { onItemClickListener.onItemClick(chapter) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = RcvChapterItemBinding.bind(
            LayoutInflater.from(parent.context).inflate(R.layout.rcv_chapter_item, parent, false)
        )
        return ViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(chapter = chapterList[position])
        holder.binding.tvCounter.text = "${position + 1}"
    }

    override fun getItemCount(): Int = chapterList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<Chapter>) {
        chapterList = list
        notifyDataSetChanged()
    }
}