package com.taskkotech.taskko.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.taskkotech.taskko.R
import com.taskkotech.taskko.databinding.FragmentAddTaskBinding
import com.taskkotech.taskko.dialogs.DatePickerDialogFragment
import com.taskkotech.taskko.dialogs.TimePickerDialogFragment
import com.taskkotech.taskko.model.Task
import com.taskkotech.taskko.viewModel.TaskViewModel


class AddTaskFragment : Fragment() {

    private lateinit var binding: FragmentAddTaskBinding
    private val taskViewModel:TaskViewModel by activityViewModels()

    private var dateInMillis = ""
    private var timeInMillis = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentAddTaskBinding.inflate(inflater,container,false)

        clickListener()
        return binding.root
    }

    private fun clickListener() {
        binding.date.setOnClickListener {
            DatePickerDialogFragment { timestamp ->
                dateInMillis = timestamp
                binding.dateTV.text = dateInMillis
            }.show(childFragmentManager, "date_picker")
        }
        binding.time.setOnClickListener {
            TimePickerDialogFragment{time ->
                timeInMillis = time
                binding.timeTV.text = timeInMillis
            }.show(childFragmentManager, "time_picker")
        }

        binding.saveBTN.setOnClickListener {

            val newTask = Task(
                id = 0,
                title = binding.titleET.text.toString().trim(),
                description = binding.descriptionET.text.toString().trim(),
                date = dateInMillis,
                time = timeInMillis,
            )

            taskViewModel.insertTask(newTask)
            Toast.makeText(context, "Task added successfully", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addTaskFragment_to_homeFragment)
        }
    }

}