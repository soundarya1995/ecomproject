package com.ecom.DAOTest;
  
  
import static org.junit.Assert.assertNotNull; 
import static org.junit.Assert.assertTrue;
import java.util.List;
  
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
  
import com.ecom.DAO.ProductDAO;
import com.ecom.Model.Product;
  
   public class ProductDAOtest 
   { 
	   static ProductDAO productDAO;
	   private static AnnotationConfigApplicationContext context;
  
  @BeforeClass
  public static void executeFirst()
  { 
	  context = new AnnotationConfigApplicationContext();
	  context.scan("com.ecom");
      context.refresh();
  
  productDAO=(ProductDAO)context.getBean("productDAO"); 
  }
  
  
  @Test
  public void addProductTest()
  {
	  Product product=new Product();
  product.setProductId(1); product.setSupplierId(1); product.setCategoryId(1);
  product.setPrice(100); product.setStock(19);
  product.setProductName("Cosmetics");
  product.setProductDesc("Cosmetics Products");
  assertTrue("Problem in Category Insertion",productDAO.addProduct(product));
  }
 
  @Ignore
  @Test
 public void getProductTest()
  {
  assertNotNull("Problem in get Category",productDAO.getProduct(43)); 
  }
  
  @Ignore
  @Test 
  public void deleteProductTest()
  { 
	  Product product=productDAO.getProduct(43);
      assertTrue("Problem in Deletion:",productDAO.deleteProduct(product));
      }
  
  @Ignore
  
  @Test 
  public void updateProductTest()
  { 
  Product product=productDAO.getProduct(41);
  product.setPrice(699);
  product.setStock(9);
  assertTrue("Problem in Updation",productDAO.updateProduct(product));
  }
  @Ignore
  @Test 
  public void listProductTest()
  { 
	  List<Product>listProducts=productDAO.listProducts();
  assertNotNull("No Products",listProducts);
  
  for
  (Product product:listProducts)
  {
	  System.out.print(product.getStock()+" ");
      System.out.print(product.getPrice()+" ");
      System.out.println(product.getProductDesc()); }
  
  
  } }
 