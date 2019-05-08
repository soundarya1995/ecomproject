package com.ecom.DAOTest;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecom.DAO.OrderDetailDAO;
import com.ecom.Model.OrderDetail;

public class OrderDetailDAOtest
{
	static OrderDetailDAO orderDetailDAO;
	private static AnnotationConfigApplicationContext context;
	@BeforeClass
	public static void executefirst() {
		context=new AnnotationConfigApplicationContext();
		context.scan("com.ecom");
		context.refresh();
		orderDetailDAO=(OrderDetailDAO)context.getBean("orderDetailDAO");
	}
	@Test
	public void confirmOrderDetail() {
			OrderDetail orderDetail=new OrderDetail();
			orderDetail.setOrderId(1);
			orderDetail.setUsername("priya");
			orderDetail.setTotalAmount(10000);
			orderDetail.setShippingAddr("chennai");
			orderDetail.setTransactionType("CC");
			orderDetail.setOrderDate(String.format("%tc",new Date()));
			assertTrue("problem in adding",orderDetailDAO.confirmOrder(orderDetail));
	}
	
}
