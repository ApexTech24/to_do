package com.taskkotech.taskko.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.taskkotech.taskko.R
import com.taskkotech.taskko.databinding.FragmentAddTaskBinding


class AddTaskFragment : Fragment() {

    private lateinit var binding: FragmentAddTaskBinding

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
        binding.saveBTN.setOnClickListener {
            findNavController().navigate(R.id.action_addTaskFragment_to_homeFragment)
        }
    }

}