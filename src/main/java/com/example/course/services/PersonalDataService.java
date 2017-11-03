package com.example.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.course.dao.impl.PersonalDataImpl;
import com.example.course.dao.impl.UserImpl;
import com.example.course.entities.Personaldata;
import com.example.course.entities.Users;

@Service
@Transactional
public class PersonalDataService {
	
	@Autowired
	private Personaldata personaldata;
	
	@Autowired
	private PersonalDataImpl personaldataImpl;
	
	@Autowired
	private UserImpl userImpl;

	public Personaldata getPersonalData(String username) {
		
		Users user = userImpl.getUserByUsername(username);

		return personaldataImpl.loadById(user.getId());
		
	}
	
	public void saveupdate(String username, String surname, String name, String patronymic) {
		
		Users user = userImpl.getUserByUsername(username);
		List<Personaldata> listPersonalData = personaldataImpl.getDataByUser(user.getId());
		
		personaldata.setSurname(surname);
		personaldata.setName(name);
		personaldata.setPatronymic(patronymic);
		personaldata.setUser(user);
		
		if (listPersonalData.isEmpty()) {
			personaldataImpl.save(personaldata);
		} else {
			personaldata.setId(listPersonalData.get(0).getId());
		
			personaldataImpl.update(personaldata);
		}
		
	}
	
}
