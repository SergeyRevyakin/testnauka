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

        @OneToMany(mappedBy = "department",
                cascade = [CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH],
                fetch = FetchType.EAGER)
        @JsonIgnoreProperties("employee")
        val employee: List<Employee> = emptyList()

)