package jsoft.home.job;

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
import jsoft.objects.ProvinceObject;
import jsoft.objects.SectionObject;
import jsoft.objects.SkillObject;
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

//	---------------------------------------------


//	----------------------------------------------
	public ArrayList<String> viewJobPage(Triplet<JobObject, Integer, Byte> infos,Pair<JOB_SOFT, ORDER> so,String url,int page) {
		Quintet<ArrayList<JobObject>, ArrayList<ProvinceObject>,Integer,HashMap<Integer, String>,ArrayList<CareerObject>> data = this.cm.getdataJob(infos,so );
		ArrayList<String> rs = new ArrayList<>();
		rs.add(JobLibrary.viewListJob(data.getValue0(),data.getValue3(),page,data.getValue2(),url));
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
