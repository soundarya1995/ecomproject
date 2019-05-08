package com.ecom.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecom.DAO.UserDAO;
import com.ecom.Model.User;

@Controller
public class UserController 
{
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value="/Register") 
	public String displayRegister() {
	return "Register";
	}
	@RequestMapping(value="/addRegister", method = RequestMethod.POST) 
	public String displayRegister(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("address") String address,@RequestParam("contactNo") String contactNo,
			@RequestParam("email") String email,Model m) {
		

		boolean flag=false;
		List<User> listUser=userDAO.getUser();
		for(User user1:listUser) {
			if(username.equals(user1.getUsername())) {
				flag=true;
				break;
			}
		}
		
		if(flag==false) {
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setAddress(address);
		user.setMobileNo(contactNo);
		user.setEmail(email);
		userDAO.addUser(user);
		return "login";
		}
		else {
			m.addAttribute("alert","Username is already taken");
		}
		
	return "Register";
	}
		
		
	  @RequestMapping(value="/login") 
	  public String displayLogin() {
	  return "login";
	}

	@RequestMapping(value="/login_failure")
	public String invalid(HttpSession Session)
	{
		Session.setAttribute("ErrorMessage","Username or password is wrong");
		return "login";
	}
	

	
	@RequestMapping(value="/login_success")
	public String showMessage(@RequestParam(value="username")String name,@RequestParam(value="password")String password, 
			HttpSession session,Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		String page="";
		
		String role="ROLE_USER";
		for (GrantedAuthority authority:authorities) 
		{
		 System.out.println(authority.getAuthority());
		
		 if (authority.getAuthority().equals(role)) 
	     {
	    	 session.setAttribute("username",username);
			 session.setAttribute("SuccessMessage","Login Successful");
	    	 page="index"; 
	      }
	     else 
	     {  
	    page="index";
	    session.setAttribute("SuccessMessage","Login Successful");
	    session.setAttribute("username","Admin");
	    	 break;
	    }
		}
		 return page;
		}
	@RequestMapping(value="/perform_login")
	public ModelAndView showMessage(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		System.out.println("-----in controller-----");

		String message;
		ModelAndView mv ;
		if (userDAO.isValidUser(username,password)) 
		{
			message = "Successfully Logged in";
			 mv = new ModelAndView("product");
		} else{
			message="Please enter a valid username and password";
			mv=new ModelAndView("Success");
		}
	
		mv.addObject("message", message);
		mv.addObject("username", username);
		return mv;
	}
	
	@RequestMapping(value="/perform_logout")
	public ModelAndView logout(HttpServletRequest request,HttpSession session)
	{
		ModelAndView mv=new ModelAndView("login");
		session.invalidate();
		session=request.getSession(true);
		mv.addObject("logoutMessage","you are successfully logged out");
		mv.addObject("loggedOut","true");
		return mv;
	}
		
	
}
