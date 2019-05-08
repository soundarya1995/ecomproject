package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecom.DAO.CategoryDAO;
import com.ecom.Model.Category;

@Controller
public class Categorycontroller {
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping(value="/category")
	public String displayCategory(Model m)
	{
		List<Category> listCategories = categoryDAO.getCategories();
		
		m.addAttribute("listCategories",listCategories);
		
		return "Category";
	}
	
	@RequestMapping(value="/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId") int categoryId,Model m)
	{
		Category category=categoryDAO.getCategory(categoryId);
		
		categoryDAO.deleteCategory(category);
		
		List<Category> listCategories=categoryDAO.getCategories();
		
		m.addAttribute("listCategories",listCategories);
	    
		return "Category";
	}

	@RequestMapping(value="/editCategory/{categoryId}")
	public String editCategory(@PathVariable("categoryId") int categoryId,Model m)
	{
		Category category=categoryDAO.getCategory(categoryId);
		
		m.addAttribute("category",category);
		
		return "UpdateCategory";
	}
	
	@RequestMapping(value="/addCategory",method=RequestMethod.POST)
	public String addCategory(@RequestParam("categoryName")String categoryName,@RequestParam("categoryDesc")String categoryDesc,Model m) {
		
		Category category = new Category();
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		
		categoryDAO.addCategory(category);
		
		List<Category> listCategories = categoryDAO.getCategories();
		m.addAttribute("listCategories",listCategories);
		
		return "Category";
		
		
	}
	
	@RequestMapping(value="/updateCategory",method=RequestMethod.POST)
	public String updateCategory(@RequestParam("categoryId")int categoryId,
			@RequestParam("categoryName")String categoryName,@RequestParam("categoryDesc")String categoryDesc,Model m) {
		
		Category category = categoryDAO.getCategory(categoryId);
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		
		categoryDAO.updateCategory(category);
		
		List<Category> listCategories = categoryDAO.getCategories();
		m.addAttribute("listCategories",listCategories);
		
		return "Category";
		
		
	}
	
}
