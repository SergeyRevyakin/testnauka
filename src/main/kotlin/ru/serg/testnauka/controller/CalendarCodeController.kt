package ru.serg.testnauka.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.serg.testnauka.dao.CalendarCodesRepository
import ru.serg.testnauka.model.CalendarCode

@RestController
@RequestMapping("/calendarcode")
class CalendarCodeController {
    @Autowired
    lateinit var calendarCodesRepository: CalendarCodesRepository

    @GetMapping
    fun getCodes(): List<CalendarCode> = calendarCodesRepository.findAll()
}