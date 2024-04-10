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
	public ArrayList<ResultSet> getJob(short id, UserObject userLogined) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM tblCareer c "); // cate la con cua section
		sql.append("LEFT JOIN tblfield AS s ON c.Career_field_id = s.field_id ");
		sql.append("LEFT JOIN tbluser AS u ON c.Career_author_id = u.user_id ");
		sql.append("WHERE (c.Career_id="+id+");"); 
		
		sql.append("SELECT * FROM tblfield AS s  ");
		sql.append("WHERE (field_delete=0);");
		System.out.println(sql);
		
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

        sql.append("SELECT * FROM provinces ;");
		
		sql.append("SELECT COUNT(job_id) AS total FROM tbljob as j ");
		sql.append("LEFT JOIN tblcompany AS c ON c.company_id = j.job_company_id ");
		sql.append("LEFT JOIN tblcareer AS a ON a.career_id = j.job_career_id ");
		sql.append(createConditions(similar));
		sql.append(";");
		
		sql.append(" SELECT * FROM tblskill; ");
		
		sql.append(" SELECT * FROM tblcareer; ");
		
		System.out.println(sql.toString());
		return this.getMR(sql.toString());
	}

	private String createConditions(JobObject similar) {
		StringBuffer conds = new StringBuffer();
		conds.append(" (job_status=1) AND ");
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
					conds.append(" AND (job_career_id = "+similar.getJob_career().getCareer_id()+" )");
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


	
	
}
