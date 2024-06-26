package jsoft.home.homepage;

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

public class HomepageControl {
	private HomepageModel cm;

	public HomepageControl(ConnectionPool cp) {
		this.cm = new HomepageModel(cp);
	}

	public ConnectionPool getCP() {
		return this.cm.getCP();
	}

	public void releaseConnection() {
		this.cm.releaseConnection();
	}
	public ArrayList<JobObject> getSearchRS(String key ) {
	 return	this.cm.getSearch(key);
	}

//	---------------------------------------------
	public Triplet<CareerObject, HashMap<Integer, String>,ArrayList<FieldObject>> getCareerObject(short id, UserObject userLogin) {
		return this.cm.getCareerObject(id, userLogin);
	}

//	----------------------------------------------
	public ArrayList<String> viewHomePage(Triplet<CareerObject, Integer, Byte> infos,UserObject u) {
		Sextet<ArrayList<CareerObject>, HashMap<Integer, Integer>,ArrayList<CompanyObject>,HashMap<Integer, Integer>,ArrayList<JobObject>,ArrayList<ArticleObject>> data = this.cm.getdataHomePage(infos);
		ArrayList<JobObject> jobSave = null;
		if(u!=null) {
		 jobSave = new ArrayList<JobObject>();
		 jobSave = this.cm.JobSave(u.getUser_id());
		}
		String viewcareer = HomepageLibrary.viewCareer(data.getValue0(), data.getValue1());
		String viewcompanies = HomepageLibrary.viewListCompanies(data.getValue2(), data.getValue3());
		ArrayList<String> rs = new ArrayList<>();
		rs.add(viewcareer);
		rs.add(viewcompanies);
		rs.add(HomepageLibrary.viewListJob(data.getValue4(),u,jobSave));
		rs.add(HomepageLibrary.viewListArticle(data.getValue5()));
		return rs;
	}
	public String getFieldsInFooter() {
		ArrayList<FieldObject> data = this.cm.getDatafooter();
		return HomepageLibrary.viewFieldInFooter(data);
	}
	public static void main(String[] args) {
	
	}
}
