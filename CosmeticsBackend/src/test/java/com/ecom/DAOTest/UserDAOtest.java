package com.ecom.DAOTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecom.DAO.UserDAO;
import com.ecom.Model.User;

public class UserDAOtest {

static UserDAO userDAO;
private static AnnotationConfigApplicationContext context; 
@BeforeClass
public static void executeFirst()
{
	context = new AnnotationConfigApplicationContext();
	context=new AnnotationConfigApplicationContext();
	context.scan("com.ecom");
	context.refresh();
	userDAO=(UserDAO)context.getBean("userDAO");
}
@Test
public void addUserTest()
{
	User user=new User();
	user.setMobileNo("8300454514");
	user.setPassword("sound");
	user.setUsername("sound");
	user.setRole("ROLE_ADMIN");
	user.setEmail("soundarya07eee@gmail.com");
	user.setAddress("tamilnadu");
	assertTrue("Problem in User Insertion",userDAO.addUser(user));
}
@Ignore
@Test
public void updateUserTest()
{
	User user=userDAO.getUser(112);
    user.setUsername("sound");
    user.setRole("ROLE_ADMIN");
	assertTrue("Problem in Updation",userDAO.updateUser(user));
}
@Ignore
@Test
public void listUserTest()
{
	List<User> listUser=userDAO.getUser();
	assertNotNull("No User",listUser);
	
	for(User user:listUser)
	{
		System.out.print(user.getUsername()+" ");
		System.out.print(user.getEmail()+" ");
		
	}
}
}



