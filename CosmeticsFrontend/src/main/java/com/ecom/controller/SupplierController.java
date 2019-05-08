package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecom.DAO.SupplierDAO;
import com.ecom.Model.Supplier;

@Controller
public class SupplierController {
    @Autowired
    SupplierDAO supplierDAO;
	
    @RequestMapping(value="/supplier")
    public String displaySupplier(Model m)
	{
		List<Supplier> listSuppliers = supplierDAO.getSuppliers();
		
		m.addAttribute("listSuppliers",listSuppliers);
		
		return "Supplier";
	}
	
	@RequestMapping(value="/deleteSupplier/{supplierId}")
	public String deleteSupplier(@PathVariable("supplierId") int supplierId,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		
		supplierDAO.deleteSupplier(supplier);
		
		List<Supplier> listSuppliers=supplierDAO.getSuppliers();
		
		m.addAttribute("listSuppliers",listSuppliers);
	    
		return "Supplier";
	}

	@RequestMapping(value="/editSupplier/{supplierId}")
	public String editSupplier(@PathVariable("supplierId") int supplierId,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		
		m.addAttribute("supplier",supplier);
		
		return "UpdateSupplier";
	}
	
	@RequestMapping(value="/addSupplier",method=RequestMethod.POST)
	public String addSupplier(@RequestParam("supplierName")String supplierName,@RequestParam("supplierAddr")String supplierAddr,Model m) {
		
		Supplier supplier = new Supplier();
		supplier.setSupplierName(supplierName);
		supplier.setSupplierAddr(supplierAddr);
		
		supplierDAO.addSupplier(supplier);
		
		List<Supplier> listSuppliers = supplierDAO.getSuppliers();
		m.addAttribute("listSuppliers",listSuppliers);
		
		return "Supplier";
		
		
	}
	
	@RequestMapping(value="/updateSupplier",method=RequestMethod.POST)
	public String updateSupplier(@RequestParam("supplierId")int supplierId,
			@RequestParam("supplierName")String supplierName,@RequestParam("supplierAddr")String supplierAddr,Model m) {
		
		Supplier supplier = supplierDAO.getSupplier(supplierId);
		supplier.setSupplierName(supplierName);
		supplier.setSupplierAddr(supplierAddr);
		
		supplierDAO.updateSupplier(supplier);
		
		List<Supplier> listSuppliers = supplierDAO.getSuppliers();
		m.addAttribute("listSuppliers",listSuppliers);
		
		return "Supplier";
	}
}
