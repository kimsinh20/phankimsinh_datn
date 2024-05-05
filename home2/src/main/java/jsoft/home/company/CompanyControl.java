package jsoft.home.company;

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

public class CompanyControl {
	private CompanyModel cm;

	public CompanyControl(ConnectionPool cp) {
		this.cm = new CompanyModel(cp);
	}

	public ConnectionPool getCP() {
		return this.cm.getCP();
	}

	public void releaseConnection() {
		this.cm.releaseConnection();
	}
	public boolean follow(int com_id,int user_id) {
		return this.cm.follow(com_id, user_id);
	}
	public boolean unFollow(int com_id, int user_id) {
		return this.cm.unFollow(com_id, user_id);
	}
	public boolean isExits(int com_id, int user_id) {
		return this.cm.isExits(com_id, user_id);
	}
	public ArrayList<CompanyObject> getCompanyFollow( int user_id) {
		return this.cm.getCompanyFollow(user_id);
	}
//	---------------------------------------------
	public Quintet<ArrayList<FieldObject>, ArrayList<CareerObject>, HashMap<Integer, Integer>,ArrayList<JobObject>,ArrayList<ArticleObject>> getFields(){ 
		return this.cm.getFields();
	}
	public Quartet<CompanyObject,HashMap<Integer, String>,ArrayList<JobObject>,ArrayList<ArticleObject>> getCompanyObject(short id) {
		return this.cm.getCompanybObject(id);
	}
//	----------------------------------------------
	public ArrayList<String> viewCompanyPage(Triplet<CompanyObject, Integer, Byte> infos,Pair<COMPANY_SOFT, ORDER> so,String url,int page,UserObject user) {
		Triplet<ArrayList<CompanyObject>,Integer,ArrayList<FieldObject>> data = this.cm.getCompanies(infos,so );
		ArrayList<String> rs = new ArrayList<>();
		ArrayList<CompanyObject> listFollow = null;
		if(user!=null) {
			listFollow = new ArrayList<CompanyObject>();
			listFollow = this.cm.getCompanyFollow(user.getUser_id());
		}
		if(data.getValue0().size()>0) {
			rs.add(CompanyLibrary.viewListJob(data.getValue0(),page,data.getValue1(),url,infos.getValue2(),user,listFollow));
		} else {
			rs.add(CompanyLibrary.viewListJob(data.getValue0(),page,data.getValue1(),url,infos.getValue2(),user,listFollow));
		}
	
		
		if(infos.getValue0().getCompany_field_id()>0) {
			rs.add(CompanyLibrary.fieldOption(data.getValue2(),infos.getValue0().getCompany_field_id()));
		} else {
			rs.add(CompanyLibrary.fieldOption(data.getValue2(),0));
		}
//		rs.add(CompanyLibrary.countJob(data.getValue2(),infos.getValue0().getJob_title()));
		rs.add(CompanyLibrary.sortView(url));
//		rs.add(CompanyLibrary.SearchInput(infos.getValue0().getJob_title()));
		rs.add(CompanyLibrary.getTotal(data.getValue1()));
		return rs;
	}
	
	public static void main(String[] args) {
	
	}
}
