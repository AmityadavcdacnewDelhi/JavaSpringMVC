package mvcspring.controller;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import mvnspring.pojo.Category;
@Controller
public class CategoryController {
@Autowired
SessionFactory hibernateFactory;

   @GetMapping("/category")
	public ModelAndView showAllCategories()
	{
	 try(Session hibernateSession = hibernateFactory.openSession())
	 {
		 Query query = hibernateSession.getNamedQuery("allCategories");
		 List<Category> list =query.getResultList();
		 return new ModelAndView("category","data",list);
		 
	 }
	}
}
