package com.example.groupsnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.groupsnavigation.databinding.FragmentRp3Binding

class FragmentRP3 : Fragment() {

    private lateinit var binding: FragmentRp3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRp3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnPrevGroup.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentRP3_to_fragmentRP2)
        }
        binding.btnHome.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentRP3_to_fragmentMain)
        }

        val studentsAdapter = StudentsAdapter()

        with (view.findViewById<RecyclerView>(R.id.recyclerViewRP3)) {
            adapter = studentsAdapter
            layoutManager = LinearLayoutManager(view.context)
        }

        val students = listOf (
            Student("Мария", "Михайлова", R.drawable.man_11)
        )

        studentsAdapter.setStudents(students)
    }
}