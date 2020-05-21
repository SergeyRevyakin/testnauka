package ru.serg.testnauka.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.serg.testnauka.dao.BusinessCalendarRepository
import ru.serg.testnauka.dao.CalendarCodesRepository
import ru.serg.testnauka.model.BusinessCalendar

@RestController
@RequestMapping("/businesscalendar/")
class BusinessCalendarController {
    @Autowired
    lateinit var calendarCodesRepository: CalendarCodesRepository

    @Autowired
    lateinit var businessCalendarRepository: BusinessCalendarRepository

    @GetMapping("/all")
    fun getFullCalendar(): List<BusinessCalendar> = businessCalendarRepository.findAll()
}