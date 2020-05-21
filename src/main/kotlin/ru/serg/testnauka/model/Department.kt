package ru.serg.testnauka.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator::class,
//                property = "id")
data class Department(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int? = 0,

        val name: String?,

        val location: String?,

        @OneToMany(mappedBy = "department", cascade = [CascadeType.REFRESH, CascadeType.MERGE, CascadeType.REMOVE], fetch = FetchType.EAGER) //cascade = [CascadeType.ALL],
//        @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//        @JsonIdentityReference(alwaysAsId = true)
        //@JoinColumn(name = "department_id")
        //@JsonManagedReference
        @JsonIgnoreProperties("employee")
        val employee: List<Employee> = emptyList()

)