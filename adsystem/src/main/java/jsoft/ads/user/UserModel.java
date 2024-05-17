package jsoft.ads.user;

import jsoft.*;
import jsoft.library.ORDER;
import jsoft.objects.*;

import java.sql.*;
import java.util.*;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Sextet;
import org.javatuples.Triplet;

public class UserModel {
	private User u;
	public UserModel(ConnectionPool cp) {
		this.u = new UserImpl(cp);
	}
	
	public ConnectionPool getCP() {
		return this.u.getCP();
	}
	
	public void releaseConnection() {
		this.u.releaseConnection();
	}
	
//	---------------------------------------
	public boolean addUser(UserObject item,USER_TYPE ut) {
		return this.u.addUser(item,ut);
	}
	
	public boolean addOrder(int order_id,ServiceObject sv , UserObject u) {
		return this.u.addOrder(order_id,sv,u);
	}
	
	public boolean editUser(UserObject item,USER_EDIT_TYPE et) {
		return this.u.editUser(item,et);
	}
	
	public boolean delUser(UserObject item) {
		return this.u.delUser(item);
	}
	
//	-------------------------------------------
	public UserObject getUserObject(int id) {
		UserObject item = null;
		ResultSet rs = this.u.getUser(id);
		if(rs!=null) {
			try {
				if(rs.next()) {
					item = new UserObject();
					item.setUser_id(rs.getInt("user_id"));
					item.setUser_pass(rs.getString("user_pass"));
					item.setUser_name(rs.getString("user_name"));
					item.setUser_fullname(rs.getString("user_fullname"));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_address(rs.getString("user_address"));
					item.setUser_notes(rs.getString("user_notes"));
					item.setUser_birthday(rs.getString("user_birthday"));
					item.setUser_job(rs.getString("user_job"));
					item.setUser_jobarea(rs.getString("user_jobarea"));
					item.setUser_actions(rs.getByte("user_actions"));
					item.setUser_logined(rs.getShort("user_logined"));
					item.setUser_created_date(rs.getString("user_created_date"));
					item.setUser_last_logined(rs.getString("user_last_logined"));
					item.setUser_homephone(rs.getString("user_homephone"));
					item.setUser_parent_id(rs.getInt("user_parent_id"));
					item.setUser_avatar(rs.getString("user_avatar"));
					item.setUser_gender(rs.getInt("user_gender"));
					item.setUser_officephone(rs.getString("user_officephone"));
					item.setUser_mobilephone(rs.getString("user_mobilephone"));
					item.setUser_permission(rs.getByte("user_permission"));
					item.setUser_alias(rs.getString("user_alias"));
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item;
	}
	
	public ServiceObject getServiceObject(int id) {
		ServiceObject item = null;
		ResultSet rs = this.u.getService(id);
		if(rs!=null) {
			try {
				if(rs.next()) {
					item = new ServiceObject();
					item.setService_id(rs.getInt("service_id"));
					item.setService_price(rs.getInt("service_price"));
					item.setService_name(rs.getString("service_name"));
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item;
	}
	
	public UserObject getUserObject(String username, String userpass) {
		UserObject item = null;
		ResultSet rs = this.u.getUser(username, userpass);
		if(rs!=null) {
			try {
				if(rs.next()) {
					item = new UserObject();
					
					item.setUser_id(rs.getInt("user_id"));
					item.setUser_name(rs.getString("user_name"));
					item.setUser_fullname(rs.getString("user_fullname"));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_address(rs.getString("user_address"));
					item.setUser_created_date(rs.getString("user_created_date"));
					item.setUser_last_logined(rs.getString("user_last_logined"));
					item.setUser_homephone(rs.getString("user_homephone"));
					item.setUser_mobilephone(rs.getString("user_mobilephone"));
					item.setUser_avatar(rs.getString("user_avatar"));
					
					item.setUser_permission(rs.getByte("user_permission"));
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item;
	}
	
	public RecruiterObject getEmployerObject(String username, String userpass) {
		RecruiterObject item = null;
		ResultSet rs = this.u.getEmployer(username, userpass);
		if(rs!=null) {
			try {
				if(rs.next()) {
					item = new RecruiterObject();
					
					item.setUser_id(rs.getInt("user_id"));
					item.setUser_name(rs.getString("user_name"));
					item.setUser_fullname(rs.getString("user_fullname"));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_address(rs.getString("user_address"));
					item.setUser_created_date(rs.getString("user_created_date"));
					item.setUser_last_logined(rs.getString("user_last_logined"));
					item.setUser_homephone(rs.getString("user_homephone"));
					item.setUser_mobilephone(rs.getString("user_mobilephone"));
					item.setUser_avatar(rs.getString("user_avatar"));
					item.setCompany_id(rs.getInt("company_id"));
					
					item.setUser_permission(rs.getByte("user_permission"));
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item;
	}
	
	public UserObject getCheckpass(UserObject i) {
		UserObject item = null;
		ResultSet rs = this.u.getCheckPass(i);
		if(rs!=null) {
			try {
				if(rs.next()) {
					item = new UserObject();
					
					item.setUser_id(rs.getInt("user_id"));
					item.setUser_name(rs.getString("user_name"));
					item.setUser_fullname(rs.getString("user_fullname"));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_address(rs.getString("user_address"));
					item.setUser_created_date(rs.getString("user_created_date"));
					item.setUser_last_logined(rs.getString("user_last_logined"));
					item.setUser_homephone(rs.getString("user_homephone"));
					item.setUser_mobilephone(rs.getString("user_mobilephone"));
					item.setUser_avatar(rs.getString("user_avatar"));
					item.setUser_last_modified(rs.getString("user_last_modified"));
					item.setUser_deleted(rs.getBoolean("user_deleted"));
					
					item.setUser_permission(rs.getByte("user_permission"));
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item;
	}
	
	public boolean getUpdatelogined(UserObject item) {
		return this.u.updateLogined(item);
	}
	
	public Sextet<Integer, Integer, Integer, ArrayList<JobObject>,ArrayList<ArticleObject>,HashMap<Integer, Integer>> getDashboard() {
		ArrayList<ResultSet> res = this.u.getDashboard();
	   ResultSet rs = res.get(0);
		int total_employer = 0;
		if(rs!= null) {
			try {
				if(rs.next()) {
					total_employer = rs.getShort("total");
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		rs = res.get(1);
		int total_job = 0;
		if(rs!= null) {
			try {
				if(rs.next()) {
					total_job = rs.getShort("total");
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		rs = res.get(2);
		int total_apply = 0;
		if(rs!= null) {
			try {
				if(rs.next()) {
					total_apply = rs.getShort("total");
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ArrayList<JobObject> jobs = new ArrayList<>();
		JobObject Job = null;
		
	     rs = res.get(3);
		if(rs!=null) {
			try {
				while(rs.next()) {
					Job = new JobObject();
					Job.setJob_id(rs.getShort("job_id"));
				    Job.setJob_title(rs.getString("job_title"));
				    
				    CompanyObject company = new CompanyObject();
				    company.setCompany_id(rs.getInt("job_company_id"));
					company.setCompany_name(rs.getString("company_name"));
					company.setCompany_logo(rs.getString("company_logo"));
				    Job.setCompany(company);
				    
				    CareerObject career =  new CareerObject();
				    career.setCareer_id(rs.getInt("job_career_id"));
				    career.setCareer_name(rs.getString("career_name"));
				    Job.setJob_career(career);
				    
				    Job.setJob_expiration_date(rs.getString("job_expiration_date"));
				    Job.setJob_created_date(jsoft.library.Utilities_date.getDateForJs(rs.getString("job_created_date")));
				    Job.setJob_status(rs.getInt("job_status"));
				    Job.setJob_quantity(rs.getInt("job_quantity"));
				    Job.setJob_delete(rs.getBoolean("job_delete"));
					jobs.add(Job);
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ArrayList<ArticleObject> items = new ArrayList<>();
		ArticleObject item = null;
     
	    rs = res.get(4);
		if(rs!=null) {
			try {
				while(rs.next()) {
					item = new ArticleObject();
					item.setArticle_id(rs.getInt("article_id"));
					item.setArticle_visited(rs.getShort("article_visited"));
					item.setArticle_title(rs.getString("article_title"));
//					manager_name.put(rs.getInt("category_manager_id"), rs.getString("user_fullname")+"("+rs.getString("user_name")+")");
					item.setArticle_summary(rs.getString("article_summary"));
					item.setArticle_created_date(rs.getString("article_created_date"));
					item.setArticle_author_name(rs.getString("article_author_name"));
					item.setArticle_delete(rs.getBoolean("article_delete"));
					item.setArticle_enable(rs.getBoolean("article_enable"));
					item.setArticle_image(rs.getString("article_image"));
					
					item.setArticle_last_modified(rs.getString("article_last_modified"));
					item.setArticle_source(rs.getString("article_source"));
					item.setArticle_category_id(rs.getShort("article_category_id"));
					item.setArticle_section_id(rs.getShort("article_section_id"));
					items.add(item);
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		HashMap<Integer, Integer> chart_data = new HashMap<>();
		rs = res.get(5);
		
		if(rs!=null) {
			try {
				while(rs.next()) {
					chart_data.put(rs.getInt("job_status"), rs.getInt("total"));
					if(!chart_data.containsKey(0)) {
						chart_data.put(0, 0);
					}
					if(!chart_data.containsKey(1)) {
						chart_data.put(1, 0);
					}
					if(!chart_data.containsKey(2)) {
						chart_data.put(2, 0);
					}
					if(!chart_data.containsKey(3)) {
						chart_data.put(3, 0);
					}
					if(!chart_data.containsKey(4)) {
						chart_data.put(4, 0);
					}
					if(!chart_data.containsKey(5)) {
						chart_data.put(5, 0);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return new Sextet<>(total_employer, total_job,total_apply,jobs,items,chart_data);
	}
	
	public Quintet<Integer, Integer, Integer, ArrayList<JobObject>,HashMap<Integer, Integer>> getDashboardEmployer(int user_id) {
		ArrayList<ResultSet> res = this.u.getDashboardEmployer(user_id);
	   ResultSet rs = res.get(0);
		int total_employer = 0;
		if(rs!= null) {
			try {
				if(rs.next()) {
					total_employer = rs.getShort("total");
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		rs = res.get(1);
		int total_job = 0;
		if(rs!= null) {
			try {
				if(rs.next()) {
					total_job = rs.getShort("total");
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		rs = res.get(2);
		int total_apply = 0;
		if(rs!= null) {
			try {
				if(rs.next()) {
					total_apply = rs.getShort("total");
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ArrayList<JobObject> jobs = new ArrayList<>();
		JobObject Job = null;
		
	     rs = res.get(3);
		if(rs!=null) {
			try {
				while(rs.next()) {
					Job = new JobObject();
					Job.setJob_id(rs.getShort("job_id"));
				    Job.setJob_title(rs.getString("job_title"));
				    
				    CompanyObject company = new CompanyObject();
				    company.setCompany_id(rs.getInt("job_company_id"));
					company.setCompany_name(rs.getString("company_name"));
					company.setCompany_logo(rs.getString("company_logo"));
				    Job.setCompany(company);
				    
				    CareerObject career =  new CareerObject();
				    career.setCareer_id(rs.getInt("job_career_id"));
				    career.setCareer_name(rs.getString("career_name"));
				    Job.setJob_career(career);
				    
				    Job.setJob_expiration_date(rs.getString("job_expiration_date"));
				    Job.setJob_created_date(jsoft.library.Utilities_date.getDateForJs(rs.getString("job_created_date")));
				    Job.setJob_status(rs.getInt("job_status"));
				    Job.setJob_quantity(rs.getInt("job_quantity"));
				    Job.setJob_delete(rs.getBoolean("job_delete"));
					jobs.add(Job);
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
     
		HashMap<Integer, Integer> chart_data = new HashMap<>();
		rs = res.get(4);
		
		if(rs!=null) {
			try {
				while(rs.next()) {
					chart_data.put(rs.getInt("job_status"), rs.getInt("total"));
					if(!chart_data.containsKey(0)) {
						chart_data.put(0, 0);
					}
					if(!chart_data.containsKey(1)) {
						chart_data.put(1, 0);
					}
					if(!chart_data.containsKey(2)) {
						chart_data.put(2, 0);
					}
					if(!chart_data.containsKey(3)) {
						chart_data.put(3, 0);
					}
					if(!chart_data.containsKey(4)) {
						chart_data.put(4, 0);
					}
					if(!chart_data.containsKey(5)) {
						chart_data.put(5, 0);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return new Quintet<>(total_employer, total_job,total_apply,jobs,chart_data);
	}
	public Triplet<ArrayList<UserObject>, Short,ArrayList<CompanyObject>> getUserObjects(Quartet<UserObject, Integer, Byte,USER_TYPE> infos, Pair<USER_SOFT, ORDER> so) {
		ArrayList<UserObject> items = new ArrayList<>();
		
		UserObject item = null;
		
		ArrayList<ResultSet> res = this.u.getUsers(infos, so);
		
		ResultSet rs = res.get(0);
		
		if(rs!=null) {
			try {
				while(rs.next()) {
					item = new UserObject();
					item.setUser_id(rs.getInt("user_id"));
					item.setUser_name(rs.getString("user_name"));
					item.setUser_fullname(rs.getString("user_fullname"));
					item.setUser_email(rs.getString("user_email"));
					item.setUser_address(rs.getString("user_address"));
					item.setUser_created_date(rs.getString("user_created_date"));
					item.setUser_last_logined(rs.getString("user_last_logined"));
					item.setUser_homephone(rs.getString("user_homephone"));
					item.setUser_mobilephone(rs.getString("user_mobilephone"));
					item.setUser_logined(rs.getShort("user_logined"));
					item.setUser_permission(rs.getByte("user_permission"));
					item.setUser_last_modified(rs.getString("user_last_modified"));
					item.setUser_deleted(rs.getBoolean("user_deleted"));
					
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
		if(rs!=null) {
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
		ArrayList<CompanyObject> companys = new ArrayList<>();
		if(infos.getValue3()==USER_TYPE.RECRUITER) {
			CompanyObject company = null;
			 rs = res.get(2);
			if(rs!=null) {
				try {
					while(rs.next()) {
						company = new CompanyObject();
						company.setCompany_id(rs.getInt("company_id"));
						company.setCompany_name(rs.getString("company_name"));
						companys.add(company);
					}
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return new Triplet<>(items ,total,companys);
	}
}
