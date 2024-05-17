package jsoft.objects;

public class ServiceObject {
	  private int service_id;
	   private String service_name;
	    private String service_notes;
	    private boolean service_delete;
	    private boolean service_enable;
	    private String service_created_date;
	    private int service_price;
	    private String service_duration;
	    private String service_last_modified;
	    private int service_status;
		public int getService_id() {
			return service_id;
		}
		public void setService_id(int service_id) {
			this.service_id = service_id;
		}
		public String getService_name() {
			return service_name;
		}
		public void setService_name(String service_name) {
			this.service_name = service_name;
		}
		public String getService_notes() {
			return service_notes;
		}
		public void setService_notes(String service_notes) {
			this.service_notes = service_notes;
		}
		public boolean isService_delete() {
			return service_delete;
		}
		public void setService_delete(boolean service_delete) {
			this.service_delete = service_delete;
		}
		public boolean isService_enable() {
			return service_enable;
		}
		public void setService_enable(boolean service_enable) {
			this.service_enable = service_enable;
		}
		public String getService_created_date() {
			return service_created_date;
		}
		public void setService_created_date(String service_created_date) {
			this.service_created_date = service_created_date;
		}
		public int getService_price() {
			return service_price;
		}
		public void setService_price(int service_price) {
			this.service_price = service_price;
		}
		public String getService_duration() {
			return service_duration;
		}
		public void setService_duration(String service_duration) {
			this.service_duration = service_duration;
		}
		public String getService_last_modified() {
			return service_last_modified;
		}
		public void setService_last_modified(String service_last_modified) {
			this.service_last_modified = service_last_modified;
		}
		public int getService_status() {
			return service_status;
		}
		public void setService_status(int service_status) {
			this.service_status = service_status;
		}
}
