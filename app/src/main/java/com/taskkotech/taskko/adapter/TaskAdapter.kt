package com.taskkotech.taskko.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.taskkotech.taskko.databinding.TaskItemViewBinding
import com.taskkotech.taskko.model.Task

class TaskAdapter:ListAdapter<Task,TaskAdapter.TaskViewHolder>(TaskDiffUtil()) {

    class TaskViewHolder(val binding:TaskItemViewBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(task:Task){
        binding.task=task
    }
}

class TaskDiffUtil: DiffUtil.ItemCallback<Task>(){
    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem==newItem
    }
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding=TaskItemViewBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task:Task=getItem(position)
        holder.bind(task)
    }
}