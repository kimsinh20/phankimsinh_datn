package jsoft.objects;

public class CareerObject {
    private int career_id;
    private String career_name;
    private String career_notes;
    private String career_logo;
    private String career_created_date;
    private boolean career_delete;
    private boolean career_enable;
    private String career_last_modified;
    private int career_author_id;
    private int career_actions;
    private int career_field_id;
    private FieldObject field;
    
    
    
	public FieldObject getField() {
		return field;
	}
	public void setField(FieldObject field) {
		this.field = field;
	}
	public int getCareer_field_id() {
		return career_field_id;
	}
	public void setCareer_field_id(int career_field_id) {
		this.career_field_id = career_field_id;
	}
	public int getCareer_id() {
		return career_id;
	}
	public void setCareer_id(int career_id) {
		this.career_id = career_id;
	}
	public String getCareer_name() {
		return career_name;
	}
	public void setCareer_name(String career_name) {
		this.career_name = career_name;
	}
	public String getCareer_notes() {
		return career_notes;
	}
	public void setCareer_notes(String career_notes) {
		this.career_notes = career_notes;
	}
	public String getCareer_logo() {
		return career_logo;
	}
	public void setCareer_logo(String career_logo) {
		this.career_logo = career_logo;
	}
	public String getCareer_created_date() {
		return career_created_date;
	}
	public void setCareer_created_date(String career_created_date) {
		this.career_created_date = career_created_date;
	}
	
	public boolean isCareer_delete() {
		return career_delete;
	}
	public void setCareer_delete(boolean career_delete) {
		this.career_delete = career_delete;
	}
	public boolean isCareer_enable() {
		return career_enable;
	}
	public void setCareer_enable(boolean career_enable) {
		this.career_enable = career_enable;
	}
	public String getCareer_last_modified() {
		return career_last_modified;
	}
	public void setCareer_last_modified(String career_last_modified) {
		this.career_last_modified = career_last_modified;
	}
	public int getCareer_author_id() {
		return career_author_id;
	}
	public void setCareer_author_id(int career_author_id) {
		this.career_author_id = career_author_id;
	}
	public int getCareer_actions() {
		return career_actions;
	}
	public void setCareer_actions(int career_actions) {
		this.career_actions = career_actions;
	}


    // Các phương thức getter và setter cho các thuộc tính
   
}
