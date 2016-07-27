package com.sushil.order.bo;

import java.sql.SQLException;

import com.sushil.order.bo.exception.BOException;
import com.sushil.order.dao.OrderDAO;
import com.sushil.order.dto.Order;

public class OrderBOImpl implements OrderBO {

	OrderDAO dao;
	
	
	public OrderDAO getDao() {
		return dao;
	}

	public void setDao(OrderDAO dao) {
		this.dao = dao;
	}

	@Override
	public boolean placeOrder(Order order) throws BOException {
		try {
			int result = dao.create(order);
			
			if(result == 0){
				return false;
			}
			
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	@Override
	public boolean cancelOrder(int id) throws BOException {
		try {
			Order order = dao.read(id);
			order.setStatus("cancelled");
			int result = dao.update(order);
			if(result == 0){
				return false;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	@Override
	public boolean deleteOrder(int id) throws BOException {
		try {
			int result = dao.delete(id);
			if(result == 0){
				return false;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	public String setName(String name) throws BOException{
		if(name == null){
			throw new BOException("Name cannot be null");
		}
		return name;
	}
}
