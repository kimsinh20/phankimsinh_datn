package jsoft.home.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.library.ORDER;
import jsoft.objects.ArticleObject;
import jsoft.objects.CareerObject;
import jsoft.objects.CompanyObject;
import jsoft.objects.FieldObject;
import jsoft.objects.JobObject;
import jsoft.objects.ProvinceObject;
import jsoft.objects.SkillObject;
import jsoft.objects.UserObject;

public class CompanyModel {
	private company c;

	public CompanyModel(ConnectionPool cp) {
		this.c = new CompanyImpl(cp);
	}

	public ConnectionPool getCP() {
		return this.c.getCP();
	}

	public void releaseConnection() {
		this.c.releaseConnection();
	}

//	---------------------------------------

//	----------------------------------------

	public Triplet<ArrayList<CompanyObject>,  Integer, ArrayList<FieldObject>> getCompanies(
			Triplet<CompanyObject, Integer, Byte> infos, Pair<COMPANY_SOFT, ORDER> so) {
		ArrayList<ResultSet> res = this.c.getCompanies(infos, so);
		ArrayList<CompanyObject> companies = new ArrayList<>();
		CompanyObject company = null;
		
		ResultSet rs = res.get(0);
		if(rs!=null) {
			try {
				while(rs.next()) {
					company = new CompanyObject();
					company.setCompany_id(rs.getShort("company_id"));
					company.setCompany_name(rs.getString("company_name"));
					company.setCompany_about(rs.getString("company_about"));
					company.setCompany_author_id(rs.getInt("company_author_id"));
					company.setCompany_created_date(rs.getString("company_created_date"));
					company.setCompany_delete(rs.getBoolean("company_delete"));
					FieldObject f = new FieldObject();
					f.setField_id(rs.getInt("field_id"));
					f.setField_name(rs.getString("field_name"));
					company.setField(f);
					company.setCompany_email(rs.getString("company_email"));
					company.setCompany_location(rs.getString("company_location"));
					company.setCompany_nationality(rs.getInt("company_nationality"));
					company.setCompany_officephone(rs.getString("company_officephone"));
					company.setCompany_homephone(rs.getString("company_homephone"));
					company.setCompany_mobilephone(rs.getString("company_mobilephone"));
					company.setCompany_establish_date(rs.getString("company_establish_date"));
					company.setCompany_logo(rs.getString("company_logo"));
					company.setCompany_banner(rs.getString("company_banner"));
					companies.add(company);
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		rs = res.get(1);
		Integer total = 0;
		if (rs != null) {
			try {
				if (rs.next()) {
					total = rs.getInt("total");
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	

		ArrayList<FieldObject> listField = new ArrayList<>();
		FieldObject f = null;
		rs = res.get(2);
		if (rs != null) {
			try {
				while (rs.next()) {
					f = new FieldObject();
					f.setField_id(rs.getInt("field_id"));
					f.setField_name(rs.getString("field_name"));
					listField.add(f);
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return new Triplet<>(companies, total, listField);
	}
	
	public Quintet<ArrayList<FieldObject>, ArrayList<CareerObject>, HashMap<Integer, Integer>,ArrayList<JobObject>,ArrayList<ArticleObject>> getFields(){
		ArrayList<ResultSet> res = this.c.getCareerOfField();
		ArrayList<FieldObject> listFields = new ArrayList<>();
		FieldObject field = null;
		ResultSet rs = res.get(0);
		if (rs != null) {
			try {
				while (rs.next()) {
					field = new FieldObject();
					field.setField_id(rs.getInt("field_id"));
					field.setField_name(rs.getString("field_name"));
					
					listFields.add(field);
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		HashMap<Integer, Integer> totalJob = new HashMap<>();
		ArrayList<CareerObject> listCareer = new ArrayList<>();
		CareerObject career = null;
		rs = res.get(1);
		if (rs != null) {
			try {
				while (rs.next()) {
					career = new CareerObject();
					career.setCareer_id(rs.getInt("career_id"));
					career.setCareer_name(rs.getString("career_name"));
					career.setCareer_field_id(rs.getInt("career_field_id"));
					totalJob.put(rs.getInt("career_id"), rs.getInt("job_count"));
					listCareer.add(career);
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ArrayList<JobObject> listJob = new ArrayList<>();
		JobObject job = null;
		rs = res.get(2);
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
		rs = res.get(3);
		if(rs!=null) {
			try {
				while(rs.next()) {
					article = new ArticleObject();
					article.setArticle_id(rs.getInt("article_id"));
					article.setArticle_title(rs.getString("article_title"));
					article.setArticle_summary(jsoft.library.Utilities_text.shortenText(rs.getString("article_summary"),12));
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
		return new Quintet<>(listFields, listCareer, totalJob,listJob,listArticle);
	}	
	
public Quartet<CompanyObject,HashMap<Integer, String>,ArrayList<JobObject>,ArrayList<ArticleObject>> getCompanybObject(short id) {
		
		ArrayList<ResultSet> res = this.c.getCompany(id);
		//  Job
		CompanyObject company = null;
		ResultSet rs = res.get(0);
		if(rs!=null) {
			try {
				if(rs.next()) {
					company = new CompanyObject();
					company.setCompany_id(rs.getShort("company_id"));
					company.setCompany_name(rs.getString("company_name"));
					company.setCompany_about(jsoft.library.Utilities.decode(rs.getString("company_about")));
					company.setCompany_summary(rs.getString("company_summary"));
					company.setCompany_remuneration(jsoft.library.Utilities.decode(rs.getString("company_remuneration")));
					company.setCompany_author_id(rs.getInt("company_author_id"));
					company.setCompany_created_date(rs.getString("company_created_date"));
					company.setCompany_last_modified(rs.getString("company_last_modified"));
					company.setCompany_delete(rs.getBoolean("company_delete"));
					company.setCompany_size(rs.getInt("company_size"));
					company.setCompany_email(rs.getString("company_email"));
					company.setCompany_nationality(rs.getInt("company_nationality"));
					company.setCompany_website(rs.getString("company_website"));
					// get field
					FieldObject field = new FieldObject();
					field.setField_id(rs.getInt("company_field_id"));
					field.setField_name(rs.getString("field_name"));
					company.setField(field);
					company.setCompany_location(rs.getString("company_location"));
					company.setCompany_officephone(rs.getString("company_officephone"));
					company.setCompany_homephone(rs.getString("company_homephone"));
					company.setCompany_mobilephone(rs.getString("company_mobilephone"));
					company.setCompany_establish_date(rs.getString("company_establish_date"));
					company.setCompany_logo(rs.getString("company_logo"));
					company.setCompany_banner(rs.getString("company_banner"));
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		HashMap<Integer, String> skills = new HashMap<>();
		 rs = res.get(1);
		if(rs!=null) {
			try {
				while(rs.next()) {
					skills.put(rs.getInt("skill_id"), rs.getString("skill_name"));
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ArrayList<JobObject> listJob = new ArrayList<>();
		JobObject job = null;
		rs = res.get(2);
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
		rs = res.get(3);
		if(rs!=null) {
			try {
				while(rs.next()) {
					article = new ArticleObject();
					article.setArticle_id(rs.getInt("article_id"));
					article.setArticle_title(rs.getString("article_title"));
					article.setArticle_summary(jsoft.library.Utilities_text.shortenText(rs.getString("article_summary"),12));
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
		return new Quartet<>(company,skills,listJob,listArticle);
	}
	
}
