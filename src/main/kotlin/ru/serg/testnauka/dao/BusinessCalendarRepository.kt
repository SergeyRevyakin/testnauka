package ru.serg.testnauka.dao

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.serg.testnauka.model.BusinessCalendar

@Repository
interface BusinessCalendarRepository:JpaRepository<BusinessCalendar,Int>