package com.project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	@Query(value="select * from employees e where e.emp_id like %:keyword% or e.id like %:keyword%",nativeQuery=true)
	List<Employee> findByKeyword(@Param("keyword") String keyword);
}
