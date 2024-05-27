package jsoft.ads.contact;

import java.util.ArrayList;
import java.util.HashMap;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.library.ORDER;
import jsoft.objects.ContactObject;
import jsoft.objects.UserObject;

public class ContactControl {
	private ContactModel sm;

	public ContactControl(ConnectionPool cp) {
		this.sm = new ContactModel(cp);
	}

	public ConnectionPool getCP() {
		return this.sm.getCP();
	}

	public void releaseConnection() {
		this.sm.releaseConnection();
	}
	
//	------------------------------------------
	public boolean addContact(ContactObject item) {
		return this.sm.addContact(item);
	}

	public boolean delContact(ContactObject item) {
		return this.sm.delContact(item);
	}
	
	public boolean updateEnable() {
		return this.sm.updateEnable();
	}

//	---------------------------------------------
	public ContactObject getContactObject(short id) {
		return this.sm.getContactObject(id);
	}

//	----------------------------------------------
	public ArrayList<String> viewContact(Triplet<ContactObject, Integer, Byte> infos,int page) {
		Pair<ArrayList<ContactObject>, Short> datas = this.sm.getContactObjects(infos);

		ArrayList<String> views = new ArrayList<>();
		
		views.add(ContactLibrary.viewContact(datas.getValue0(),datas.getValue1(),page));
    	String view2= ContactLibrary.pagination(datas.getValue1(), infos.getValue2(),page).toString();
       views.add(view2);
//        views.add(ContactLibrary.createdChart(datas.getValue4()).toString());
		return views;
	}

	public static void main(String[] args) {
	
	}
}
