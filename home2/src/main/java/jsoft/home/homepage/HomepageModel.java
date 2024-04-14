package jsoft.home.homepage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Sextet;
import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.library.ORDER;
import jsoft.objects.ArticleObject;
import jsoft.objects.CareerObject;
import jsoft.objects.CompanyObject;
import jsoft.objects.FieldObject;
import jsoft.objects.JobObject;
import jsoft.objects.SectionObject;
import jsoft.objects.UserObject;

public class HomepageModel {
	private Homepage c;
	public HomepageModel(ConnectionPool cp) {
		this.c = new HomepageImpl(cp);
	}
	
	public ConnectionPool getCP() {
		return this.c.getCP();
	}

	public void releaseConnection() {
		this.c.releaseConnection();
	}
	
//	---------------------------------------
	
//	----------------------------------------
	
	public ArrayList<JobObject> getSearch(String key) {
		ArrayList<JobObject> items = new ArrayList<>();
		JobObject item = null;
		
		ArrayList<ResultSet> res = this.c.getCareerSearch(key);
		
		ResultSet rs = res.get(0);
		if(rs!=null) {
			try {
				while(rs.next()) {
					item = new JobObject();
					item.setJob_id(rs.getShort("job_id"));
					 item.setJob_title(jsoft.library.Utilities.decode(rs.getString("job_title")));
					items.add(item);
					
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return items;
	}
	
	public Triplet<CareerObject, HashMap<Integer, String>,ArrayList<FieldObject>> getCareerObject(short id, UserObject userLogined) {
		CareerObject item = null;
		HashMap<Integer, String> author_name = new HashMap<>();
		ArrayList<ResultSet> res= this.c.getCareer(id, userLogined);
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
	
	public Sextet<ArrayList<CareerObject>, HashMap<Integer, Integer>,ArrayList<CompanyObject>,HashMap<Integer, Integer>,ArrayList<JobObject>,ArrayList<ArticleObject>> getdataHomePage
	(Triplet<CareerObject, Integer, Byte> infos) {
		ArrayList<CareerObject> items = new ArrayList<>();
		CareerObject item = null;
		
        HashMap<Integer, Integer> total_field = new HashMap<>();
		
		ArrayList<ResultSet> res = this.c.getCategories(infos);
		
		ResultSet rs = res.get(0);
		if(rs!=null) {
			try {
				while(rs.next()) {
					item = new CareerObject();
					item.setCareer_id(rs.getShort("Career_id"));
					total_field.put(rs.getInt("career_id"), rs.getInt("job_count"));
					item.setCareer_name(rs.getString("Career_name"));
					items.add(item);
					
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ArrayList<CompanyObject> listTopCompanies = new ArrayList<>();
		CompanyObject cm = null;
		HashMap<Integer, Integer> total_job = new HashMap<>();
		rs = res.get(1);
		if(rs!=null) {
			try {
				while(rs.next()) {
					cm = new CompanyObject();
					cm.setCompany_id(rs.getShort("company_id"));
					cm.setCompany_name(rs.getString("company_name"));
					cm.setCompany_logo(rs.getString("company_logo"));
					listTopCompanies.add(cm);
					
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		rs = res.get(2);
		if(rs!=null) {
			try {
				while(rs.next()) {
					total_job.put(rs.getInt("job_company_id"), rs.getInt("total"));	
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ArrayList<JobObject> listJob = new ArrayList<>();
		JobObject job = null;
		rs = res.get(3);
		if(rs!=null) {
			try {
				while(rs.next()) {
					job = new JobObject();
					job.setJob_id(rs.getInt("job_id"));
					job.setJob_title(rs.getString("job_title"));
					CompanyObject com = new CompanyObject();
					com.setCompany_id(rs.getInt("job_company_id"));
					com.setCompany_name(rs.getString("company_name"));
					com.setCompany_logo(rs.getString("company_logo"));
					job.setCompany(com);
					job.setJob_quantity(rs.getInt("job_quantity"));
					job.setJob_work_time(rs.getByte("job_work_time"));
					job.setJob_location(rs.getString("job_location"));
					job.setJob_salary(rs.getByte("job_salary"));
					job.setJob_expiration_date(jsoft.library.Utilities_date.getDateForJs(rs.getString("job_expiration_date")));
					
					listJob.add(job);
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ArrayList<ArticleObject> listArticle = new ArrayList<>();
		ArticleObject article = null;
		rs = res.get(4);
		if(rs!=null) {
			try {
				while(rs.next()) {
					article = new ArticleObject();
					article.setArticle_id(rs.getInt("article_id"));
					article.setArticle_title(rs.getString("article_title"));
					article.setArticle_summary(rs.getString("article_summary"));
					article.setArticle_content(rs.getString("article_content"));
					article.setArticle_created_date(rs.getString("article_created_date"));
					article.setArticle_last_modified(rs.getString("article_last_modified"));
					article.setArticle_image(rs.getString("article_image"));
					article.setArticle_section_id(rs.getShort("article_section_id"));
					article.setArticle_category_id(rs.getShort("article_category_id"));
					article.setArticle_visited(rs.getShort("article_visited"));
					article.setCategory_name(rs.getString("category_name"));
					article.setArticle_author_name(rs.getString("article_author_name"));
					listArticle.add(article);
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return new Sextet<>(items,total_field,listTopCompanies,total_job,listJob,listArticle);
	}
	public ArrayList<FieldObject> getDatafooter() {
		ArrayList<ResultSet> res = this.c.getDataFooter();
		
		ResultSet rs = res.get(0);
		
		ArrayList<FieldObject> list = new ArrayList<>();
		FieldObject item = null;
		if(rs!=null) {
			try {
				while(rs.next()) {
					item = new FieldObject();
					item.setField_id(rs.getInt("field_id"));
					item.setField_name(rs.getString("field_name"));
					list.add(item);
				}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	  } 
		return list;
	}
}
