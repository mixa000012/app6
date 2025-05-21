package com.example.groupsnavigation

import java.util.Date

data class Student(val firstName: String, val lastName: String, val photoId: Int, var isAttended: MutableMap<Date, Boolean> = mutableMapOf())