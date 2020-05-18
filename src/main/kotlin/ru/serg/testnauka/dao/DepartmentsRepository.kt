package ru.serg.testnauka.dao

import org.springframework.data.jpa.repository.JpaRepository
import ru.serg.testnauka.model.Department

interface DepartmentsRepository: JpaRepository<Department, Int>