package com.example.demo.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employe;

@Repository

public interface EmployeDao extends JpaRepository<Employe, Integer> {

	@Query("SELECT count(*) e FROM Employe e WHERE e.emailId = :emailId OR e.phoneNo = :phoneNo")
	Integer findByEmailIdOrPhoneNo(@Param("emailId") String emailId, @Param("phoneNo") String phoneNo);
}
