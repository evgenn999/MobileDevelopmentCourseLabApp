package com.example.mobiledevelopmentcourselabapp.presentation.view.second.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mobiledevelopmentcourselabapp.databinding.FragmentCardBinding
import com.example.mobiledevelopmentcourselabapp.databinding.ItemStudentBinding
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.model.AdUiModel
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.model.ItemUiModel
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.model.StudentUiModel

class StudentsAdapter(
    private val onStudentClicked: (StudentUiModel) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<ItemUiModel> = arrayListOf()

    fun updateItems(newItems: List<ItemUiModel>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == STUDENT_ID) {
            val binding =
                ItemStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            StudentHolder(binding)
        } else {
            val binding =
                FragmentCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            AdHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        if (item is StudentUiModel && holder is StudentHolder) {
            holder.bind(item)

            holder.setOnClickListener { onStudentClicked.invoke(item) }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is StudentUiModel -> STUDENT_ID
            AdUiModel -> AD_ID
            else -> AD_ID
        }
    }

    override fun getItemCount(): Int = items.size


    class StudentHolder(private val binding: ItemStudentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(student: StudentUiModel) {
            binding.name.text = student.name
            binding.number.text = student.number.toString()

            Glide
                .with(itemView)
                .load(student.photoUrl)
                .circleCrop()
                .into(binding.icon)
        }

        fun setOnClickListener(action: () -> Unit) {
            binding.root.setOnClickListener { action.invoke() }
        }
    }

    class AdHolder(binding: FragmentCardBinding) : RecyclerView.ViewHolder(binding.root)
    companion object {
        const val STUDENT_ID = 0
        const val AD_ID = 1
    }
}