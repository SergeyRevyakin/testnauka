package ru.serg.testnauka.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.serg.testnauka.dao.DepartmentsRepository
import ru.serg.testnauka.dao.EmployeeRepository
import ru.serg.testnauka.model.Department
import java.util.*

@RestController
@RequestMapping("/department/")
class DepartmentController {

    @Autowired
    lateinit var departmentsRepository: DepartmentsRepository

    @Autowired
    lateinit var employeeRepository: EmployeeRepository

    @GetMapping("/id={id}")
    fun getDepartmentById(@PathVariable id: Int): Optional<Department> {
        return departmentsRepository.findById(id)
    }

    @GetMapping("/name={name}")
    fun getDepartmentByName(@PathVariable name: String): Optional<Department> {
        return departmentsRepository.findByName(name)
    }

    @GetMapping("/all")
    fun getDepartments(): List<Department> {
        return departmentsRepository.findAll()
    }

    @PostMapping("/post")
    fun postDepartment(@RequestBody department: Department) {
        departmentsRepository.save(department)
    }

    @DeleteMapping("/del={id}")
    fun deleteDepartment(@PathVariable id: Int) {
        departmentsRepository.deleteById(id)
    }

    @PutMapping("/put")
    fun putDepartment(@RequestBody department: Department) {

        departmentsRepository.save(department)
    }
}
