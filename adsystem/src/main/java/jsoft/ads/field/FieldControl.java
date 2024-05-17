package jsoft.ads.field;

import java.util.ArrayList;
import java.util.HashMap;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.library.ORDER;
import jsoft.objects.FieldObject;
import jsoft.objects.UserObject;

public class FieldControl {
	private FieldModel sm;

	public FieldControl(ConnectionPool cp) {
		this.sm = new FieldModel(cp);
	}

	public ConnectionPool getCP() {
		return this.sm.getCP();
	}

	public void releaseConnection() {
		this.sm.releaseConnection();
	}
	
//	------------------------------------------
	public boolean addField(FieldObject item) {
		return this.sm.addField(item);
	}

	public boolean editField(FieldObject item,FIELD_EDIT_TYPE et) {
		return this.sm.editField(item,et);
	}

	public boolean delField(FieldObject item) {
		return this.sm.delField(item);
	}

//	---------------------------------------------
	public Pair<FieldObject, HashMap<Integer, String>> getFieldObject(short id, UserObject userLogin) {
		return this.sm.getFieldObject(id, userLogin);
	}

//	----------------------------------------------
	public ArrayList<String> viewField(Quartet<FieldObject, Integer, Byte,UserObject> infos, Pair<FIELD_SOFT, ORDER> so,int page,String saveKey,boolean trash) {
		Triplet<ArrayList<FieldObject>, Short,HashMap<Integer, String>> datas = this.sm.getFieldObjects(infos, so);

		ArrayList<String> views = new ArrayList<>();
		
		views.add(FieldLibrary.viewField(datas.getValue0(),datas.getValue1(),datas.getValue2(),page,infos.getValue3()));
    	String view2= FieldLibrary.pagination(datas.getValue1(), infos.getValue2(),page,saveKey,trash).toString();
       views.add(view2);
//        views.add(FieldLibrary.createdChart(datas.getValue4()).toString());
		return views;
	}

	public static void main(String[] args) {
	
	}
}
