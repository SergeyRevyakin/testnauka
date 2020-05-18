package ru.serg.testnauka.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController
import ru.serg.testnauka.dao.DepartmentsRepository
import ru.serg.testnauka.dao.EmployeeRepository
import ru.serg.testnauka.model.Department
import ru.serg.testnauka.model.Employee

@RestController
//@RequestMapping("/test")
class RestController {

    @Autowired
    lateinit var departmentsRepository: DepartmentsRepository

    @Autowired
    lateinit var employeeRepository: EmployeeRepository

    @RequestMapping("/save/")
    fun save() {

        val newDept = Department("Boss", "Home")

        departmentsRepository.save(newDept)

        val emp1 = Employee("Serg", newDept, 1234567L, "HOUSE")
        val emp2 = Employee("Zerg", newDept, 64213213L, "MOUSE")

        employeeRepository.saveAll(setOf(emp1, emp2))

        val department = departmentsRepository.findAll().first()

        val emp3 = Employee("Berg", department, 1234567L, "HOUSE")
        val emp4 = Employee("Merg", department, 64213213L, "MOUSE")

        employeeRepository.saveAll(setOf(emp3, emp4))


    }

//    @RequestMapping("/")
//    fun start(): String {
//        return "HELLO"
//    }
//
//    @RequestMapping("/department/{id}")
//    fun getDepartmentById(@PathVariable id: Int): Optional<Department> {
//        return departmentsRepository.findById(id)
//    }
//
//    @GetMapping("/departments")
//    fun getDepartments(): List<Department> {
//        return departmentsRepository.findAll()
//    }
//
//    @PostMapping("/department")
//    fun postDepartment(@RequestBody department: Department) {
//        departmentsRepository.save(department)
//    }
//
//    @DeleteMapping("/department/{id}")
//    fun deleteDepartment(@PathVariable id: Int) {
//        departmentsRepository.deleteById(id)
//    }
//
//    @PutMapping("/department")
//    fun putDepartment(@RequestBody department: Department) {
//        departmentsRepository.save(department)
//    }

}