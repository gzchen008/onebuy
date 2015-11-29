package com.xianchumo.shop.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.xianchumo.shop.dao.OrderDao;
import com.xianchumo.shop.entity.Order;
import com.xianchumo.shop.entity.PageObj;
import com.xianchumo.shop.util.InfoUtil;
@SuppressWarnings("unchecked")
@Repository(value="orderDao")
public class OrderDaoImpl extends BaseDaoImpl<Order> 
	implements OrderDao{
	public final int pageSize = 10;
	@Override
	public PageObj<Order> findByMerchant(Long merchantId, int page) {
		StringBuilder totalQuery=new StringBuilder(64);
		totalQuery.append("select count(oid) from Order as order where merchant_id=")
		   		  .append(merchantId.toString());
		Long totalCount = totalCount(totalQuery.toString());
		if(totalCount != 0){
			StringBuilder queryString = new StringBuilder(64);
			queryString.append("from Order as order where merchant_id=")
					   .append(merchantId.toString());
			List<Order> list = find(queryString.toString(), (page-1)*pageSize, pageSize);
			if(list != null && list.size() != 0){
				return new PageObj<Order>(list, totalCount, pageSize, page);
			}
		}
		return null;
	}

	@Override
	public PageObj<Order> findRecordByMerchant(Long merchantId, int page) {
		StringBuilder totalQuery=new StringBuilder(64);
		totalQuery.append("select count(oid) from Order as order where merchant_id=")
		   .append(merchantId.toString())
		   .append(" and orderState>=4");
		Long totalCount = totalCount(totalQuery.toString());
		if(totalCount != 0){
			StringBuilder queryString = new StringBuilder(64);
			queryString.append("from Order as order where merchant_id=")
					   .append(merchantId.toString())
					   .append(" and orderState>=4");
			List<Order> list = find(queryString.toString(), (page-1)*pageSize, pageSize);
			if(list != null && list.size() != 0){
				return new PageObj<Order>(list, totalCount, pageSize, page);
			}
		}
		return null;
	}
	
	@Override
	public PageObj<Order> findByDateAndState(Long merchantId, Date orderTime, int page, Integer state) {
		StringBuilder totalQuery=new StringBuilder(64);
		totalQuery .append("select count(oid) from Order as order where merchant_id=")
				   .append(merchantId.toString())
				   .append(" and orderTime<=\'")
				   .append(orderTime)
				   .append("\' and orderState=")
				   .append(state.toString());
		Long totalCount = totalCount(totalQuery.toString());
		if(totalCount != 0){
			StringBuilder queryString = new StringBuilder(64);
			queryString.append("from Order as order where merchant_id=")
			   .append(merchantId.toString())
			   .append(" and orderTime<=\'")
			   .append(orderTime)
			   .append("\' and orderState=")
			   .append(state.toString());
			List<Order> list = find(queryString.toString(), (page-1)*pageSize, pageSize);
			if(list != null && list.size() != 0){
				return new PageObj<Order>(list, totalCount, pageSize, page);
			}
		}
		return null;
	}

	@Override
	public PageObj<Order> findByMerchantAndState(Long merchantId, int state,
			int page) {
		StringBuilder totalQuery=new StringBuilder(64);
		totalQuery.append("select count(oid) from Order as order where order.merchant.mid=")
		   	      .append(merchantId.toString());
		//state:1代表未处理的订单，2代表已处理的订单
		if(state==1){
			totalQuery.append(" and orderState<=2");
		}else{
			totalQuery.append(" and orderState>2");
		}
		Long totalCount = totalCount(totalQuery.toString());
		if(totalCount != 0){
			StringBuilder queryString = new StringBuilder(64);
			queryString.append("from Order as order where order.merchant.mid=")
					   .append(merchantId.toString());
		   //state:1代表未处理的订单，2代表已处理的订单
		   if(state==1){
			   queryString.append(" and orderState<=2");
		   }else{
			   queryString.append(" and orderState>2");
		   }
		   List<Order> list = find(queryString.toString(), 
					(page-1)*pageSize, pageSize);
		   if(list != null && list.size() != 0){
				return new PageObj<Order>(list, totalCount, pageSize, page);
			}
		}
	   return null;
	}


	@Override
	public PageObj<Order> findOrder(int page) {
		Long totalCount = totalCount();
		if(totalCount == 0){
			return null;
		}
		List<Order> orders = find("from Order", (page-1)*pageSize, pageSize);
		if(orders != null && orders.size() != 0){
			return new PageObj<Order>(orders, totalCount, pageSize, page);
		}
		return null;
	}

	@Override
	public PageObj<Order> findByOrderTime(Long merchantId, String startTime, String endTime, int page) {
		StringBuilder totalQuery = new StringBuilder(64);
		if(startTime == null){
			totalQuery.append("select count(oid) from Order as order where merchant_id=")
					  .append(merchantId.toString())
					  .append(" and orderTime.subString(1,10)<=\'")
			          .append(endTime)
			          .append("\'");
		}else{
			totalQuery.append("select count(oid) from Order where merchant_id=")
					  .append(merchantId.toString())
					  .append(" and orderTime>=\'")
			          .append(startTime)
			          .append("\' and orderTime<=\'")
			          .append(endTime)
			          .append("\'");
		}
		Long totalCount = totalCount(totalQuery.toString());
		if(totalCount != 0){
			StringBuilder queryString = new StringBuilder(64);
			if(startTime == null){
				queryString.append("from Order where merchant_id=")
					  	   .append(merchantId.toString())
					  	   .append(" and orderTime.subString(1,10)<=\'")
					  	   .append(endTime)
					  	   .append("\'");
			}else{
				queryString.append("from Order where merchant_id=")
						   .append(merchantId.toString())
						   .append(" and orderTime>=\'")
				           .append(startTime)
				           .append("\' and orderTime<=\'")
				           .append(endTime)
				           .append("\'");
			}
			List<Order> orders = find(queryString.toString(), 
										(page-1)*pageSize, pageSize);
			if(orders != null && orders.size() != 0){
				return new PageObj<Order>(orders, totalCount, pageSize, page);
			}	
		}
		return null;
	}
	
	@Override
	public PageObj<Order> findByOrderTime(Date startTime, Date endTime, int page) {
		StringBuilder totalQuery = new StringBuilder(64);
		if(startTime == null){
			totalQuery.append("select count(oid) from Order as order where orderTime<=")
			          .append(endTime);
		}else{
			totalQuery.append("select count(oid) from Order where orderTime>=")
			          .append(startTime)
			          .append(" and orderTime<=")
			          .append(endTime);
		}
		Long totalCount = totalCount(totalQuery.toString());
		if(totalCount != 0){
			StringBuilder queryString = new StringBuilder(64);
			if(startTime == null){
				queryString.append("from Order where orderTime<=")
			          .append(endTime);
			}else{
				queryString.append("from Order where orderTime>=")
			          .append(startTime)
			          .append(" and orderTime<=")
			          .append(endTime);
			}
			List<Order> orders = find(queryString.toString(), 
										(page-1)*pageSize, pageSize);
			if(orders != null && orders.size() != 0){
				return new PageObj<Order>(orders, totalCount, pageSize, page);
			}	
		}
		return null;
	}

	@Override
	public PageObj<Order> findByUser(String phone, int page) {
		StringBuilder totalQuery = new StringBuilder(
				"select count(oid) from Order as order where order.user.phone=");
		totalQuery.append(phone);
		Long totalCount = totalCount(totalQuery.toString());
		if(totalCount != 0){
			StringBuilder queryString = new StringBuilder(
					"from Order as order where order.user.phone=");
			queryString.append(phone);
			List<Order> list = find(queryString.toString(),
					(page-1)*pageSize, pageSize);
			if(list != null && list.size() != 0){
				return new PageObj<Order>(list, totalCount, pageSize, page);
			}
		}
		return null;
	}

	@Override
	public PageObj<Order> findByUserAndTime(String phone, Date startTime,
			Date endTime, int page) {
		StringBuilder totalQuery = new StringBuilder(64);
		if(startTime == null){
			totalQuery.append("select count(oid) from Order as order where order.user.phone=")
					   .append(phone)
					   .append(" and orderTime<=")
			           .append(endTime);
		}else{
			totalQuery.append("from Order as order where  order.user.phone=")
			   .append(phone)
			   .append(" and orderTime>=")
	           .append(startTime)
	           .append(" and orderTime<=")
	           .append(endTime);
		}
		//获取查询结果总数量
		Long totalCount = totalCount(totalQuery.toString());
		if(totalCount != 0){
			StringBuilder queryString = new StringBuilder(64);
			if(startTime == null){
				queryString.append("from Order as order where order.user.phone=")
						   .append(phone)
						   .append(" and orderTime<=")
				           .append(endTime);
			}else{
				queryString.append("from Order as order where order.user.phone=")
				   .append(phone)
				   .append(" and orderTime>=")
		           .append(startTime)
		           .append(" and orderTime<=")
		           .append(endTime);
			}
			List<Order> orders = find(queryString.toString(),
										(page-1)*pageSize, pageSize);
			if(orders != null && orders.size() != 0){
				return new PageObj<Order>(orders, totalCount, pageSize, page);
			}
		}
		return null;
	}

	
	
}
