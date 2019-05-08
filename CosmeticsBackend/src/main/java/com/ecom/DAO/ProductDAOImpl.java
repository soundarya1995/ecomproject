package com.ecom.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecom.Model.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO
{
	
	  @Autowired 
	  SessionFactory sessionFactory;
	  
	  
	  public boolean addProduct(Product product)
	  { 
		  try
		  {
	  sessionFactory.getCurrentSession().save(product);
	  System.out.println("Data Saved");
	  return true;
	  }
	  catch(Exception e)
		  {
		  System.out.println("Exception Arised "+e);
		  return false;
	  } 
	}
	  
	  
	  
	  
	  public boolean deleteProduct(Product product)
	  { 
		  try 
		  {
	  sessionFactory.getCurrentSession().delete(product);
	  System.out.println("Data Deleted ");
	  return true;
	  }
	  catch(Exception e)
		  { 
		  System.out.println("Exception Arised "+e);
		  return false;
	  }
	  
	  }
	  
	  
	  public boolean updateProduct(Product product)
	 { 
		 try
		 {
	  sessionFactory.getCurrentSession().update(product);
	  System.out.println("Data Updated ");
	  return true;
	  }
	  catch(Exception e)
		 {
		  System.out.println("Exception Arised "+e);
	  
	  return false; 
	  }
	  
	  }
	  
	  
	  
	  public Product getProduct(int productId)
	  {
	  Session session=sessionFactory.openSession(); 
	  Product product=session.get(Product.class,productId);
	  session.close();
	  return product;
	  }
	 
	  
	 
	  public List<Product> listProducts()
	  {
		  Session session=sessionFactory.openSession();
		  Query query= session.createQuery("from Product");
		  List<Product> listProducts =(List<Product>)query.list() ;
		  return listProducts;
	 
	  }
}
