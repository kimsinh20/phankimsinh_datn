package jsoft.ads.field;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.library.ORDER;
import jsoft.objects.FieldObject;
import jsoft.objects.UserObject;

public class FieldModel {
	private Field s;

	public FieldModel(ConnectionPool cp) {
		this.s = new FieldImpl(cp);
	}
	
	public ConnectionPool getCP() {
		return this.s.getCP();
	}
	
	public void releaseConnection() {
		this.s.releaseConnection();
	}

//	----------------------------------
	public boolean addField(FieldObject item) {
		return this.s.addField(item);
	}

	public boolean editField(FieldObject item,FIELD_EDIT_TYPE et) {
		return this.s.editField(item,et);
	}

	public boolean delField(FieldObject item) {
		return this.s.delField(item);
	}

//	----------------------------------
	public Pair<FieldObject, HashMap<Integer, String>> getFieldObject(short id, UserObject userLogin) {
		FieldObject item = null;
		HashMap<Integer, String> author_name = new HashMap<>();
		ArrayList<ResultSet> res = this.s.getField(id, userLogin);
		ResultSet rs = res.get(0);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new FieldObject();
					item.setField_id(rs.getShort("Field_id"));
					item.setField_name(rs.getString("Field_name"));
					item.setField_notes(rs.getString("Field_notes"));
					item.setField_created_date(rs.getString("Field_created_date"));
					author_name.put(rs.getInt("field_author_id"), rs.getString("user_fullname")+"("+rs.getString("user_name")+")");
					item.setField_enable(rs.getBoolean("Field_enable"));
					item.setField_delete(rs.getBoolean("Field_delete"));
					item.setField_last_modified(rs.getString("Field_last_modified"));
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return new Pair<>(item,author_name);
	}

	public Triplet<ArrayList<FieldObject>, Short,HashMap<Integer, String>> getFieldObjects(Quartet<FieldObject, Integer, Byte,UserObject> infos, Pair<FIELD_SOFT, ORDER> so) {
		ArrayList<FieldObject> items = new ArrayList<>();

		FieldObject item = null;

		ArrayList<ResultSet> res = this.s.getFields(infos, so);

		HashMap<Integer, String> author = new HashMap<>();
		
		
		ResultSet rs = res.get(0);

		if (rs != null) {
			try {
				while (rs.next()) {
					item = new FieldObject();
					item.setField_id(rs.getShort("Field_id"));
					item.setField_name(rs.getString("Field_name"));
					item.setField_notes(rs.getString("Field_notes"));
					item.setField_created_date(rs.getString("Field_created_date"));
					author.put(rs.getInt("field_author_id"), rs.getString("user_fullname")+"("+rs.getString("user_name")+")");
					item.setField_enable(rs.getBoolean("Field_enable"));
					item.setField_delete(rs.getBoolean("Field_delete"));
					item.setField_last_modified(rs.getString("Field_last_modified"));
					item.setField_author_id(rs.getInt("field_author_id"));
                
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
		
		
		
		return new Triplet<>(items, total,author);
	}
}
