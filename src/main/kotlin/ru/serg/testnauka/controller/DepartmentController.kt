package ru.serg.testnauka.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
import ru.serg.testnauka.dao.DepartmentsRepository
import ru.serg.testnauka.dao.EmployeeRepository
import ru.serg.testnauka.model.Department
import ru.serg.testnauka.model.Employee
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
        val employees = department.employee
        employees.forEach {
            it.department = department
            //it.depId = department.id
        }

        employeeRepository.saveAll(employees)
    }

    @DeleteMapping("/del={id}")
    fun deleteDepartment(@PathVariable id: Int) {
        departmentsRepository.deleteById(id)
    }

    @PutMapping("/")
    fun putDepartment(@RequestBody department: Department) {

        departmentsRepository.save(department)
    }


    //Test Methods
    @RequestMapping("/save/")
    fun save() {

        val newDept = Department("Boss", "Home")

        departmentsRepository.save(newDept)

        val emp1 = Employee(name = "Serg", idNumber = 1234567L, address = "HOUSE", department = newDept)
        val emp2 = Employee(name = "Sadfadfrg", idNumber = 1234567L, address = "HOUSE", department = newDept)

        employeeRepository.saveAll(setOf(emp1, emp2))

        val department = departmentsRepository.findById(101).get()

        val emp3 = Employee(name = "Ssfdhsg", idNumber = 1234567L, address = "HOUSE", department = department)
        val emp4 = Employee(name = "Fdf", idNumber = 1234567L, address = "HOUSE", department = department)

        employeeRepository.saveAll(setOf(emp3, emp4))

        val department2 = departmentsRepository.findById(102).get()

        val emp5 = Employee(name = "Fsferg", idNumber = 1234567L, address = "HOUSE", department = department2)
        val emp6 = Employee(name = "1erg", idNumber = 1234567L, address = "HOUSE", department = department2)

        employeeRepository.saveAll(setOf(emp5, emp6))

    }

    @RequestMapping("/101")
    fun test() = departmentsRepository.findById(101).get().toString()

    @RequestMapping("/102")
    fun test1() = departmentsRepository.findById(102)

    @RequestMapping("/deps")
    fun deps() = departmentsRepository.findAll()

    @RequestMapping("/emps")
    fun emps() = employeeRepository.findAll()

    @RequestMapping("/tr")
    fun tr() = departmentsRepository.findById(203).get().employee

}