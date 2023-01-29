package mvcspring.controller;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import mvnspring.pojo.UserInfo;

@Controller
public class UsersController {
	@Autowired
	SessionFactory hibernatefactory;
	
	@GetMapping("/login")
	public void prepareLoginUser(Model data)
	{
		data.addAttribute("objUser" , new UserInfo());
	}
	@PostMapping("/authenticate")
	public String authenticateUser(@ModelAttribute("objUser")UserInfo objUser)
	{
		try(Session hibernateSession = hibernatefactory.openSession())
		{
			Query query =hibernateSession.getNamedQuery("authenticateUser");
			query.setParameter(1, objUser.getUserName());
			query.setParameter(2, objUser.getPassword());
			UserInfo result = (UserInfo)query.getSingleResult();
			return "redirect:category";
		}
		catch(NoResultException npe)
		{
			
		return "failure";
		}
	}
	}


