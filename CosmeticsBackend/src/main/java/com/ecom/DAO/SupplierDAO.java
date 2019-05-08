package com.ecom.DAO;
import java.util.List;
import com.ecom.Model.Supplier;
public interface SupplierDAO 
{
	
	 public boolean addSupplier(Supplier supplier);
	 public boolean deleteSupplier(Supplier supplier);
	 public boolean updateSupplier(Supplier supplier); 
	 public Supplier getSupplier(int supplierid); 
	 public List<Supplier>getSuppliers();
	 }
