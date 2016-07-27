package com.sushil.order.bo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sushil.order.bo.exception.BOException;
import com.sushil.order.dao.OrderDAO;
import com.sushil.order.dto.Order;

public class OrderBOImplTest {

	@Mock
	OrderDAO dao;
	OrderBOImpl bo;

	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		bo	= new OrderBOImpl();
		bo.setDao(dao);
	}
	
	@Test
	public void placeOrder_Should_Create_An_Order() throws SQLException, BOException {
		
		Order order = new Order();
		when(dao.create(order)).thenReturn(1);
		
		boolean result = bo.placeOrder(order);
		assertTrue(result);
		verify(dao).create(order);
	}
	
	
	@Test
	public void placeOrder_Should_Not_Create_An_Order() throws SQLException, BOException {
		
		Order order = new Order();
		when(dao.create(order)).thenReturn(new Integer(0));
		
		boolean result = bo.placeOrder(order);
		assertFalse(result);
		verify(dao).create(order);
	}

	
	@Test(expected=BOException.class)
	public void placeOrder_Should_Throw_BOException() throws SQLException, BOException {
		Order order = new Order();
		when(dao.create(order)).thenThrow(SQLException.class);
		
		bo.placeOrder(order);
	}

	@Test
	public void cancelOrder() throws SQLException, BOException{
		Order order = new Order();
		when(dao.read(123)).thenReturn(order);
		when(dao.update(order)).thenReturn(1);
		boolean result = bo.cancelOrder(123);
		assertTrue(result);
	}

	@Test
	public void cancelOrder_Should_Not_Cancel_The_Order() throws SQLException, BOException{
		Order order = new Order();
		when(dao.read(123)).thenReturn(order);
		when(dao.update(order)).thenReturn(0);
		boolean result = bo.cancelOrder(123);
		assertFalse(result);
	}

	@Test(expected = BOException.class)
	public void cancelOrder_Should_Throw_BOExcetion_On_Read() throws SQLException, BOException{
		when(dao.read(123)).thenThrow(SQLException.class);
		boolean cancelOrder = bo.cancelOrder(123);
		assertTrue(cancelOrder);
	}

	@Test(expected = BOException.class)
	public void testSetName_Throw_Exception_When_Name_Is_Null() throws BOException{
		String name = null;
		when(bo.setName(name)).thenThrow(BOException.class);
		
	}
}
