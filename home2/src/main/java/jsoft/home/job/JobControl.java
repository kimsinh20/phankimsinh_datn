package jsoft.home.job;

import java.util.ArrayList;
import java.util.HashMap;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.library.ORDER;
import jsoft.objects.ApplicationsObject;
import jsoft.objects.ArticleObject;
import jsoft.objects.CareerObject;
import jsoft.objects.FieldObject;
import jsoft.objects.JobObject;
import jsoft.objects.ProvinceObject;
import jsoft.objects.UserObject;

public class JobControl {
	private JobModel cm;

	public JobControl(ConnectionPool cp) {
		this.cm = new JobModel(cp);
	}

	public ConnectionPool getCP() {
		return this.cm.getCP();
	}

	public void releaseConnection() {
		this.cm.releaseConnection();
	}

	public boolean saveJob(int job_id,int user_id) {
		return this.cm.saveJob(job_id, user_id);
	}
	public boolean delJob(int job_id, int user_id) {
		return this.cm.delJob(job_id, user_id);
	}
	public boolean isExits(int job_id, int user_id) {
		return this.cm.isExits(job_id, user_id);
	}
	
	
//	---------------------------------------------
	public Quintet<ArrayList<FieldObject>, ArrayList<CareerObject>, HashMap<Integer, Integer>,ArrayList<JobObject>,ArrayList<ArticleObject>> getFields(){ 
		return this.cm.getFields();
	}
	public Quartet<JobObject,HashMap<Integer, String>,ArrayList<JobObject>,ArrayList<ArticleObject>> getJobObject(short id) {
		return this.cm.getJobObject(id);
	}
	public ArrayList<JobObject> JobSave( int user_id) {
		return this.cm.JobSave(user_id);
	}
	public ArrayList<ApplicationsObject> JobApply( int user_id) {
		return this.cm.JobApply(user_id);
	}
//	----------------------------------------------
	public ArrayList<String> viewJobPage(Triplet<JobObject, Integer, Byte> infos,Pair<JOB_SOFT, ORDER> so,String url,int page,UserObject user) {
		Quintet<ArrayList<JobObject>, ArrayList<ProvinceObject>,Integer,HashMap<Integer, String>,ArrayList<CareerObject>> data = this.cm.getdataJob(infos,so );
		ArrayList<JobObject> jobSave = null;
		if(user!=null) {
		 jobSave = new ArrayList<JobObject>();
		 jobSave = this.cm.JobSave(user.getUser_id());
		}
		
		ArrayList<String> rs = new ArrayList<>();
		rs.add(JobLibrary.viewListJob(data.getValue0(),data.getValue3(),page,data.getValue2(),url,infos.getValue2(),user,jobSave));
		rs.add(JobLibrary.provicesOption(data.getValue1(),infos.getValue0().getJob_location()));
		if(infos.getValue0().getJob_career()!=null) {
			rs.add(JobLibrary.careerOption(data.getValue4(),infos.getValue0().getJob_career().getCareer_id()));
		} else {
			rs.add(JobLibrary.careerOption(data.getValue4(),0));
		}
		rs.add(JobLibrary.countJob(data.getValue2(),infos.getValue0().getJob_title()));
		rs.add(JobLibrary.sortView(url));
	
		rs.add(JobLibrary.SearchInput(infos.getValue0().getJob_title()));
		rs.add(JobLibrary.getTotal(data.getValue2()));
		return rs;
	}
	
	public static void main(String[] args) {
	
	}
}
