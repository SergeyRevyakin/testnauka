package ru.serg.testnauka.model

import com.fasterxml.jackson.annotation.*
import javax.persistence.*


@Entity
//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator::class, property="id")
//@JsonIdentityReference(alwaysAsId = true)
data class Employee(
        //@JsonIgnore
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int?=0,

        val name: String?,
        val idNumber: Long,
        val address: String,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "department_id")
        @JsonIgnore
        val department: Department? = null

) {
    @JsonProperty("departmentId")
    fun getDepartmentId()=department?.id
}
