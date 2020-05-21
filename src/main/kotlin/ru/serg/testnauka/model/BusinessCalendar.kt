package ru.serg.testnauka.model

import ru.serg.testnauka.model.CalendarCode
import java.time.LocalDate
import javax.persistence.*

@Entity
data class BusinessCalendar(
        val date: LocalDate? = LocalDate.now(),

        @OneToOne
        val employee: Employee,

        @OneToOne
        val code: CalendarCode,

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id:Int?=0
) {
}