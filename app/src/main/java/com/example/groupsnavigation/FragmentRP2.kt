package com.example.groupsnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.groupsnavigation.databinding.FragmentRp2Binding

class FragmentRP2 : Fragment() {

    private lateinit var binding: FragmentRp2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRp2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnPrevGroup.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentRP2_to_fragmentRP1)
        }
        binding.btnHome.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentRP2_to_fragmentMain)
        }
        binding.btnNextGroup.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentRP2_to_fragmentRP3)
        }

        val studentsAdapter = StudentsAdapter()

        with (view.findViewById<RecyclerView>(R.id.recyclerViewRP2)) {
            adapter = studentsAdapter
            layoutManager = LinearLayoutManager(view.context)
        }

        val students = listOf(
            Student("Михаил", "Широков", R.drawable.man_10),
            Student("Ольга", "Ибрагимова", R.drawable.man_11),
            Student("Никита", "Ковалев", R.drawable.man_1),
            Student("Александр", "Ильин", R.drawable.alpine),
            Student("Екатерина", "Беляева", R.drawable.woman),
            Student("Дмитрий", "Смирнов", R.drawable.man2),
            Student("Анастасия", "Волкова", R.drawable.teacher),
            Student("Сергей", "Попов", R.drawable.man_10),
            Student("Мария", "Сидорова", R.drawable.woman1),
            Student("Иван", "Новиков", R.drawable.man3),
            Student("Анна", "Федорова", R.drawable.woman3),
            Student("Владислав", "Морозов", R.drawable.man4),
            Student("Наталья", "Кузнецова", R.drawable.woman4),
            Student("Артем", "Макаров", R.drawable.man5),
            Student("Елена", "Орлова", R.drawable.woman5),
            Student("Роман", "Зайцев", R.drawable.man6),
            Student("Юлия", "Мельникова", R.drawable.woman6),
            Student("Павел", "Андреев", R.drawable.man7),
        )


        studentsAdapter.setStudents(students)
    }
}