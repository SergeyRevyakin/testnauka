package ru.serg.testnauka.model

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIdentityReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import javax.persistence.*

@Entity
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator::class, property="@depId")
data class Department(

        val name: String?,

        val location: String?,

        @OneToMany(mappedBy = "department", cascade = [CascadeType.MERGE], fetch = FetchType.EAGER) //cascade = [CascadeType.ALL],
//        @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//        @JsonIdentityReference(alwaysAsId = true)
        //@JoinColumn(name = "department_id")
        //@JsonManagedReference
        val employee: List<Employee> = emptyList(),

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int = 0
){
        override fun toString(): String {
                return "{name: ${name}, location: ${location}, employees: ${employee.map { it.name }}. id: ${id}}"
        }
}