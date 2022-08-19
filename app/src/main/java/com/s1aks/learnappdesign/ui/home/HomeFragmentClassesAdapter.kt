package com.s1aks.learnappdesign.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.s1aks.learnappdesign.R
import com.s1aks.learnappdesign.databinding.CardClassItemSmallBinding
import com.s1aks.learnappdesign.model.entities.Class
import com.s1aks.learnappdesign.ui.skype_work_classes.ShowInWebClickListener

class HomeFragmentClassesAdapter(
    private val showInWebClickListener: ShowInWebClickListener
) :
    ListAdapter<Class, HomeFragmentClassesAdapter.ClassesViewHolder>(ClassesCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassesViewHolder =
        ClassesViewHolder(
            CardClassItemSmallBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ClassesViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class ClassesViewHolder(private val binding: CardClassItemSmallBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(position: Int) = with(binding) {
            currentList[position].let {
                eventIconText.text = it.iconString
                eventName.text = it.name
                eventInfo.text = "⏱ ${it.timePeriod}"
                when (it.type) {
                    Class.ClassType.STANDARD -> {
                        setContainerParams(R.color.gray, it.showInWeb, it.skypeUri)
                    }
                    Class.ClassType.ADDITIONAL -> {
                        setContainerParams(R.drawable.shape_gradient, false, "")
                    }
                }
            }
        }

        private fun setContainerParams(backColorRes: Int, showInWeb: Boolean, uri: String) {
            binding.container.setBackgroundResource(backColorRes)
            when (showInWeb) {
                true -> {
                    binding.openInBlock.visibility = View.VISIBLE
                    binding.openInBlock.setOnClickListener {
                        showInWebClickListener.showInWebClick(uri)
                    }
                }
                else -> binding.openInBlock.visibility = View.GONE
            }
        }
    }

    companion object ClassesCallback : DiffUtil.ItemCallback<Class>() {
        override fun areItemsTheSame(oldItem: Class, newItem: Class) = oldItem == newItem
        override fun areContentsTheSame(oldItem: Class, newItem: Class) = oldItem == newItem
    }
}
