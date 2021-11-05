package com.example.assignment_008

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_008.databinding.ItemHorizontalBinding
import com.example.assignment_008.databinding.ItemVericalBinding
import com.example.assignment_008.model.Cources
import com.example.homework_013.extensions.glideExtension

class VerticalAdapter : RecyclerView.Adapter<VerticalAdapter.ViewHolder>() {

    private val list: MutableList<Cources.ActiveCourse> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list1: Cources) {
        this.list.clear()
        this.list.addAll(list1.activeCourses)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemVericalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind()
    }

    override fun getItemCount() = list.size


    inner class ViewHolder(private val binding: ItemVericalBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var activeCources: Cources.ActiveCourse
        fun onBind() {
            activeCources = list[adapterPosition]
            binding.tvBookingTime.text = activeCources.bookingTime.toString()
           binding.ivImage.glideExtension(binding.ivImage.toString())
            binding.verticalCard.setCardBackgroundColor(Color.parseColor("#" + activeCources.mainColor))
            var backgroundColorPercent = activeCources.backgroundColorPercent.toFloat() / 100
            binding.verticalCard.alpha = backgroundColorPercent

        }

    }
}