package ru.serg.testnauka.dao

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository
import ru.serg.testnauka.model.Employee
@Repository
//@RepositoryRestResource(collectionResourceRel = "employees", path = "employees")
interface EmployeeRepository: JpaRepository<Employee, Int>