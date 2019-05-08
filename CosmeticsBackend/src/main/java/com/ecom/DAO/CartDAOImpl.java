package com.ecom.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecom.Model.Cart;
@Repository("cartDAO")
@Transactional

public class CartDAOImpl implements CartDAO
{
	@Autowired
	SessionFactory sessionFactory;

	public boolean addCart(Cart cart) {
		try
		{
			sessionFactory.getCurrentSession().save(cart);
			System.out.println("Cart Added");
			return true;
		}
		catch(Exception e)
		{
			System.out.print("Exception arised "+e);
			return false;
		}
	}

	
	public boolean updateCart(Cart cart) {
		try
		{
			sessionFactory.getCurrentSession().update(cart);
			System.out.println("Cart Updated");
			return true;
		}
		catch(Exception e)
		{
			System.out.print("Exception arised "+e);
			return false;
		}
	}

	
	public boolean deleteCart(Cart cart) {
		try
		{
			sessionFactory.getCurrentSession().delete(cart);
			System.out.println("Cart Deleted");
			return true;
		}
		catch(Exception e)
		{
			System.out.print("Exception arised "+e);
			return false;
		}
	}
	public List<Cart> getCarts(String username) {
		Session session=sessionFactory.openSession();
		Query query = session.createQuery("from Cart where Username=:username and PaymentStatus='NP'");
		query.setParameter("username",username);
		List<Cart> listCart=(List<Cart>)query.list();
		return listCart;
	}
	
	
	public List<Cart> getPaidCarts(String username) {
		Session session=sessionFactory.openSession();
		Query query = session.createQuery("from Cart where username=:username and paymentstatus='P'");
		query.setParameter("username",username);
		List<Cart> listCart=(List<Cart>)query.list();
		return listCart;
	}

	
	public Cart getCart(int cartId) {
		Session session=sessionFactory.openSession();
		Cart cart=(Cart)session.get(Cart.class,cartId);
		session.close();
		return cart;
	}
}
