package ru.serg.testnauka.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.Mapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.serg.testnauka.dao.CalendarCodesRepository
import ru.serg.testnauka.dao.DepartmentsRepository
import ru.serg.testnauka.dao.EmployeeRepository

@RestController
@RequestMapping("/employee/")
class EmployeeController {
    @Autowired
    lateinit var departmentsRepository: DepartmentsRepository

    @Autowired
    lateinit var employeeRepository: EmployeeRepository

    @Autowired
    lateinit var calendarCodesRepository: CalendarCodesRepository

    @GetMapping("/all")
    fun getAllEmployees() = employeeRepository.findAll()
}