package jsoft.home.job;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.javatuples.Pair;
import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.home.basic.BasicImpl;
import jsoft.library.ORDER;
import jsoft.objects.JobObject;
import jsoft.objects.UserObject;

public class JobImpl extends BasicImpl implements Job {

	public JobImpl(ConnectionPool cp) {
		super(cp, "Job");
		// TODO Auto-generated constructor stub
	}


	@Override
	public ArrayList<ResultSet> getJob(short id) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tblJob j "); // cate la con cua section
		sql.append("LEFT JOIN tblcareer f ON j.job_career_id = f.career_id ");
		sql.append("LEFT JOIN tblcompany p ON p.company_id = j.job_company_id ");
		sql.append("LEFT JOIN tblfield a ON a.field_id = f.career_field_id ");
		sql.append("WHERE (j.job_status>0) AND (j.job_delete=0) AND (j.job_id=" + id + ");");

		sql.append("SELECT * FROM tblskill WHERE skill_delete = 0;");
		
		sql.append("SELECT * FROM tbljob as j ");
		sql.append("LEFT JOIN tblcompany as c ");
		sql.append("ON j.job_company_id=c.company_id ");
		sql.append("WHERE j.job_status>0 AND job_delete=0 AND job_enable=0 ");
		sql.append("ORDER BY job_id DESC ");
		sql.append("LIMIT 2; ");
		
		sql.append("SELECT * FROM tblarticle as a ");
		sql.append("LEFT JOIN tblcategory c ON c.category_id = a.article_category_id ");
		sql.append("LEFT JOIN tblsection s ON c.category_section_id = s.section_id ");
		sql.append("ORDER BY article_visited DESC ");
		sql.append("LIMIT 3; ");
		
		return this.getMR(sql.toString());
	}

	@Override
	public ArrayList<ResultSet> getJobs(Triplet<JobObject, Integer, Byte> infos,Pair<JOB_SOFT, ORDER> so) {
		// TODO Auto-generated method stub
		JobObject similar = infos.getValue0();

		// vị trí bắt đầu lấy bản ghi
		int at = infos.getValue1();

		// Số bản ghi được lấy trong một lần
		byte total = infos.getValue2();

		StringBuffer sql = new StringBuffer();

		
		sql.append("SELECT * FROM tblJob AS j ");
		sql.append("LEFT JOIN tbluser AS u ON u.user_id = j.job_author_id ");
		sql.append("LEFT JOIN tblcompany AS c ON c.company_id = j.job_company_id ");
		sql.append("LEFT JOIN tblcareer AS a ON a.career_id = j.job_career_id ");
		sql.append(this.createConditions(similar));
		switch (so.getValue0()) {
		case GENERAL:
			sql.append("ORDER BY j.job_visited ").append(so.getValue1().name());
			break;
		case DATE:
			sql.append("ORDER BY j.job_id ").append(so.getValue1().name());
			break;
		case TITLE:
			sql.append("ORDER BY j.job_title ").append(so.getValue1().name());
			break;
		default:
			sql.append("ORDER BY j.job_id ").append(so.getValue1().name());

		}
		
		sql.append(" LIMIT ").append(at).append(", ").append(total).append(";");

        sql.append("SELECT * FROM provinces ORDER BY name ASC ;");
		
		sql.append("SELECT COUNT(job_id) AS total FROM tbljob as j ");
		sql.append("LEFT JOIN tblcompany AS c ON c.company_id = j.job_company_id ");
		sql.append("LEFT JOIN tblcareer AS a ON a.career_id = j.job_career_id ");
		sql.append(createConditions(similar));
		sql.append(";");
		
		sql.append(" SELECT * FROM tblskill; ");
		
		sql.append(" SELECT * FROM tblcareer ORDER by career_name ASC ; ");
		
		System.out.println(sql.toString());
		return this.getMR(sql.toString());
	}

	private String createConditions(JobObject similar) {
		StringBuffer conds = new StringBuffer();
		conds.append(" (job_status>0) AND ");
		if (similar != null) {
			if (similar.isJob_delete()) {
				conds.append(" (job_delete=1)");
			} else {
				conds.append(" (job_delete=0) ");
			}
			// tu khoa tim kiem
			String key = similar.getJob_title();
			if (key != null && !key.equalsIgnoreCase("")) {
				conds.append(" AND ((job_title LIKE '%" + key + "%') OR ");
				conds.append("(company_name LIKE '%" + key + "%') ");
				conds.append(") ");
			}
			
			String location = similar.getJob_location();
			if (location != null && !location.equalsIgnoreCase("")) {
				conds.append(" AND (job_location LIKE '%" + location + "%')");
			}
			
			if(similar.getJob_career()!= null) {
				if(similar.getJob_career().getCareer_id()>0) {
					conds.append(" AND (company_field_id = "+similar.getJob_career().getCareer_id()+" )");
				}
			}
			
			if(similar.getJob_career()!= null) {
				if(similar.getJob_career().getCareer_field_id()>0) {
					conds.append(" AND (career_field_id = "+similar.getJob_career().getCareer_field_id()+" )");
				}
			}
			
			// worktime
			if(similar.getJob_purpose()!= null && !similar.getJob_purpose().equalsIgnoreCase("")) {
					conds.append(" AND (job_work_time IN ("+similar.getJob_purpose()+") ) ");
			}
			// salary
			if(similar.getJob_responsibility()!= null && !similar.getJob_responsibility().equalsIgnoreCase("")) {
				conds.append(" AND (job_salary IN ("+similar.getJob_responsibility()+") ) ");
		}
			
		}
		if (!conds.toString().equalsIgnoreCase("")) {
			conds.insert(0, " WHERE ");
		}
		return conds.toString();
	}


	@Override
	public ArrayList<ResultSet> getCareerOfField() {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tblfield AS s  ");
		sql.append("WHERE (field_delete=0);");
		
		sql.append("SELECT c.career_field_id, c.career_id,c.career_name, COUNT(j.job_id) AS job_count\r\n"
				+ "FROM tblfield f\r\n"
				+ "JOIN tblcareer c ON f.field_id = c.career_field_id\r\n"
				+ "JOIN tbljob j ON c.career_id = j.job_career_id\r\n"
				+ "GROUP BY c.career_field_id, f.field_name, c.career_name;");
		
		sql.append("SELECT * FROM tbljob as j ");
		sql.append("LEFT JOIN tblcompany as c ");
		sql.append("ON j.job_company_id=c.company_id ");
		sql.append("WHERE j.job_status>0 AND job_delete=0 AND job_enable=0 ");
		sql.append("ORDER BY job_id DESC ");
		sql.append("LIMIT 3; ");
		
		sql.append("SELECT * FROM tblarticle as a ");
		sql.append("LEFT JOIN tblcategory c ON c.category_id = a.article_category_id ");
		sql.append("LEFT JOIN tblsection s ON c.category_section_id = s.section_id ");
		sql.append("ORDER BY article_visited DESC ");
		sql.append("LIMIT 2; ");
		
		System.out.println(sql);
		
		return this.getMR(sql.toString());
	}


	
	
}
