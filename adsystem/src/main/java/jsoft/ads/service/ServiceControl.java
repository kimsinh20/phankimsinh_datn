package jsoft.ads.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.objects.CareerObject;
import jsoft.objects.FieldObject;
import jsoft.objects.OrderObject;
import jsoft.objects.UserObject;

public class ServiceControl {
	private ServiceModel cm;

	public ServiceControl(ConnectionPool cp) {
		this.cm = new ServiceModel(cp);
	}

	public ConnectionPool getCP() {
		return this.cm.getCP();
	}

	public void releaseConnection() {
		this.cm.releaseConnection();
	}
	
//	------------------------------------------

	public boolean delService(int id) {
		return this.cm.delService(id);
	}

//	---------------------------------------------
	public Triplet<CareerObject, HashMap<Integer, String>,ArrayList<FieldObject>> getServiceObject(short id, UserObject userLogin) {
		return this.cm.getServiceObject(id, userLogin);
	}

//	----------------------------------------------
	public ArrayList<String> viewService(int page) {
		Triplet<ArrayList<OrderObject>, Short,LinkedHashMap> datas = this.cm.getServices();
		ArrayList<String> views = new ArrayList<>();
		views.add(ServiceLibrary.viewService(datas.getValue0(), datas.getValue1(), page));
		Byte totalpage = 10;
		String view2= ServiceLibrary.pagination(datas.getValue1(), totalpage,page).toString();
        views.add(view2);
//      views.add(ServiceLibrary.viewFieldOptions(datas.getValue3(), infos.getValue3().getUser_id()));
        views.add(ServiceLibrary.createdChart(datas.getValue2()).toString());
//		views.add(CareerLibrary.viewSectionOptions(datas.getValue5(), infos.getValue3().getUser_id()));
		return views;
	}

	public static void main(String[] args) {
	
	}
}
