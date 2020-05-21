package ru.serg.testnauka.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.serg.testnauka.dao.BusinessCalendarRepository
import ru.serg.testnauka.dao.CalendarCodesRepository
import ru.serg.testnauka.model.BusinessCalendar
import java.time.LocalDate

@RestController
@RequestMapping("/businesscalendar/")
class BusinessCalendarController {
    @Autowired
    lateinit var calendarCodesRepository: CalendarCodesRepository

    @Autowired
    lateinit var businessCalendarRepository: BusinessCalendarRepository

    @GetMapping("/all")
    fun getFullCalendar(): List<BusinessCalendar> = businessCalendarRepository.findAll()

    @GetMapping("/date={dateString}")
    fun getCalendarByDay(@PathVariable dateString: String): List<BusinessCalendar>?{
        val date = LocalDate.parse(dateString)
//        if (businessCalendarRepository.findByDate(date)?.isNotEmpty()!!){
//        return businessCalendarRepository.findByDate(date)}
//        else return null//listOf<BusinessCalendar>()
        return businessCalendarRepository.findByDate(date)
    }
}