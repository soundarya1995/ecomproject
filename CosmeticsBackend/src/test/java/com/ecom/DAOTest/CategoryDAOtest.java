package com.ecom.DAOTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecom.DAO.CategoryDAO;
import com.ecom.Model.Category;



public class CategoryDAOtest
{
    static CategoryDAO categoryDAO;
	private static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void executeFirst()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ecom");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	@Ignore
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryId(1);
		category.setCategoryName("Cosmetics");
		category.setCategoryDesc("Cosmetics Products");
		assertTrue("Problem in Category Insertion",categoryDAO.addCategory(category));
	}
	@Ignore
	@Test
	public void getCategoryTest()
	{
		assertNotNull("Problem in get Category",categoryDAO.getCategory(2));
	}
	
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(4);
		assertTrue("Problem in Deletion:",categoryDAO.deleteCategory(category));
	}
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category category=categoryDAO.getCategory(66);
		category.setCategoryName("chudi");
		assertTrue("Problem in Deletion:",categoryDAO.updateCategory(category));
	}
	@Ignore
	@Test
	public void listCategoriesTest()
	{
		List<Category> listcategories=categoryDAO.getCategories();
		assertNotNull("No Categories",listcategories);
		
		for(Category category:listcategories)
		{
			System.out.println(category.getCategoryId()+"-----");
			System.out.println(category.getCategoryName()+"-----");
			System.out.println(category.getCategoryDesc()+"-----");
		}
		
		
	}
	
}

