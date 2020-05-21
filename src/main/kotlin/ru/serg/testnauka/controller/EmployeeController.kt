package ru.serg.testnauka.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.serg.testnauka.dao.CalendarCodesRepository
import ru.serg.testnauka.dao.DepartmentsRepository
import ru.serg.testnauka.dao.EmployeeRepository
import ru.serg.testnauka.model.Employee

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

    @GetMapping("/id={id}")
    fun getById(@PathVariable id:Int) = employeeRepository.findById(id)

    @DeleteMapping("/del={id}")
    fun deleteById(@PathVariable id:Int) = employeeRepository.deleteById(id)

    @PostMapping
    fun postEmployee(@RequestBody employee: Employee){
//        if (employee.depId!=null ){
//            val department = departmentsRepository.findById(employee.depId!!).get()
//            employee.department = department
//        }
        employeeRepository.save(employee)
    }
}