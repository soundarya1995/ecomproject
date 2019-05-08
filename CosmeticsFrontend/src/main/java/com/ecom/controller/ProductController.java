package com.ecom.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.DAO.CategoryDAO;
import com.ecom.DAO.ProductDAO;
import com.ecom.DAO.SupplierDAO;
import com.ecom.Model.Category;
import com.ecom.Model.Product;
import com.ecom.Model.Supplier;


@Controller
public class ProductController
{

	@Autowired
	ProductDAO productDAO;
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	SupplierDAO supplierDAO;
	

	@RequestMapping(value="/ProductDisplay")
	public String productDisplay (Model m) {
		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("listProducts", listProducts);

		return "ProductDisplay";
	}
	
	@RequestMapping(value="/ProductDesc/{productId}")
	public String productDesc(@PathVariable("productId") int productid,Model m) {
		Product product=productDAO.getProduct(productid);
		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("listProducts", listProducts);
		m.addAttribute("product",product);
	    return "ProductDesc";
	}
	
	
	@RequestMapping(value="/Product", method = RequestMethod.GET)
	public String displayProduct(Model m) {
		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("listProducts", listProducts);
		List<Category> listCategories=categoryDAO.getCategories();
		m.addAttribute("listCategories",listCategories);
		List<Supplier> listSuppliers = supplierDAO.getSuppliers();
		m.addAttribute("listSuppliers", listSuppliers);

		for (Product product : listProducts) {
			System.out.println(product.getProductName() + ",");
		}
		return "Product";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProduct(@RequestParam("productName") String productName, @RequestParam("productDesc") String productDesc,
			@RequestParam("productPrice") int productPrice,@RequestParam("productStock") int productStock,
			@RequestParam("categoryId") int categoryid,@RequestParam("supplierId") int supplierid,@RequestParam("pimage") MultipartFile pimage,Model m)
	{
		Product product=new Product();
		product.setProductName(productName);
		product.setProductDesc(productDesc);
		product.setPrice(productPrice);
		product.setStock(productStock);
		product.setCategoryId(categoryid);
		product.setSupplierId(supplierid);
		System.out.println(".........hello............"+pimage+"..............................................");
		productDAO.addProduct(product);

	    String path="C:\\Users\\Soundarya\\eclipse-workspace\\CosmeticsFrontend\\src\\main\\resources\\images\\";
		
	    path=path+String.valueOf(product.getProductId())+".jpg";
	    
	    System.out.println("....................................path :" +path+"........................................");
	    
		File image=new File(path);
		MultipartFile filedet=product.getPimage();
		
		System.out.println("...............................................filedet : "+filedet+"...............................................");
		
		if(!pimage.isEmpty())
		{

			try {
				byte[] buffer=pimage.getBytes();	
				FileOutputStream fos=new FileOutputStream(image);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(buffer);
				bs.close();

			}
			
			catch (Exception e)
			{
				System.out.println("Exception Arised:"+e);
				e.printStackTrace();
			}
			
		}
		else
		{
			System.out.println("Problem Occured in File Uploading");
		}
	   
	    List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("listProducts", listProducts);
		List<Category> listCategories=categoryDAO.getCategories();
		m.addAttribute("listCategories",listCategories);
		List<Supplier> listSuppliers = supplierDAO.getSuppliers();
		m.addAttribute("listSuppliers", listSuppliers);
		

		return "Product";
	}

	@RequestMapping(value="/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId") int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
		
		String path="C:\\Users\\Soundarya\\eclipse-workspace\\CosmeticsFrontend\\src\\main\\resources\\images\\";
		path=path+String.valueOf(product.getProductId())+".jpg";
	    File image=new File(path);
		image.delete();
		
		productDAO.deleteProduct(product);
		
		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("listProducts", listProducts);
		List<Category> listCategories=categoryDAO.getCategories();
		m.addAttribute("listCategories",listCategories);
		List<Supplier> listSuppliers = supplierDAO.getSuppliers();
		m.addAttribute("listSuppliers", listSuppliers);
		return "Product";
	}

	@RequestMapping(value="/editProduct/{productId}")
	public String editProduct(@PathVariable("productId") int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
		
		
		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("listProducts", listProducts);
		List<Category> listCategories=categoryDAO.getCategories();
		m.addAttribute("listCategories",listCategories);
		List<Supplier> listSuppliers = supplierDAO.getSuppliers();
		m.addAttribute("listSuppliers", listSuppliers);
		m.addAttribute("product",product);
		
		return "UpdateProduct";
	}

	@RequestMapping(value="/updateProduct",method=RequestMethod.POST)
	public String updateProduct(@RequestParam("productId") int productid,@RequestParam("productName") String productName,
			@RequestParam("productDesc") String productDesc,@RequestParam("price") int productPrice,@RequestParam("stock") int productStock,
			@RequestParam("categoryId") int categoryid,@RequestParam("supplierId") int supplierid, @RequestParam("pimage") MultipartFile pimage, Model m)
	{
		Product product=productDAO.getProduct(productid);
		product.setProductName(productName);
		product.setProductDesc(productDesc);
		product.setPrice(productPrice);
		product.setStock(productStock);
		product.setCategoryId(categoryid);
		product.setSupplierId(supplierid);
		System.out.println(".........hello............"+pimage+"..............................................");
		productDAO.updateProduct(product);
		
		 if(!pimage.isEmpty())
		
		 {
			 String path="C:\\Users\\Soundarya\\eclipse-workspace\\CosmeticsFrontend\\src\\main\\resources\\images\\";
		 
				
			
			path=path+String.valueOf(product.getProductId())+".jpg";
			  
			System.out.println("....................................path :" +path+"........................................");
			
			File oldimage=new File(path);
		    oldimage.delete();
			File image=new File(path);
			MultipartFile filedet=product.getPimage();
			
            System.out.println("...............................................filedet : "+filedet+"...............................................");
		 
           
            try 
            {
				byte[] buffer=pimage.getBytes();	
				FileOutputStream fos=new FileOutputStream(image);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(buffer);
				bs.close();

			}
			
			catch (Exception e)
			{
				System.out.println("Exception Arised:"+e);
				e.printStackTrace();
			}
			
		}
		productDAO.updateProduct(product);
		
		List<Product> listProducts = productDAO.listProducts();
		m.addAttribute("listProducts", listProducts);
		List<Category> listCategories=categoryDAO.getCategories();
		m.addAttribute("listCategories",listCategories);
		List<Supplier> listSuppliers = supplierDAO.getSuppliers();
		m.addAttribute("listSuppliers", listSuppliers);
		
		return "Product";
	}
		
}
