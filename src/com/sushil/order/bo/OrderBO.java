package com.sushil.order.bo;

import com.sushil.order.bo.exception.BOException;
import com.sushil.order.dto.Order;

public interface OrderBO {
	
	boolean placeOrder(Order order) throws BOException;
	
	boolean cancelOrder(int id) throws BOException;
	
	boolean deleteOrder(int id) throws BOException;

}
