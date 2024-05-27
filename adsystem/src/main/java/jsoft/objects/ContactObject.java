package jsoft.objects;

public class ContactObject {
	private int contact_id;
	private String contact_title;
	private String contact_email; 
	private String contact_fullname; 
	private String contact_content; 
	private boolean contact_enable;
	private String contact_created_date;
	public int getContact_id() {
		return contact_id;
	}
	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}
	public String getContact_title() {
		return contact_title;
	}
	public void setContact_title(String contact_title) {
		this.contact_title = contact_title;
	}
	public String getContact_email() {
		return contact_email;
	}
	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}
	public String getContact_fullname() {
		return contact_fullname;
	}
	public void setContact_fullname(String contact_fullname) {
		this.contact_fullname = contact_fullname;
	}
	public boolean isContact_enable() {
		return contact_enable;
	}
	public void setContact_enable(boolean contact_enable) {
		this.contact_enable = contact_enable;
	}
	public String getContact_created_date() {
		return contact_created_date;
	}
	public void setContact_created_date(String contact_created_date) {
		this.contact_created_date = contact_created_date;
	}
	public String getContact_content() {
		return contact_content;
	}
	public void setContact_content(String contact_content) {
		this.contact_content = contact_content;
	}
	
}
