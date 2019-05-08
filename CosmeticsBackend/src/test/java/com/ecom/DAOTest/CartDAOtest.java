package com.ecom.DAOTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecom.DAO.CartDAO;
import com.ecom.Model.Cart;


public class CartDAOtest
{
static CartDAO cartDAO;
private static AnnotationConfigApplicationContext context;

@BeforeClass
public static void executefirst() {
	context = new AnnotationConfigApplicationContext();
	context = new AnnotationConfigApplicationContext(); 
	context.scan("com.ecom");
	context.refresh();
	cartDAO=(CartDAO)context.getBean("cartDAO");
}

@Test
public void addcarttest() {
	Cart cart=new Cart();
	cart.setProductId(1);
	cart.setTotal(200);
	cart.setQuantity(5);
	cart.setProductName("Facewash");
	cart.setUsername("Mani");
	cart.setPaymentStatus("NP");
	assertTrue("problem in adding",cartDAO.addCart(cart));
}
@Ignore
@Test
public void getCartTest()
{
	assertNotNull("Problem in get Category",cartDAO.getCart(2));
}
@Ignore
@Test
public void deleteCartTest()
{
	Cart cart=cartDAO.getCart(110);
	assertTrue("Problem in Deletion:",cartDAO.deleteCart(cart));
}
@Ignore
@Test
public void updateCartTest()
{
	List<Cart> listCarts=cartDAO.getCarts("kalam");
	int num=0;
	for(Cart cart1:listCarts)
	{
			Cart cart2=cartDAO.getCart(cart1.getCartId());
			cart2.setPaymentStatus("P");
			cartDAO.updateCart(cart2);
			num++;
	}
	
	assertEquals(2,num);
}
@Ignore
@Test
public void listCartTest()
{
	List<Cart> listCarts=cartDAO.getCarts("sound");
	assertNotNull("No Cart",listCarts);
	
	for(Cart cart:listCarts)
	{
		System.out.print(cart.getCartId()+" ");
		System.out.print(cart.getProductId()+" ");
		System.out.println(cart.getProductName());
	}
}

}
