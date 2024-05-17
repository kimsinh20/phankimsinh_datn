package jsoft.home.applications;

import java.util.ArrayList;
import java.util.HashMap;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.library.ORDER;
import jsoft.objects.ApplicationsObject;
import jsoft.objects.FieldObject;
import jsoft.objects.UserObject;

public class AppControl {
	private AppModel cm;

	public AppControl(ConnectionPool cp) {
		this.cm = new AppModel(cp);
	}

	public ConnectionPool getCP() {
		return this.cm.getCP();
	}

	public void releaseConnection() {
		this.cm.releaseConnection();
	}
	public boolean isExits(int job_id, int user_id) {
		return this.cm.isExits(job_id, user_id);
	}
//	------------------------------------------
	public boolean addApp(ApplicationsObject item) {
		return this.cm.addApp(item);
	}

	public boolean editApp(ApplicationsObject eCate,APP_EDIT_TYPE et) {
		return this.cm.editApp(eCate,et);
	}

	public boolean delApp(ApplicationsObject item) {
		return this.cm.delApp(item);
	}

//	---------------------------------------------
	public Triplet<ApplicationsObject, HashMap<Integer, String>,ArrayList<FieldObject>> getAppObject(short id, UserObject userLogin) {
		return this.cm.getAppObject(id, userLogin);
	}

//	----------------------------------------------
	public ArrayList<String> viewApp(Quartet<ApplicationsObject, Integer, Byte,UserObject> infos, Pair<APP_SOFT, ORDER> so,int page,String saveKey,boolean trash) {
		Pair<ArrayList<ApplicationsObject>, Short> datas = this.cm.getAppObjects(infos, so);
		ArrayList<String> views = new ArrayList<>();
		views.add(AppLibrary.viewApp(datas.getValue0(), datas.getValue1(), page,infos.getValue3() ));
//		String view2= AppLibrary.pagination(datas.getValue1(), infos.getValue2(),page,saveKey,trash).toString();
//        views.add(view2);
//      views.add(AppLibrary.viewFieldOptions(datas.getValue3(), infos.getValue3().getUser_id()));
//        views.add(AppLibrary.createdChart(datas.getValue4()).toString());
//		views.add(AppLibrary.viewSectionOptions(datas.getValue5(), infos.getValue3().getUser_id()));
		return views;
	}

	public static void main(String[] args) {
	
	}
}
