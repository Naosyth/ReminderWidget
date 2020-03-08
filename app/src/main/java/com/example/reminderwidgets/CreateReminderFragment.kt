package com.example.reminderwidgets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class CreateReminderFragment : Fragment() {
//    private lateinit var binding: CreateReminderFragmentBinding
//    private lateinit var viewModel: CreateReminderViewModel
//    private lateinit var viewModelFactory: CreateReminderViewModelFactory
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        viewModelFactory = CreateReminderViewModelFactory(requireActivity().application)
//        viewModel = ViewModelProvider(this, viewModelFactory).get(CreateReminderViewModel::class.java)
//
//        binding = DataBindingUtil.inflate(inflater, R.layout.create_reminder_fragment, container, false)
//        binding.viewModel = viewModel
//        binding.lifecycleOwner = this
//
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        binding.createTaskButton.setOnClickListener {
//            MainScope().launch {
//                viewModel.saveTask()
//                findNavController().popBackStack()
//            }
//        }
//    }
}
