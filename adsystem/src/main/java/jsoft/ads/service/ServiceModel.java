package jsoft.ads.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.library.ORDER;
import jsoft.objects.CareerObject;
import jsoft.objects.FieldObject;
import jsoft.objects.OrderObject;
import jsoft.objects.ServiceObject;
import jsoft.objects.UserObject;

public class ServiceModel {
	private Service c;
	public ServiceModel(ConnectionPool cp) {
		this.c = new ServiceImpl(cp);
	}
	
	public ConnectionPool getCP() {
		return this.c.getCP();
	}

	public void releaseConnection() {
		this.c.releaseConnection();
	}
	
//	---------------------------------------
	
	public boolean delService(int id) {
		return this.c.delService(id);
	}
	
//	----------------------------------------
	
	public Triplet<CareerObject, HashMap<Integer, String>,ArrayList<FieldObject>> getServiceObject(short id, UserObject userLogined) {
		CareerObject item = null;
		HashMap<Integer, String> author_name = new HashMap<>();
		ArrayList<ResultSet> res= this.c.getService(id, userLogined);
		ResultSet rs = res.get(0);
		if(rs!=null) {
			try {
				if(rs.next()) {
					item = new CareerObject();
					author_name.put(rs.getInt("Career_author_id"), rs.getString("user_fullname")+"("+rs.getString("user_name")+")");
					item.setCareer_id(rs.getShort("Career_id"));
					item.setCareer_name(rs.getString("Career_name"));
					item.setCareer_author_id(rs.getInt("career_author_id"));
					item.setCareer_created_date(rs.getString("Career_created_date"));
					FieldObject f = new FieldObject();
					f.setField_id(rs.getInt("field_id"));
					f.setField_name(rs.getString("field_name"));
					item.setField(f);
					item.setCareer_last_modified(rs.getString("Career_last_modified"));
				
					item.setCareer_notes(rs.getString("Career_notes"));
					item.setCareer_field_id(rs.getInt("career_field_id"));
					
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		rs = res.get(1);
		ArrayList<FieldObject> fields = new ArrayList<>();
		FieldObject field = null;
		if(rs!=null) {
			try {
				while(rs.next()) {
					field =new FieldObject();
					field.setField_id(rs.getInt("field_id"));
					field.setField_name(rs.getString("field_name"));
					fields.add(field);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		return new Triplet<>(item,author_name,fields);
	}
	
	public Triplet<ArrayList<OrderObject>, Short,LinkedHashMap> getServices
	() {
		ArrayList<OrderObject> data = new ArrayList();
		OrderObject order = null;
		ArrayList<ResultSet> res = this.c.getServices();
		ResultSet rs = res.get(0);
		if(rs!=null) {
			try {
				while(rs.next()) {
					ServiceObject service = new ServiceObject();
					service.setService_id(rs.getInt("service_id"));
					service.setService_name(rs.getString("service_name"));
					service.setService_price(rs.getInt("service_price"));
					UserObject user = new UserObject();
					user.setUser_id(rs.getInt("user_id"));
					user.setUser_name(rs.getString("user_name"));
					user.setUser_fullname(rs.getString("user_fullname"));
					order = new OrderObject();
					order.setOrder_id(rs.getInt("order_id"));
					order.setUser(user);
					order.setService(service);
					order.setOrder_created_date(rs.getString("order_created_at"));
					order.setOrder_exporation_date(rs.getString("order_exporation_date"));
					data.add(order);
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		rs = res.get(1);
		short total = 0;
		if(rs!= null) {
			try {
				if(rs.next()) {
					total = rs.getShort("total");
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		 LinkedHashMap<String, Integer> datas = new LinkedHashMap<>();
         rs = res.get(2);
		
		if(rs!=null) {
			try {
				while(rs.next()) {
					int year = rs.getInt("year");
					int month = rs.getInt("month");
					String time = month+"-"+year;
					datas.put(time,rs.getInt("totalPrice"));
					System.out.println("t : "+time);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return new Triplet<>(data,total,datas);
	}
}
