package jsoft.objects;

public class OrderObject {
	private int order_id;
	private UserObject user;
	private ServiceObject service;
	private String order_exporation_date;
	private String order_created_date;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public UserObject getUser() {
		return user;
	}
	public void setUser(UserObject user) {
		this.user = user;
	}
	public ServiceObject getService() {
		return service;
	}
	public void setService(ServiceObject service) {
		this.service = service;
	}
	public String getOrder_exporation_date() {
		return order_exporation_date;
	}
	public void setOrder_exporation_date(String order_exporation_date) {
		this.order_exporation_date = order_exporation_date;
	}
	public String getOrder_created_date() {
		return order_created_date;
	}
	public void setOrder_created_date(String order_created_date) {
		this.order_created_date = order_created_date;
	}
	
}
