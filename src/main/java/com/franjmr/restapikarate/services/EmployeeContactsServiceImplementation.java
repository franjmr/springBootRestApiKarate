package com.franjmr.restapikarate.services;

import org.springframework.stereotype.Service;
import com.franjmr.restapikarate.repository.EmployeeContactsRepository;

@Service
public class EmployeeContactsServiceImplementation implements EmployeeContactsService {
	
	private EmployeeContactsRepository contactRepository = new EmployeeContactsRepository();
	
	public EmployeeContactsServiceImplementation() {}

	@Override
	public String updateContacts() {
		return contactRepository.updateContact();
	}

}