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

        @ManyToOne(fetch = FetchType.EAGER, cascade = [CascadeType.REFRESH, CascadeType.MERGE, CascadeType.REMOVE])
        @JoinColumn(name = "department_id")
        //@JsonBackReference
        //@JsonIgnore
        @JsonIgnoreProperties("employee")
        var department: Department? = null,

        @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = [CascadeType.REFRESH, CascadeType.MERGE, CascadeType.REMOVE])
        @JsonIgnoreProperties("employee")
        val businessCalendar: MutableList<BusinessCalendar>?= mutableListOf()

) {

//    @JsonProperty("departmentId")
//    fun getDepartmentId()=department?.id
//
//    fun setDepartmentId(depId:Int) {
//        departmentId = depId
//    }
}
