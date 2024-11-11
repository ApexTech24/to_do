package com.taskkotech.taskko.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.taskkotech.taskko.R
import com.taskkotech.taskko.adapter.TaskAdapter
import com.taskkotech.taskko.databinding.FragmentHomeBinding
import com.taskkotech.taskko.viewModel.TaskViewModel


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val taskViewModel:TaskViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentHomeBinding.inflate(inflater,container,false)
        val taskAdapter=TaskAdapter()
        binding.taskRecyclerView.layoutManager=LinearLayoutManager(requireActivity())
        binding.taskRecyclerView.adapter=taskAdapter
        taskAdapter.submitList(taskViewModel.getAllTask())
        binding.fab.setOnClickListener {

            findNavController().navigate(R.id.action_homeFragment_to_addTaskFragment)
        }
        return binding.root
    }

}