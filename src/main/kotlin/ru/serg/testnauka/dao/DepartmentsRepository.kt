package ru.serg.testnauka.dao

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.serg.testnauka.model.Department
import java.util.*

@Repository
interface DepartmentsRepository : JpaRepository<Department, Int> {
    fun findByName(name: String): Optional<Department>
}