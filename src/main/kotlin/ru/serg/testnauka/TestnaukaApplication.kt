package ru.serg.testnauka

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import ru.serg.testnauka.dao.BusinessCalendarRepository
import ru.serg.testnauka.dao.CalendarCodesRepository

import ru.serg.testnauka.dao.DepartmentsRepository
import ru.serg.testnauka.dao.EmployeeRepository
import ru.serg.testnauka.model.BusinessCalendar
import ru.serg.testnauka.model.CalendarCode
import ru.serg.testnauka.model.Department
import ru.serg.testnauka.model.Employee
import java.time.LocalDate


@SpringBootApplication
class TestNaukaApplication : CommandLineRunner {
    @Autowired
    lateinit var departmentsRepository: DepartmentsRepository

    @Autowired
    lateinit var employeeRepository: EmployeeRepository

    @Autowired
    lateinit var calendarCodesRepository: CalendarCodesRepository

    @Autowired
    lateinit var businessCalendarRepository: BusinessCalendarRepository

    override fun run(vararg args: String?) {
        fillDatabase()
    }

    fun fillDatabase() {
        val newDept = Department(name = "Boss", location = "Home")

        departmentsRepository.save(newDept)

        val emp1 = Employee(name = "Serg", idNumber = 1234567L, address = "HOUSE", department = newDept)
        val emp2 = Employee(name = "Max", idNumber = 1234567L, address = "Home", department = newDept)

        employeeRepository.saveAll(setOf(emp1, emp2))

        val department = departmentsRepository.findById(101).get()

        val emp3 = Employee(name = "Alex", idNumber = 1234567L, address = "Dome", department = department)
        val emp4 = Employee(name = "Dax", idNumber = 1234567L, address = "Dom", department = department)

        employeeRepository.saveAll(setOf(emp3, emp4))

        val department2 = departmentsRepository.findById(102).get()

        val emp5 = Employee(name = "German", idNumber = 1234567L, address = "Germany", department = department2)
        val emp6 = Employee(name = "Belg", idNumber = 1234567L, address = "Belgium", department = department2)

        employeeRepository.saveAll(setOf(emp5, emp6))

        val codes = listOf("Я – полный рабочий день",
                "Н – отсутствие на рабочем месте по невыясненным причинам",
                "В – выходные и праздничные дни",
                "Рв – работа в праздничные и выходные дни а также работа в праздничные и выходные дни, при" +
                        " нахождении в командировке",
                "Б – дни временной нетрудоспособности",
                "К – командировочные дни а также, выходные (нерабочие) дни при нахождении в командировке," +
                        " когда сотрудник отдыхает, в соответствии с графиком работы ООО «Наука» в командировке",
                "ОТ – ежегодный основной оплаченный отпуск",
                "До – неоплачиваемый отпуск (отпуск за свой счет)",
                "Хд – хозяйственный день",
                "У – отпуск на период обучения.",
                "Ож – Отпуск по уходу за ребенком.")

        codes.forEach {
            calendarCodesRepository.save(CalendarCode(it.split(" – ").first(), it.split(" – ").last()))
        }

        val calendarCode = calendarCodesRepository.findAll()

        val employeeList = employeeRepository.findAll()

        val businessCalendarList: MutableList<BusinessCalendar> = mutableListOf()

        employeeList.forEach {
            businessCalendarList.add(BusinessCalendar(date = LocalDate.now(), code = calendarCode.random(), employee = it))
            businessCalendarList.add(BusinessCalendar(date = LocalDate.now().minusDays(1), code = calendarCode.random(), employee = it))
            businessCalendarList.add(BusinessCalendar(date = LocalDate.now().minusDays(2), code = calendarCode.random(), employee = it))
            businessCalendarList.add(BusinessCalendar(date = LocalDate.now().minusDays(3), code = calendarCode.random(), employee = it))

        }

        businessCalendarRepository.saveAll(businessCalendarList)
    }

}


fun main(args: Array<String>) {
    runApplication<TestNaukaApplication>(*args)
}
