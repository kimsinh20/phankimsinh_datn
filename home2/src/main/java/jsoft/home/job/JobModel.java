package jsoft.home.job;

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

public class JobModel {
	private Job c;

	public JobModel(ConnectionPool cp) {
		this.c = new JobImpl(cp);
	}

	public ConnectionPool getCP() {
		return this.c.getCP();
	}

	public void releaseConnection() {
		this.c.releaseConnection();
	}
	
	public boolean saveJob(int job_id,int user_id) {
		return this.c.saveJob(job_id, user_id);
	}
	public boolean delJob(int job_id, int user_id) {
		return this.c.delJob(job_id, user_id);
	}
	public boolean isExits(int job_id, int user_id) {
		return this.c.isExisting(job_id, user_id);
	}
//	---------------------------------------

//	----------------------------------------
	public ArrayList<JobObject> JobSave( int user_id) {
		ArrayList<ResultSet> res = this.c.getJobSave( user_id);
		ArrayList<JobObject> listJob = new ArrayList<>();
		JobObject job = null;
		ResultSet rs = res.get(0);
		if (rs != null) {
			try {
				while (rs.next()) {
					job = new JobObject();
					job.setJob_id(rs.getInt("job_id"));
					job.setJob_title(rs.getString("job_title"));
					CompanyObject com = new CompanyObject();
					com.setCompany_id(rs.getInt("job_company_id"));
					com.setCompany_name(rs.getString("company_name"));
					com.setCompany_logo(rs.getString("company_logo"));
					job.setCompany(com);
					job.setJob_quantity(rs.getInt("job_quantity"));
					job.setJob_status(rs.getInt("job_status"));
					job.setJob_skills(rs.getString("job_skills"));
					job.setJob_degree(rs.getInt("job_degree"));
					job.setJob_work_time(rs.getByte("job_work_time"));
					job.setJob_location(rs.getString("job_location"));
					job.setJob_salary(rs.getByte("job_salary"));
					String date = "";
					long date_count = jsoft.library.Utilities_date.getminusDay(jsoft.library.Utilities_date.getDateForJs(rs.getString("job_expiration_date")));
					 if(date_count<0) {
			    		 date = "<span class=\"inline-block text-md text-false\">Hết hạn "+Math.abs(date_count)+" ngày</span>";
			    	 } else if(date_count==0) {
			    		 date = "<span class=\"inline-block text-md text-true\">Hôm nay</span>";
			    	 }else {
			    		 date = "<span class=\"inline-block text-md text-true\">Còn "+Math.abs(date_count)+" ngày</span>";
			    	 }
					job.setJob_expiration_date(date);
					listJob.add(job);
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listJob;
	}
	
	public Quintet<ArrayList<JobObject>, ArrayList<ProvinceObject>, Integer, HashMap<Integer, String>, ArrayList<CareerObject>> getdataJob(
			Triplet<JobObject, Integer, Byte> infos, Pair<JOB_SOFT, ORDER> so) {
		ArrayList<ResultSet> res = this.c.getJobs(infos, so);
		ArrayList<JobObject> listJob = new ArrayList<>();
		JobObject job = null;
		ResultSet rs = res.get(0);
		if (rs != null) {
			try {
				while (rs.next()) {
					job = new JobObject();
					job.setJob_id(rs.getInt("job_id"));
					job.setJob_title(rs.getString("job_title"));
					CompanyObject com = new CompanyObject();
					com.setCompany_id(rs.getInt("job_company_id"));
					com.setCompany_name(rs.getString("company_name"));
					com.setCompany_logo(rs.getString("company_logo"));
					job.setCompany(com);
					CareerObject career = new CareerObject();
					career.setCareer_id(rs.getInt("job_career_id"));
					career.setCareer_name(rs.getString("career_name"));
					job.setJob_career(career);
					job.setJob_quantity(rs.getInt("job_quantity"));
					job.setJob_status(rs.getInt("job_status"));
					job.setJob_skills(rs.getString("job_skills"));
					job.setJob_degree(rs.getInt("job_degree"));
					job.setJob_work_time(rs.getByte("job_work_time"));
					job.setJob_location(rs.getString("job_location"));
					job.setJob_salary(rs.getByte("job_salary"));

					job.setJob_expiration_date(
							jsoft.library.Utilities_date.getDateForJs(rs.getString("job_expiration_date")));

					listJob.add(job);
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		ArrayList<ProvinceObject> listProvice = new ArrayList<>();
		ProvinceObject provice = null;
		rs = res.get(1);
		if (rs != null) {
			try {
				while (rs.next()) {
					provice = new ProvinceObject();
					provice.setCode(rs.getString("code"));
					provice.setName(rs.getString("name"));
					listProvice.add(provice);
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		rs = res.get(2);
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

		HashMap<Integer, String> listSkill = new HashMap<>();
		rs = res.get(3);
		if (rs != null) {
			try {
				while (rs.next()) {
					listSkill.put(rs.getInt("skill_id"), rs.getString("skill_name"));
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		ArrayList<CareerObject> listCareer = new ArrayList<>();
		CareerObject career = null;
		rs = res.get(4);
		if (rs != null) {
			try {
				while (rs.next()) {
					career = new CareerObject();
					career.setCareer_id(rs.getInt("career_id"));
					career.setCareer_name(rs.getString("career_name"));
					listCareer.add(career);
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return new Quintet<>(listJob, listProvice, total, listSkill, listCareer);
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
	
public Quartet<JobObject,HashMap<Integer, String>,ArrayList<JobObject>,ArrayList<ArticleObject>> getJobObject(short id) {
		
		ArrayList<ResultSet> res = this.c.getJob(id);
		//  Job
		JobObject Job = null;
		ResultSet rs = res.get(0);
		if(rs!=null) {
			try {
				if(rs.next()) {
					Job = new JobObject();
					Job.setJob_id(rs.getShort("job_id"));
				    Job.setJob_title(jsoft.library.Utilities.decode(rs.getString("job_title")));
				    
				    CompanyObject company = new CompanyObject();
				    company.setCompany_id(rs.getInt("job_company_id"));
					company.setCompany_name(jsoft.library.Utilities.decode(rs.getString("company_name")));
					company.setCompany_field_id(rs.getInt("company_field_id"));
					company.setCompany_logo(rs.getString("company_logo"));
					company.setCompany_banner(rs.getString("company_banner"));
					company.setCompany_size(rs.getInt("company_size"));
					FieldObject f = new FieldObject();
					f.setField_id(rs.getInt("field_id"));
					f.setField_name(rs.getString("field_name"));
					company.setField(f);
				    Job.setCompany(company);
				    
				    CareerObject career =  new CareerObject();
				    career.setCareer_id(rs.getInt("job_career_id"));
				    career.setCareer_name(rs.getString("career_name"));
				    Job.setJob_career(career);
				
				    
				    
				    Job.setJob_skills(rs.getString("job_skills"));
				    Job.setJob_quantity(rs.getInt("job_quantity"));
				    // job_purpose
				    Job.setJob_purpose(jsoft.library.Utilities.decode(rs.getString("job_purpose")));

				    // job_responsibility
				    Job.setJob_responsibility(jsoft.library.Utilities.decode(rs.getString("job_responsibility")));

				    // job_Welfare
				    Job.setJob_Welfare(jsoft.library.Utilities.decode(rs.getString("job_Welfare")));

				    // job_salary
				    Job.setJob_salary(rs.getByte("job_salary"));

				    // job_work_time
				    Job.setJob_work_time(rs.getByte("job_work_time"));

				    // job_gender
				    Job.setJob_gender(rs.getInt("job_gender"));

				    // job_level
				    Job.setJob_level(rs.getInt("job_level"));

				    // job_location
				    Job.setJob_location(rs.getString("job_location"));

				    // job_degree
				    Job.setJob_degree(rs.getInt("job_degree"));

				    // job_experience_id
				    Job.setJob_experience_id(rs.getInt("job_experience_id"));

				    // job_visited
				    Job.setJob_visited(rs.getInt("job_visited"));

				    // job_created_date
				    Job.setJob_created_date(rs.getString("job_created_date"));

				    // job_expiration_date
				    Job.setJob_expiration_date(rs.getString("job_expiration_date"));

				    // job_delete
				    Job.setJob_delete(rs.getBoolean("job_delete"));

				    // job_enable
				    Job.setJob_enable(rs.getBoolean("job_enable"));

				    // job_interview_process_id
				    Job.setJob_interview_process_id(rs.getInt("job_interview_process_id"));

				    // job_company_id
				    Job.setJob_company_id(rs.getInt("job_company_id"));

				    // job_last_modified
				    Job.setJob_last_modified(rs.getString("job_last_modified"));

				    // job_author_id
				    Job.setJob_author_id(rs.getInt("job_author_id"));

				    // job_status
				    Job.setJob_status(rs.getInt("job_status"));
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
		return new Quartet<>(Job,skills,listJob,listArticle);
	}
	
}
