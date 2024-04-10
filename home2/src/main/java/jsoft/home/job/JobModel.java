package jsoft.home.job;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.javatuples.Pair;
import org.javatuples.Quintet;
import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.library.ORDER;
import jsoft.objects.CareerObject;
import jsoft.objects.CompanyObject;
import jsoft.objects.JobObject;
import jsoft.objects.ProvinceObject;

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

//	---------------------------------------

//	----------------------------------------

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
}
