package jsoft.ads.contact;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.javatuples.Pair;
import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.objects.ContactObject;

public class ContactModel {
	private Contact s;

	public ContactModel(ConnectionPool cp) {
		this.s = new ContactImpl(cp);
	}
	
	public ConnectionPool getCP() {
		return this.s.getCP();
	}
	
	public void releaseConnection() {
		this.s.releaseConnection();
	}

//	----------------------------------
	public boolean addContact(ContactObject item) {
		return this.s.addContact(item);
	}
	
	public boolean updateEnable() {
		return this.s.updateEnable();
	}


	public boolean delContact(ContactObject item) {
		return this.s.delContact(item);
	}

//	----------------------------------
	public ContactObject getContactObject(short id) {
		ContactObject item = null;
		ArrayList<ResultSet> res = this.s.getContact(id);
		ResultSet rs = res.get(0);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new ContactObject();
					item.setContact_id(rs.getShort("Contact_id"));
				
					item.setContact_created_date(rs.getString("Contact_created_date"));
					
					item.setContact_enable(rs.getBoolean("Contact_enable"));
				
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item;
	}

	public Pair<ArrayList<ContactObject>, Short> getContactObjects(Triplet<ContactObject, Integer, Byte> infos) {
		ArrayList<ContactObject> items = new ArrayList<>();

		ContactObject item = null;

		ArrayList<ResultSet> res = this.s.getContacts(infos);

		
		
		ResultSet rs = res.get(0);

		if (rs != null) {
			try {
				while (rs.next()) {
					item = new ContactObject();
					item.setContact_id(rs.getShort("Contact_id"));
					item.setContact_title(rs.getString("contact_title"));
					item.setContact_email(rs.getString("contact_email"));
					item.setContact_content(rs.getString("contact_content"));
					item.setContact_created_date(rs.getString("Contact_created_date"));
					item.setContact_enable(rs.getBoolean("Contact_enable"));
                
					items.add(item);
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		rs = res.get(1);
		short total = 0;
		if (rs != null) {
			try {
				if (rs.next()) {
					total = rs.getShort("total");
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return new Pair<>(items, total);
	}
}
