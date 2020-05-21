package ru.serg.testnauka.model

import com.fasterxml.jackson.annotation.*
import javax.persistence.*


@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator::class,
                property = "id")
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
        @JsonIdentityReference(alwaysAsId = true)
        var department: Department? = null

        //@JsonProperty("depId")
//        @Transient
//        var depId: Int? = department?.id

) {

//    @JsonProperty("departmentId")
//    fun getDepartmentId()=department?.id
//
//    fun setDepartmentId(depId:Int) {
//        departmentId = depId
//    }
}
