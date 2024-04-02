package jsoft.objects;

public class ApplicationsObject {
	    private int applications_id;
	    private String applications_notes;
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
		
		public String getApplications_notes() {
			return applications_notes;
		}
		public void setApplications_notes(String applications_notes) {
			this.applications_notes = applications_notes;
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
