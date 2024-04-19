package com.example.demo.service.employe;

import java.util.List;

import com.example.demo.model.Employe;

public interface EmployeService {

	Employe saveEmploye(Employe e);
		
	Employe updateEmploye(Integer oldEmployeId, Employe newEmploye);
	
	void deleteEmploye(Integer empId);
	
	List<Employe> getAllEmploye();

	Employe getEmployeById(Integer employeId);
	
}
