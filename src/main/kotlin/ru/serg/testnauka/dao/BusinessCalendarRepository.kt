package ru.serg.testnauka.dao

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.serg.testnauka.model.BusinessCalendar
import java.time.LocalDate

@Repository
interface BusinessCalendarRepository:JpaRepository<BusinessCalendar,Int>{
    fun findByDate(date: LocalDate):List<BusinessCalendar>?
}