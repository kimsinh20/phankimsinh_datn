package jsoft.ads.user;

import java.util.ArrayList;
import java.util.HashMap;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Sextet;
import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.ConnectionPoolImpl;
import jsoft.library.ORDER;
import jsoft.objects.ArticleObject;
import jsoft.objects.CompanyObject;
import jsoft.objects.JobObject;
import jsoft.objects.RecruiterObject;
import jsoft.objects.ServiceObject;
import jsoft.objects.UserObject;

public class UserControl {
	private UserModel um;

	public UserControl(ConnectionPool cp) {
		this.um = new UserModel(cp);
	}

	public ConnectionPool getCP() {
		return this.um.getCP();
	}

	public void releaseConnection() {
		this.um.releaseConnection();
	}
	public Sextet<Integer, Integer, Integer, ArrayList<JobObject>,ArrayList<ArticleObject>,HashMap<Integer,Integer>> getDashboard(){
		return this.um.getDashboard();
	}
	public Quintet<Integer, Integer, Integer, ArrayList<JobObject>,HashMap<Integer,Integer>> getDashboardEmployer(int user_id){
		return this.um.getDashboardEmployer(user_id);
	}
//	------------------------------------------
	public boolean addUser(UserObject item,USER_TYPE ut) {
		return this.um.addUser(item,ut);
	}

	public boolean addOrder(int order_id,ServiceObject sv , UserObject u) {
		return this.um.addOrder(order_id,sv,u);
	}
	
	public boolean editUser(UserObject item,USER_EDIT_TYPE et) {
		return this.um.editUser(item,et);
	}

	public boolean delUser(UserObject item) {
		return this.um.delUser(item);
	}

//	---------------------------------------------
	public UserObject getUserObject(int id) {
		return this.um.getUserObject(id);
	}
	public ServiceObject getServiceObject(int id) {
		return this.um.getServiceObject(id);
	}

	public UserObject getUserObject(String username, String userpass) {
		return this.um.getUserObject(username, userpass);
	}
	public RecruiterObject getEmployerObject(String username, String userpass) {
		return this.um.getEmployerObject(username, userpass);
	}
	public UserObject getCheckPass(int id,String newPass) {
		UserObject eUser = new UserObject();
		eUser.setUser_id(id);
		eUser.setUser_pass(newPass);
		return this.um.getCheckpass(eUser);
	}
   
	public boolean getUpdateLogined(UserObject item) {
		return this.um.getUpdatelogined(item);
	}

//	----------------------------------------------
	public ArrayList<String> viewUser(Quartet<UserObject, Integer, Byte,USER_TYPE> infos, Pair<USER_SOFT, ORDER> so,int page,String saveKey,boolean trash) {
		Triplet<ArrayList<UserObject>, Short,ArrayList<CompanyObject>> datas = this.um.getUserObjects(infos, so);
		ArrayList<String> views = new ArrayList<>();
		String view1 = UserLibrary.viewUser(datas.getValue0(), infos.getValue0(),page).get(0);
		String view3= UserLibrary.pagination(infos.getValue0(), datas.getValue1(), infos.getValue2(),infos.getValue3(),page,saveKey,trash).toString();
		String view2 = UserLibrary.viewUser(datas.getValue0(), infos.getValue0(),page).get(1);
		views.add(view1);
		views.add(view2);
		views.add(view3);
		if(infos.getValue3()==USER_TYPE.RECRUITER) {
		views.add(UserLibrary.viewCompanyOptions(datas.getValue2()));
		}
        
		return views;
	}

	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		UserControl uc = new UserControl(cp);

		Triplet<UserObject, Integer, Byte> infos = new Triplet<>(null, 0, (byte) 15);

//		ArrayList<String> views = uc.viewUser(infos, new Pair<>(USER_SOFT.NAME, ORDER.ASC));

		uc.releaseConnection();
//		System.out.println(views);
	}
}
