
  package com.ecom.DAOTest;
  
  import static org.junit.Assert.assertNotNull;
  import static org.junit.Assert.assertTrue;
  
  import java.util.List;
  
  import org.junit.BeforeClass;
  import org.junit.Ignore;
  import org.junit.Test;
  import org.springframework.context.annotation.AnnotationConfigApplicationContext;
  
  import com.ecom.DAO.SupplierDAO;
  import com.ecom.Model.Supplier;
  
  public class SupplierDAOtest 
 {
  
  static SupplierDAO supplierDAO;
  private static AnnotationConfigApplicationContext context;
  
  @BeforeClass
  public static void executeFirst()
  {
	  context = new AnnotationConfigApplicationContext(); 
	  context.scan("com.ecom");
      context.refresh();
  
  supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
  }
  
   @Test 
  public void addSupplierTest()
  {
	  Supplier supplier=new Supplier();
  supplier.setSupplierName("Body Shop");
  supplier.setSupplierAddr("TAmil nadu");
  assertTrue("Problem in Supplier Insertion",supplierDAO.addSupplier(supplier));
   }
  
  @Ignore
  @Test 
  public void getSupplierTest()
  {
  assertNotNull("Problem in get Supplier",supplierDAO.getSupplier(8)); 
  }
  
  @Ignore
  @Test
  public void deleteSupplierTest()
  {
	  Supplier supplier=supplierDAO.getSupplier(9);
      assertTrue("Problem in Deletion:",supplierDAO.deleteSupplier(supplier));
  }
  
  @Ignore
  @Test 
  public void updateSupplierTest() 
  { 
  Supplier supplier=supplierDAO.getSupplier(10);
  supplier.setSupplierName("Faster The Seller");
  assertTrue("Problem in Updation",supplierDAO.updateSupplier(supplier)); 
  }
  
  @Ignore
  @Test
  public void listSupplierTest() 
  {
	  List<Supplier>listSuppliers=supplierDAO.getSuppliers();
  assertNotNull("No Suppliers",listSuppliers);
  
  for(Supplier supplier:listSuppliers)
  {
     System.out.print(supplier.getSupplierId()+":::");
     System.out.print(supplier.getSupplierName()+":::");
     System.out.println(supplier.getSupplierAddr()); 
    }
  }
 }