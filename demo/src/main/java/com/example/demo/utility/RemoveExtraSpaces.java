package com.example.demo.utility;

import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Category;
import com.example.demo.model.Employe;

@Configuration
public class RemoveExtraSpaces {

	public Employe trimeSpaces(Employe employe) {
		employe.setCity(employe.getCity().trim());
		employe.setName(employe.getName().trim());
		employe.setEmailId(employe.getEmailId().trim());
		employe.setPhoneNo(employe.getPhoneNo().trim());
		employe.setOccupation(employe.getOccupation().trim());
		employe.setCity(employe.getCity().trim());
		employe.setState(employe.getState().trim());
		employe.setCompany(employe.getCompany().trim());
		return employe;
	}

	public Category trimeSpaces(Category category) {
		category.setName(category.getName().trim());
		return category;
	}
}
