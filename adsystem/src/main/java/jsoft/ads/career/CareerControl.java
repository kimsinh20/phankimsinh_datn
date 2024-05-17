package jsoft.ads.career;

import java.util.ArrayList;
import java.util.HashMap;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Sextet;
import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.ads.section.SectionLibrary;
import jsoft.library.ORDER;
import jsoft.objects.CareerObject;
import jsoft.objects.FieldObject;
import jsoft.objects.SectionObject;
import jsoft.objects.UserObject;

public class CareerControl {
	private CareerModel cm;

	public CareerControl(ConnectionPool cp) {
		this.cm = new CareerModel(cp);
	}

	public ConnectionPool getCP() {
		return this.cm.getCP();
	}

	public void releaseConnection() {
		this.cm.releaseConnection();
	}
	
//	------------------------------------------
	public boolean addCareer(CareerObject item) {
		return this.cm.addCareer(item);
	}

	public boolean editCareer(CareerObject eCate,CAREER_EDIT_TYPE et) {
		return this.cm.editCareer(eCate,et);
	}

	public boolean delCareer(CareerObject item) {
		return this.cm.delCareer(item);
	}

//	---------------------------------------------
	public Triplet<CareerObject, HashMap<Integer, String>,ArrayList<FieldObject>> getCareerObject(short id, UserObject userLogin) {
		return this.cm.getCareerObject(id, userLogin);
	}

//	----------------------------------------------
	public ArrayList<String> viewCareer(Quartet<CareerObject, Integer, Byte,UserObject> infos, Pair<CAREER_SOFT, ORDER> so,int page,String saveKey,boolean trash) {
		Quartet<ArrayList<CareerObject>, Short,HashMap<Integer, String>,ArrayList<FieldObject>> datas = this.cm.getCareerObjects(infos, so);
		ArrayList<String> views = new ArrayList<>();
		views.add(CareerLibrary.viewCareer(datas.getValue0(), datas.getValue1(),datas.getValue2(), page,infos.getValue3() ));
		String view2= CareerLibrary.pagination(datas.getValue1(), infos.getValue2(),page,saveKey,trash).toString();
        views.add(view2);
      views.add(CareerLibrary.viewFieldOptions(datas.getValue3(), infos.getValue3().getUser_id()));
//        views.add(CareerLibrary.createdChart(datas.getValue4()).toString());
//		views.add(CareerLibrary.viewSectionOptions(datas.getValue5(), infos.getValue3().getUser_id()));
		return views;
	}

	public static void main(String[] args) {
	
	}
}
