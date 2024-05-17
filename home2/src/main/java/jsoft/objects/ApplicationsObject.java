package jsoft.objects;

public class ApplicationsObject {
	    private int applications_id;
	    private String applications_letter;
	    private String applications_cv;
	    private boolean applications_delete;
	    private boolean applications_enable;
	    private String applications_created_date;
	    private String applications_last_modified;
	    private int applications_status;
	    private UserObject user;
	    private JobObject job;
	    
	    
		public UserObject getUser() {
			return user;
		}
		public void setUser(UserObject user) {
			this.user = user;
		}
		public JobObject getJob() {
			return job;
		}
		public void setJob(JobObject job) {
			this.job = job;
		}
		public int getApplications_id() {
			return applications_id;
		}
		public void setApplications_id(int applications_id) {
			this.applications_id = applications_id;
		}
		
		public String getApplications_cv() {
			return applications_cv;
		}
		public void setApplications_cv(String applications_cv) {
			this.applications_cv = applications_cv;
		}
	
		public String getApplications_letter() {
			return applications_letter;
		}
		public void setApplications_letter(String applications_letter) {
			this.applications_letter = applications_letter;
		}
		public boolean isApplications_delete() {
			return applications_delete;
		}
		public void setApplications_delete(boolean applications_delete) {
			this.applications_delete = applications_delete;
		}
		public boolean isApplications_enable() {
			return applications_enable;
		}
		public void setApplications_enable(boolean applications_enable) {
			this.applications_enable = applications_enable;
		}
		public String getApplications_created_date() {
			return applications_created_date;
		}
		public void setApplications_created_date(String applications_created_date) {
			this.applications_created_date = applications_created_date;
		}
		public String getApplications_last_modified() {
			return applications_last_modified;
		}
		public void setApplications_last_modified(String applications_last_modified) {
			this.applications_last_modified = applications_last_modified;
		}
		public int getApplications_status() {
			return applications_status;
		}
		public void setApplications_status(int applications_status) {
			this.applications_status = applications_status;
		}
	    
}
