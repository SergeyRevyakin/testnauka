package ru.serg.testnauka.model

import javax.persistence.*

@Entity
data class Department(

        val name: String?,

        val location: String?,

        @OneToMany(mappedBy = "department",
                cascade = [CascadeType.ALL],
                fetch = FetchType.EAGER)
        //@JoinColumn(name = "department_id")
        val employee: List<Employee> = emptyList(),

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int = 0

)