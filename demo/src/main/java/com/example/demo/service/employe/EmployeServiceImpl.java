package com.example.demo.service.employe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.jparepository.EmployeDao;
import com.example.demo.model.Employe;

@Service
public class EmployeServiceImpl implements EmployeService {

	@Autowired
	private EmployeDao employeeDao;

	@Override
	public Employe saveEmploye(Employe employee) {

		Integer dupEmployeCount = this.employeeDao.findByEmailIdOrPhoneNo(employee.getEmailId(), employee.getPhoneNo());
		System.out.println(dupEmployeCount);
		if (dupEmployeCount.equals(0)) {
			return this.employeeDao.save(employee);
		}
		return null;
	}

	@Override
	public Employe updateEmploye(Integer oldEmployeId, Employe newEmployee) {

		Employe oldEmploye = this.employeeDao.findById(oldEmployeId)
				.orElseThrow(() -> new ResourceNotFoundException("Update Method :- old employee ", oldEmployeId));

		oldEmploye.setCity(newEmployee.getCity());
		oldEmploye.setCompany(newEmployee.getCompany());
		oldEmploye.setDob(newEmployee.getDob());
		oldEmploye.setEmailId(newEmployee.getEmailId());
		oldEmploye.setHouseAddress(newEmployee.getHouseAddress());
		oldEmploye.setName(newEmployee.getName());
		oldEmploye.setOccupation(newEmployee.getOccupation());
		oldEmploye.setPhoneNo(newEmployee.getPhoneNo());
		oldEmploye.setState(newEmployee.getState());
		return this.employeeDao.save(oldEmploye);
	}

	@Override
	public void deleteEmploye(Integer empId) {

		Employe employeToBeDeleted = this.employeeDao.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Delete Method :- employee ", empId));
		this.employeeDao.delete(employeToBeDeleted);
	}

	@Override
	public List<Employe> getAllEmploye() {
		return this.employeeDao.findAll();
	}

	@Override
	public Employe getEmployeById(Integer employeId) {
		Employe employeDetails = this.employeeDao.findById(employeId)
				.orElseThrow(() -> new ResourceNotFoundException("Get Employe Method :- employee ", employeId));
		return employeDetails;
	}
}
