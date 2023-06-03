package dev.tharusha.wijayabahu.springcrud.repository;

import dev.tharusha.wijayabahu.springcrud.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
