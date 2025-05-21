package com.example.groupsnavigation

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.groupsnavigation.databinding.ItemStudentBinding
import java.util.Date

class StudentsAdapter: RecyclerView.Adapter<StudentsAdapter.StudentsViewHolder>() {

    var selectedDate: Date?
        get() = _selectedDate
        set(value) {
            _selectedDate = value
            notifyDataSetChanged()
        }

    private val _students = mutableListOf<Student>()
    private var _selectedDate: Date? = null

    fun setStudents(students: List<Student>) {
        _students.addAll(students)
        notifyDataSetChanged()
    }

    class StudentsViewHolder(private val binding: ItemStudentBinding): RecyclerView.ViewHolder(binding.root) {

        private lateinit var student: Student
        private val ATTENDED_COLOR = "#00aa00"
        private val NOT_ATTENDED_COLOR = "#ffffff"

        fun bind(student: Student, date: Date?) {
            this.student = student

            binding.txtViewStudentFirstName.text = "Имя: ${this.student.firstName}"
            binding.txtViewStudentLastName.text = "Фамилия: ${this.student.lastName}"
            binding.studentPhoto.setImageResource(this.student.photoId)

            updateBackgroundColor(date)
        }

        fun updateBackgroundColor(date: Date?) =
            binding.root.setBackgroundColor(getAttendanceColor(date))

        fun setAttendance(date: Date?) {
            if (date == null)
                return

            val isAttended = student.isAttended[date]

            if (isAttended == null)
                student.isAttended[date] = true
            else
                student.isAttended[date] = !isAttended
        }

        private fun getAttendanceColor(date: Date?): Int {

            if (date == null || student.isAttended.isEmpty())
                return Color.parseColor(NOT_ATTENDED_COLOR)

            val isAttended = student.isAttended[date] ?: false

            return if (isAttended)
                Color.parseColor(ATTENDED_COLOR)
            else
                Color.parseColor(NOT_ATTENDED_COLOR)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentsViewHolder {
        val binding = ItemStudentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        val holder = StudentsViewHolder(binding)

        binding.root.setOnClickListener {
            holder.setAttendance(selectedDate)
            holder.updateBackgroundColor(selectedDate)
            notifyDataSetChanged()
        }

        return holder
    }

    override fun getItemCount(): Int = _students.size

    override fun onBindViewHolder(holder: StudentsViewHolder, position: Int) {
        holder.bind(_students[position], selectedDate)
    }
}