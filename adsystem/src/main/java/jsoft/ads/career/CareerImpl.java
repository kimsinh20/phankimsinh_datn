package jsoft.ads.career;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.javatuples.Pair;
import org.javatuples.Quartet;

import jsoft.ConnectionPool;
import jsoft.ConnectionPoolImpl;
import jsoft.ads.basic.BasicImpl;
import jsoft.library.ORDER;
import jsoft.objects.CareerObject;
import jsoft.objects.SectionObject;
import jsoft.objects.UserObject;

public class CareerImpl extends BasicImpl implements Career {

	public CareerImpl(ConnectionPool cp) {
		super(cp, "Career");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addCareer(CareerObject item) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO tblCareer (");
		sql.append("Career_name, Career_field_id, Career_notes, Career_created_date, Career_author_id, Career_last_modified ");
		sql.append(")");
		sql.append("VALUES (?,?,?,?,?,?);");
		sql.append("");
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());

			pre.setString(1, item.getCareer_name());
			pre.setInt(2, item.getCareer_field_id());
			pre.setString(3, item.getCareer_notes());
			pre.setString(4, item.getCareer_created_date());
			pre.setInt(5, item.getCareer_author_id());
			pre.setString(6, item.getCareer_last_modified());

			return this.add(pre);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editCareer(CareerObject item,CAREER_EDIT_TYPE et) {
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE tblCareer SET ");
		switch(et) {
		case GENERAL:
			sql.append("Career_name=?, Career_notes=?, ");
			sql.append("Career_last_modified=?, career_field_id=? ");
			break;
		case TRASH:
			sql.append("Career_delete= 1, Career_last_modified=? ");
			break;
		case RESTORE :
			sql.append("Career_delete= 0, Career_last_modified=? ");
			break;
		}
		sql.append(" WHERE Career_id=?;");
		System.out.println(sql);
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			switch (et) {
			case GENERAL: 
				pre.setString(1, item.getCareer_name());
				pre.setString(2, item.getCareer_notes());
				pre.setString(3, item.getCareer_last_modified());
				pre.setInt(4, item.getCareer_field_id());
				pre.setInt(5, item.getCareer_id());
				break;
			case TRASH:
				pre.setString(1, item.getCareer_last_modified());
				pre.setInt(2, item.getCareer_id());
				break;
			case RESTORE:
				pre.setString(1, item.getCareer_last_modified());
				pre.setInt(2, item.getCareer_id());
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + et);
			}
			

			return this.edit(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean delCareer(CareerObject item) {
		// TODO Auto-generated method stub
		if (!this.isEmpty(item)) {
			return false;
		}

		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM tblCareer WHERE (Career_id=?);");

		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			pre.setInt(1, item.getCareer_id());
//			pre.setInt(2, item.getCareer_created_author_id());
//			pre.setInt(3, item.getCareer_manager_id());
//            System.out.println(sql);
			return this.del(pre);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// tro ve trang thai an toan cua ket noi
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		return false;
	}

	private boolean isEmpty(CareerObject item) {
		boolean flag = true;

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM tblarticle WHERE article_Career_id='").append(item.getCareer_id()).append("';");
		sql.append("LEFT JOIN tblfield AS s ON c.Career_field_id = s.field_id ");
		sql.append("LEFT JOIN tbluser AS u ON c.Career_author_id = u.user_id ");
		ArrayList<ResultSet> res = this.getMR(sql.toString());
        System.out.println(sql);
		for (ResultSet rs : res) {
			if (rs != null) {
				try {
					if (rs.next()) {
						flag = false;
						break;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return flag;
	}


	@Override
	public ArrayList<ResultSet> getCareer(short id, UserObject userLogined) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM tblCareer c "); // cate la con cua section
		sql.append("LEFT JOIN tblfield AS s ON c.Career_field_id = s.field_id ");
		sql.append("LEFT JOIN tbluser AS u ON c.Career_author_id = u.user_id ");
		sql.append("WHERE (c.Career_id="+id+");"); 
		
		sql.append("SELECT * FROM tblfield AS s  ");
		sql.append("WHERE (field_delete=0);");
		System.out.println(sql);
		
		return this.getMR(sql.toString());
	}

	@Override
	public ArrayList<ResultSet> getCategories(Quartet<CareerObject, Integer, Byte,UserObject> infos, Pair<CAREER_SOFT, ORDER> so) {
		// TODO Auto-generated method stub
		CareerObject similar = infos.getValue0();

		// vị trí bắt đầu lấy bản ghi
		int at = infos.getValue1();

		// Số bản ghi được lấy trong một lần
		byte total = infos.getValue2();
		
		// tai khoan dang nhap
		UserObject user = infos.getValue3();

		StringBuffer sql = new StringBuffer();

		sql.append("SELECT * FROM tblCareer AS c ");
		sql.append("LEFT JOIN tblfield AS s ON c.Career_field_id = s.field_id ");
		sql.append("LEFT JOIN tbluser AS u ON c.Career_author_id = u.user_id ");
		sql.append(this.createConditions(similar));
		switch (so.getValue0()) {
		case GENERAL:
			sql.append("ORDER BY s.field_name ASC ");
			break;
		case NAME:
			sql.append("ORDER BY c.Career_name ").append(so.getValue1().name());
			break;
		default:
			sql.append("ORDER BY c.Career_id DESC ");

		}
		sql.append(" LIMIT ").append(at).append(", ").append(total).append(";");

		sql.append("SELECT COUNT(Career_id) AS total FROM tblCareer");
		sql.append(createConditions(similar));
		sql.append(";");
		
		// thong ke danh sach cac tai khoan quan ly cac danh muc 
		
		sql.append("SELECT * FROM tblfield AS s  ");
		sql.append("WHERE (field_delete=0);");
		System.out.println(sql.toString());
		
		return this.getMR(sql.toString());
	}

	private String createConditions(CareerObject similar) {
		StringBuffer conds = new StringBuffer();
		if (similar != null) {
			if(similar.isCareer_delete()) {
				conds.append(" (Career_delete=1)");
			} else {
				conds.append(" (Career_delete=0) ");
			}
			// tu khoa tim kiem
			String key = similar.getCareer_name();
			if(key!=null && !key.equalsIgnoreCase("")) {
				conds.append(" AND ((Career_name LIKE '%"+key+"%') OR ");
				conds.append("(Career_notes LIKE '%"+key+"%') ");
//				conds.append("(user_name LIKE '%"+key+"%') ");
				conds.append(")");
			} 
				
		}
		if (!conds.toString().equalsIgnoreCase("")) {
			conds.insert(0, " WHERE ");
		}
		return conds.toString();
	}
	
}
