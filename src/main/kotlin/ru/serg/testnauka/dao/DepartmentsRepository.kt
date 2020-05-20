package ru.serg.testnauka.dao

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.serg.testnauka.model.Department

@Repository
interface DepartmentsRepository: JpaRepository<Department, Int>