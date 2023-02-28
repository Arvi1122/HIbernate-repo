package com.hibernate;

import javax.transaction.SystemException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.dao.StudentDao;
import com.hibernate.dto.RequestDto;
import com.hibernate.entity.Student;

@RestController
@RequestMapping(value = "/create")
public class LoginControlller {

	StudentDao studentDao = new StudentDao();
	Student student = new Student();

	@PostMapping(name = "/user")
	public String creation(@RequestBody RequestDto requestDto) throws IllegalStateException, SystemException {
		if (requestDto != null) {
			student.setFirstName(requestDto.getFirstName());
			student.setLastName(requestDto.getLastName());
			student.setEmail(requestDto.getEmail());
			studentDao.saveStudent(student);

		}

		return "Succesfully Rigistered";

	}

}
