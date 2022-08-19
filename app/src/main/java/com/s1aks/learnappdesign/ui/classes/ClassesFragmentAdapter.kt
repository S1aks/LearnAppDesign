package com.s1aks.learnappdesign.ui.classes

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.s1aks.learnappdesign.R
import com.s1aks.learnappdesign.databinding.WrapClassitemBigBinding
import com.s1aks.learnappdesign.databinding.WrapClassitemSmallBinding
import com.s1aks.learnappdesign.model.entities.Class
import com.s1aks.learnappdesign.ui.skype_work_classes.ShowInWebClickListener

class ClassesFragmentAdapter(
    private val showInWebClickListener: ShowInWebClickListener
) :
    ListAdapter<Class, RecyclerView.ViewHolder>(ClassesCallback) {
    private lateinit var smallBinding: WrapClassitemSmallBinding
    private lateinit var bigBinding: WrapClassitemBigBinding

    override fun getItemViewType(position: Int): Int =
        when (currentList[position].type) {
            Class.ClassType.STANDARD -> 0
            Class.ClassType.ADDITIONAL -> 1
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            0 -> {
                smallBinding = WrapClassitemSmallBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                ClassesSmallViewHolder(smallBinding)
            }
            else -> {
                bigBinding = WrapClassitemBigBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                ClassesBigViewHolder(bigBinding)
            }
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (currentList[position].type) {
            Class.ClassType.STANDARD -> (holder as ClassesSmallViewHolder).bind(position)
            Class.ClassType.ADDITIONAL -> (holder as ClassesBigViewHolder).bind(position)
        }
    }

    inner class ClassesSmallViewHolder(private val binding: WrapClassitemSmallBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(position: Int) = with(binding) {
            currentList[position].let {
                if (position == 0) round.setImageResource(R.drawable.ic_round_green)
                time.text = it.timePeriod
                included.eventIconText.text = it.iconString
                included.eventName.text = it.name
                included.eventInfo.text = it.teacher
                setContainerParams(R.color.gray, it.showInWeb, it.skypeUri)
            }
        }

        private fun setContainerParams(backColorRes: Int, showInWeb: Boolean, uri: String) {
            binding.included.container.setBackgroundResource(backColorRes)
            when (showInWeb) {
                true -> {
                    binding.included.openInBlock.visibility = View.VISIBLE
                    binding.included.openInBlock.setOnClickListener {
                        showInWebClickListener.showInWebClick(uri)
                    }
                }
                else -> binding.included.openInBlock.visibility = View.GONE
            }
        }
    }

    inner class ClassesBigViewHolder(private val binding: WrapClassitemBigBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(position: Int) = with(binding) {
            currentList[position].let {
                if (position == 0) round.setImageResource(R.drawable.ic_round_green)
                time.text = it.timePeriod
                included.eventIconText.text = it.iconString
                included.eventName.text = it.name
                included.eventInfo.text = it.teacher
                included.eventDescription.text = it.description
                included.eventUser1.text = it.users?.get(0) ?: ""
                included.eventUser2.text = it.users?.get(1) ?: ""
                included.eventUser3.text = it.users?.get(2) ?: ""
            }
        }
    }

    companion object ClassesCallback : DiffUtil.ItemCallback<Class>() {
        override fun areItemsTheSame(oldItem: Class, newItem: Class) = oldItem == newItem
        override fun areContentsTheSame(oldItem: Class, newItem: Class) = oldItem == newItem
    }
}
