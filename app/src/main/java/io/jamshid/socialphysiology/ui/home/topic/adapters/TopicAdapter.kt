package io.jamshid.socialphysiology.ui.home.topic.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.jamshid.socialphysiology.R
import io.jamshid.socialphysiology.common.core.OnItemClickListener
import io.jamshid.socialphysiology.common.core.TextWatcher
import io.jamshid.socialphysiology.data.local.entities.topic.Topic
import io.jamshid.socialphysiology.databinding.RcvChapterItemBinding

class TopicAdapter(private val onItemClickListener: OnItemClickListener<Topic>) : RecyclerView.Adapter<TopicAdapter.ViewHolder>() {

    private var binding: RcvChapterItemBinding? = null
    private var topicList:List<Topic> = emptyList()

    inner class ViewHolder(val binding: RcvChapterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(topic: Topic) {
            binding.tvTitle.text=TextWatcher.textSubstring(topic.name)
            binding.root.setOnClickListener { onItemClickListener.onItemClick(topic) }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = RcvChapterItemBinding.bind(
            LayoutInflater.from(parent.context).inflate(R.layout.rcv_chapter_item, parent, false)
        )
        return ViewHolder(binding!!)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(topicList[position])
        holder.binding.tvCounter.text = "${position+1}"
    }

    override fun getItemCount(): Int = topicList.size

    fun setData(list: List<Topic>){
        topicList=list
        notifyDataSetChanged()
    }
}