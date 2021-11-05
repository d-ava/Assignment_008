package com.example.assignment_008

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_008.databinding.ItemHorizontalBinding
import com.example.assignment_008.model.Cources

class HorizontalAdapter : RecyclerView.Adapter<HorizontalAdapter.ViewHolder>() {

    private val list: MutableList<Cources.NewCourse> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list1: Cources) {
        this.list.clear()
        this.list.addAll(list1.newCourses)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind()
    }

    override fun getItemCount() = list.size


    inner class ViewHolder(private val binding: ItemHorizontalBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var newCources: Cources.NewCourse
        fun onBind() {
            newCources = list[adapterPosition]
            binding.tvDuration.text = newCources.duration.toString()
            binding.tvQuestion.text = newCources.question.toString()
            binding.tvTitle.text = newCources.title
            binding.horizontalCard.setCardBackgroundColor(Color.parseColor("#" + newCources.mainColor))

        }

    }
}