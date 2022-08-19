package com.s1aks.learnappdesign.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.s1aks.learnappdesign.R
import com.s1aks.learnappdesign.databinding.CardHomeworkItemBinding
import com.s1aks.learnappdesign.model.MockData
import com.s1aks.learnappdesign.model.entities.Homework

class HomeFragmentHomeworksAdapter(private val context: Context) :
    ListAdapter<Homework, HomeFragmentHomeworksAdapter.HomeworksViewHolder>(HomeworksCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeworksViewHolder =
        HomeworksViewHolder(
            CardHomeworkItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: HomeworksViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class HomeworksViewHolder(private val binding: CardHomeworkItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n", "UseCompatLoadingForDrawables")
        fun bind(position: Int) = with(binding) {
            currentList[position].let {
                eventIconText.text = it.iconString
                eventName.text = it.name
                when {
                    it.timeLeft[0].digitToInt() < 3 -> {
                        eventTimeLeft.setTextColor(context.getColor(R.color.text_attention))
                    }
                    else -> {
                        eventTimeLeft.setTextColor(context.getColor(R.color.text_color_secondary))
                    }
                }
                eventTimeLeft.text = "⏱ ${it.timeLeft}"
                eventDescription.text = it.description
                eventUser1.text = it.users[0]
                eventUser1.background =
                    context.getDrawable(MockData.usersColorMap.getValue(it.users[0]))
                eventUser2.text = it.users[1]
                eventUser2.background =
                    context.getDrawable(MockData.usersColorMap.getValue(it.users[1]))
            }
        }
    }

    companion object HomeworksCallback : DiffUtil.ItemCallback<Homework>() {
        override fun areItemsTheSame(oldItem: Homework, newItem: Homework) = oldItem == newItem
        override fun areContentsTheSame(oldItem: Homework, newItem: Homework) = oldItem == newItem
    }
}
