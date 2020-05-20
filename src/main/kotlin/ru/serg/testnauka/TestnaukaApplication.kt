package ru.serg.testnauka

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import ru.serg.testnauka.dao.CalendarCodesRepository

import ru.serg.testnauka.dao.DepartmentsRepository
import ru.serg.testnauka.dao.EmployeeRepository
import ru.serg.testnauka.model.Department
import ru.serg.testnauka.model.Employee
import java.awt.print.Book


@SpringBootApplication
class TestNaukaApplication : CommandLineRunner {
    @Autowired
    lateinit var departmentsRepository: DepartmentsRepository

    @Autowired
    lateinit var employeeRepository: EmployeeRepository

    @Autowired
    lateinit var calendarCodesRepository: CalendarCodesRepository

    override fun run(vararg args: String?) {
        fillDatabase()
    }

    fun fillDatabase(){
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

        val codes = listOf("Я – полный рабочий день" ,
                "Н – отсутствие на рабочее место по невыясненным причинам" ,
                "В – выходные и праздничные дни" ,
                "Рв – работа в праздничные и выходные дни а также работа в праздничные и выходные дни, при" ,
                "нахождении в командировке" ,
                "Б – дни временной нетрудоспособности" ,
                "К – командировочные дни а также, выходные (нерабочие) дни при нахождении в командировке," ,
                "когда сотрудник отдыхает, в соответствии с графиком работы ООО «Наука» в командировке" ,
                "ОТ – ежегодный основной оплаченный отпуск" ,
                "До – неоплачиваемый отпуск (отпуск за свой счет)" ,
                "Хд – хозяйственный день" ,
                "У – отпуск на период обучения." ,
                "Ож – Отпуск по уходу за ребенком.")
//        for (phrase in codes) {
//            phrase
//        }

        println(codes)
    }

}


fun main(args: Array<String>) {
    runApplication<TestNaukaApplication>(*args)
}
