package com.example.groupsnavigation

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.groupsnavigation.databinding.FragmentRp1Binding
import java.text.SimpleDateFormat
import java.time.ZoneId
import java.util.Date

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentRP1.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentRP1 : Fragment() {

    private lateinit var binding: FragmentRp1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRp1Binding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNextGroup.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentRP1_to_fragmentRP2)
        }
        binding.btnHome.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentRP1_to_fragmentMain)
        }

        val studentsAdapter = StudentsAdapter()

        with (view.findViewById<RecyclerView>(R.id.recyclerViewRP1)) {
            adapter = studentsAdapter
            layoutManager = LinearLayoutManager(view.context)
        }

        val students = listOf (
            Student("Акульшин", "Иван", R.drawable.coding),
            Student("Акимов", "Дмитрий", R.drawable.turtle),
            Student("Арнаутова", "Алиса", R.drawable.ninja)
        )

        studentsAdapter.setStudents(students)

        val zoneId = ZoneId.systemDefault()
        val initialDate = Date(binding.calendarRp1.date)
        val localDate = initialDate.toInstant().atZone(zoneId).toLocalDate()
        val dateWithoutTime = Date.from(localDate
            .atStartOfDay(zoneId)
            .toInstant()
        )

        studentsAdapter.selectedDate = dateWithoutTime

        for (student in students)
           student.isAttended[dateWithoutTime] = false

        binding.calendarRp1.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val selectedDate = SimpleDateFormat("yyyy-MM-dd")
                .parse("$year-${month + 1}-$dayOfMonth")
            studentsAdapter.selectedDate = selectedDate

            studentsAdapter.notifyDataSetChanged()
        }
    }
}