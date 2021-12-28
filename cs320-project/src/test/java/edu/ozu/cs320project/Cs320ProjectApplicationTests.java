package edu.ozu.cs320project;

import edu.ozu.cs320project.model.User;
import edu.ozu.cs320project.services.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class Cs320ProjectApplicationTests {

	@Autowired
	LoginService loginService;

	@Test
	void textService() {
		User resident = new User();

		resident.setType("Resident");
		resident.setUsertypeid(1);
		resident.setUserid(23);
		resident.setUsername("zeynep");

		assertTrue(resident!=null);
		assertTrue(resident.getType()=="Resident");
		assertTrue(resident.getUsertypeid()==1);
		assertTrue(resident.getUserid()==23);
		assertTrue(resident.getUsername()=="zeynep");


		User dormitoryOfficial = new User();
		dormitoryOfficial.setType("Dormitory Official");
		dormitoryOfficial.setUsertypeid(2);
		dormitoryOfficial.setUserid(42);
		dormitoryOfficial.setUsername("Dormitory");

		assertTrue(dormitoryOfficial!=null);
		assertTrue(dormitoryOfficial.getType()=="Dormitory Official");
		assertTrue(dormitoryOfficial.getUsertypeid()==2);
		assertTrue(dormitoryOfficial.getUserid()==42);
		assertTrue(dormitoryOfficial.getUsername()=="Dormitory");


	}

}
