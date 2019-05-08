package com.ecom.DAO;

import java.util.List;

import com.ecom.Model.Category;


public interface CategoryDAO
{
	public boolean addCategory(Category category);
	
	 public boolean deleteCategory(Category category);
	 public boolean updateCategory(Category category);
	 public Category getCategory(int categoryid);
	  public List<Category> getCategories();
	 
}