package jsoft.home.company;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.javatuples.Pair;
import org.javatuples.Triplet;

import jsoft.ShareControl;
import jsoft.library.ORDER;
import jsoft.objects.CompanyObject;
import jsoft.objects.JobObject;
import jsoft.objects.UserObject;

public interface company extends ShareControl {
	
	public boolean follow(int com_id,int user_id);
	public boolean unFollow(int com_id,int user_id);
	public boolean isExisting(int com_id,int user_id);
	public ArrayList<ResultSet> getCompanyFollow(int user_id);
	public ArrayList<ResultSet> totalFollow(int com_id);
	// các chức năng lấy dữ liệu
	public ArrayList<ResultSet> getCompany(short id);
	public ArrayList<ResultSet> getCareerOfField();
	public ArrayList<ResultSet> getCompanies(Triplet<CompanyObject, Integer, Byte> infos,Pair<COMPANY_SOFT, ORDER> so);
	
	
}
