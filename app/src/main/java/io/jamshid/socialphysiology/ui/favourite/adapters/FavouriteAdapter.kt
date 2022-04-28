package io.jamshid.socialphysiology.ui.favourite.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.jamshid.socialphysiology.R
import io.jamshid.socialphysiology.common.core.OnItemClickListener
import io.jamshid.socialphysiology.data.local.entities.chapter.Chapter
import io.jamshid.socialphysiology.data.local.entities.topic.Topic
import io.jamshid.socialphysiology.databinding.RcvChapterItemBinding

class FavouriteAdapter<T>(private val type: Int,private var onItemClickListener: OnItemClickListener<T>) :
    RecyclerView.Adapter<FavouriteAdapter<T>.ViewHolder>() {

    private lateinit var binding: RcvChapterItemBinding
    private var list: List<T> = emptyList()

    inner class ViewHolder(val binding: RcvChapterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: T) {
            binding.tvTitle.text = (if (type != 0) (data as Topic).name else (data as Chapter).name)
            binding.root.setOnClickListener {
                onItemClickListener.onItemClick(data)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = RcvChapterItemBinding.bind(
            LayoutInflater.from(parent.context).inflate(R.layout.rcv_chapter_item, parent, false)
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
        holder.binding.tvCounter.text = "${(position + 1)}"
    }

    override fun getItemCount(): Int = 10

    fun setData(list:List<T>){
        this.list=list
    }
}