package ru.serg.testnauka

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import ru.serg.testnauka.dao.DepartmentsRepository
import ru.serg.testnauka.dao.EmployeeRepository
import ru.serg.testnauka.model.Department
import ru.serg.testnauka.model.Employee
import java.awt.print.Book


@SpringBootApplication
class TestNaukaApplication  //CommandLineRunner {


    fun main(args: Array<String>) {
        runApplication<TestNaukaApplication>(*args)
    }

//    @Autowired
//    lateinit var departmentsRepository:DepartmentsRepository
//
//
//    override fun run(vararg args: String?) {
//        val employee1:Employee = Employee(null, "Serg", 12345L, "Home")
//        val employee2:Employee = Employee(null, "Zerg", 12345L, "Dome")
//
//        val emplList = listOf(employee1,employee2)
//
//        val newDepartment = Department(null, "NEW", "NEW", emplList)
//        departmentsRepository.save(newDepartment)
//    }
//}

//@SpringBootApplication
//class JpaApplication : CommandLineRunner {
//
//
//	companion object {
//		@JvmStatic
//		fun main(args: Array<String>) {
//			SpringApplication.run(JpaApplication::class.java, *args)
//		}
//	}
//
//	override fun run(vararg args: String?) {
//		TODO("Not yet implemented")
//	}
//}