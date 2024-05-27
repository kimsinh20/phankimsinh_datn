package jsoft.ads.contact;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.javatuples.Triplet;

import jsoft.ShareControl;
import jsoft.objects.ContactObject;

public interface Contact extends ShareControl {
	// các chức năng cập nhật
	public boolean addContact(ContactObject c);

	public boolean updateEnable();
	
	public boolean delContact(ContactObject item);
	
	// các chức năng lấy dữ liệu
	public  ArrayList<ResultSet> getContact(short id);

	public ArrayList<ResultSet> getContacts(Triplet<ContactObject, Integer, Byte> infoss);
}
