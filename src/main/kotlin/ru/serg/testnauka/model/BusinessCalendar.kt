package ru.serg.testnauka.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.time.LocalDate
import javax.persistence.*

@Entity
data class BusinessCalendar(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int? = 0,

        val date: LocalDate? = LocalDate.now(),

        @OneToOne
        val code: CalendarCode,

        @ManyToOne(fetch = FetchType.EAGER, cascade = [CascadeType.REFRESH, CascadeType.MERGE, CascadeType.REMOVE])
        @JoinColumn(name = "employee_id")
        @JsonIgnoreProperties("businessCalendar")
        val employee: Employee
)