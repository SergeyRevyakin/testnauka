package ru.serg.testnauka.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*


@Entity
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator::class,
//                property = "id")
//@JsonIdentityReference(alwaysAsId = true)
data class Employee(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int? = 0,

        val name: String?,
        val idNumber: Long?,
        val address: String?,

        @ManyToOne(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
        @JoinColumn(name = "department_id")
        //@JsonBackReference
        //@JsonIgnore
        @JsonIgnoreProperties("employee")
        var department: Department? = null,

        @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
        @JsonIgnoreProperties("employee")
        val businessCalendar: MutableList<BusinessCalendar>?= mutableListOf()

)