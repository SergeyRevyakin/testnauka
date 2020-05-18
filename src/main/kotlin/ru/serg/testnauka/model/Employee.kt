package ru.serg.testnauka.model

import javax.persistence.*


@Entity
data class Employee(

        val name: String?,

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "department_id")
        val department: Department? = null,

        val idNumber: Long,
        val address: String,

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int = 0
)
