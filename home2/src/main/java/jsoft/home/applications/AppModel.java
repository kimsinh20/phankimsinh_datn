package jsoft.home.applications;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.library.ORDER;
import jsoft.objects.ApplicationsObject;
import jsoft.objects.CareerObject;
import jsoft.objects.FieldObject;
import jsoft.objects.JobObject;
import jsoft.objects.UserObject;

public class AppModel {
	private Applications c;
	public AppModel(ConnectionPool cp) {
		this.c = new AppImpl(cp);
	}
	
	public ConnectionPool getCP() {
		return this.c.getCP();
	}

	public void releaseConnection() {
		this.c.releaseConnection();
	}
	public boolean isExits(int job_id, int user_id) {
		return this.c.isExisting(job_id, user_id);
	}
//	---------------------------------------
	public boolean addApp(ApplicationsObject item) {
		return this.c.addApp(item);
	}
	
	public boolean editApp(ApplicationsObject item,APP_EDIT_TYPE et) {
		return this.c.editApp(item,et);
	}
	
	public boolean delApp(ApplicationsObject item) {
		return this.c.delApp(item);
	}
	
//	----------------------------------------
	
	public Triplet<ApplicationsObject, HashMap<Integer, String>,ArrayList<FieldObject>> getAppObject(short id, UserObject userLogined) {
		
		return null;
	}
	
	public Pair<ArrayList<ApplicationsObject>, Short> getAppObjects
	(Quartet<ApplicationsObject, Integer, Byte,UserObject> infos, Pair<APP_SOFT, ORDER> so) {
		ArrayList<ApplicationsObject> items = new ArrayList<>();
		ApplicationsObject item = null;
		
		ArrayList<ResultSet> res = this.c.getApps(infos, so);
		
		ResultSet rs = res.get(0);
		if(rs!=null) {
			try {
				while(rs.next()) {
					item = new ApplicationsObject();
					item.setApplications_id(rs.getInt("applications_id"));
					item.setApplications_letter(rs.getString("applications_letter"));
					UserObject client = new UserObject();
					client.setUser_id(rs.getInt("applications_job_id"));
					client.setUser_id(rs.getInt("user_id"));
					client.setUser_name(rs.getString("user_name"));
					client.setUser_fullname(rs.getString("user_fullname"));
					client.setUser_email(rs.getString("user_email"));
					client.setUser_address(rs.getString("user_address"));
					client.setUser_permission(rs.getByte("user_permission"));
				    item.setUser(client);
				    JobObject job = new JobObject();
				    job.setJob_id(rs.getInt("applications_job_id"));
				    job.setJob_title(rs.getString("job_title"));
				    item.setJob(job);
					item.setApplications_delete(rs.getBoolean("applications_delete"));
					item.setApplications_last_modified(rs.getString("applications_last_modified"));
					item.setApplications_created_date(rs.getString("applications_created_date"));
					item.setApplications_status(rs.getInt("applications_status"));
					items.add(item);
					
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
		return new Pair<ArrayList<ApplicationsObject>, Short>(items, total);
	}
}
