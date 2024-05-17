package jsoft.ads.career;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.library.ORDER;
import jsoft.objects.CareerObject;
import jsoft.objects.FieldObject;
import jsoft.objects.SectionObject;
import jsoft.objects.UserObject;

public class CareerModel {
	private Career c;
	public CareerModel(ConnectionPool cp) {
		this.c = new CareerImpl(cp);
	}
	
	public ConnectionPool getCP() {
		return this.c.getCP();
	}

	public void releaseConnection() {
		this.c.releaseConnection();
	}
	
//	---------------------------------------
	public boolean addCareer(CareerObject item) {
		return this.c.addCareer(item);
	}
	
	public boolean editCareer(CareerObject item,CAREER_EDIT_TYPE et) {
		return this.c.editCareer(item,et);
	}
	
	public boolean delCareer(CareerObject item) {
		return this.c.delCareer(item);
	}
	
//	----------------------------------------
	
	public Triplet<CareerObject, HashMap<Integer, String>,ArrayList<FieldObject>> getCareerObject(short id, UserObject userLogined) {
		CareerObject item = null;
		HashMap<Integer, String> author_name = new HashMap<>();
		ArrayList<ResultSet> res= this.c.getCareer(id, userLogined);
		ResultSet rs = res.get(0);
		if(rs!=null) {
			try {
				if(rs.next()) {
					item = new CareerObject();
					author_name.put(rs.getInt("Career_author_id"), rs.getString("user_fullname")+"("+rs.getString("user_name")+")");
					item.setCareer_id(rs.getShort("Career_id"));
					item.setCareer_name(rs.getString("Career_name"));
					item.setCareer_author_id(rs.getInt("career_author_id"));
					item.setCareer_created_date(rs.getString("Career_created_date"));
					FieldObject f = new FieldObject();
					f.setField_id(rs.getInt("field_id"));
					f.setField_name(rs.getString("field_name"));
					item.setField(f);
					item.setCareer_last_modified(rs.getString("Career_last_modified"));
				
					item.setCareer_notes(rs.getString("Career_notes"));
					item.setCareer_field_id(rs.getInt("career_field_id"));
					
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		rs = res.get(1);
		ArrayList<FieldObject> fields = new ArrayList<>();
		FieldObject field = null;
		if(rs!=null) {
			try {
				while(rs.next()) {
					field =new FieldObject();
					field.setField_id(rs.getInt("field_id"));
					field.setField_name(rs.getString("field_name"));
					fields.add(field);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		return new Triplet<>(item,author_name,fields);
	}
	
	public Quartet<ArrayList<CareerObject>, Short,HashMap<Integer, String>,ArrayList<FieldObject>> getCareerObjects
	(Quartet<CareerObject, Integer, Byte,UserObject> infos, Pair<CAREER_SOFT, ORDER> so) {
		ArrayList<CareerObject> items = new ArrayList<>();
		CareerObject item = null;
		
        HashMap<Integer, String> author = new HashMap<>();
		
		ArrayList<ResultSet> res = this.c.getCategories(infos, so);
		
		ResultSet rs = res.get(0);
		if(rs!=null) {
			try {
				while(rs.next()) {
					item = new CareerObject();
					item.setCareer_id(rs.getShort("Career_id"));
					author.put(rs.getInt("career_author_id"), rs.getString("user_fullname")+"("+rs.getString("user_name")+")");
					item.setCareer_name(rs.getString("Career_name"));
					item.setCareer_created_date(rs.getString("Career_created_date"));
					item.setCareer_last_modified(rs.getString("Career_last_modified"));
					item.setCareer_delete(rs.getBoolean("career_delete"));
					item.setCareer_notes(rs.getString("Career_notes")!=null?rs.getString("Career_notes"):"");
					item.setCareer_author_id(rs.getInt("career_author_id"));
					FieldObject f = new FieldObject();
					f.setField_id(rs.getInt("field_id"));
					f.setField_name(rs.getString("field_name"));
					item.setField(f);
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
		if(rs!= null) {
			try {
				if(rs.next()) {
					total = rs.getShort("total");
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		ArrayList<FieldObject> fields = new ArrayList<>();

		FieldObject field = null;
	    rs = res.get(2);

		if (rs != null) {
			try {
				while (rs.next()) {
					field = new FieldObject();
					field.setField_id(rs.getShort("Field_id"));
					field.setField_name(rs.getString("Field_name"));
                
					fields.add(field);
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return new Quartet<>(items, total,author,fields);
	}
}
