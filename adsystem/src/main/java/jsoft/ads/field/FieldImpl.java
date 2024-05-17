package jsoft.ads.field;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.javatuples.Pair;
import org.javatuples.Quartet;

import jsoft.ConnectionPool;
import jsoft.ads.basic.BasicImpl;
import jsoft.library.ORDER;
import jsoft.objects.FieldObject;
import jsoft.objects.UserObject;

public class FieldImpl extends BasicImpl implements Field {

	public FieldImpl(ConnectionPool cp) {
		super(cp, "Field");
	}

	@Override
	public boolean addField(FieldObject item) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO tblField(");
		sql.append("Field_name, Field_notes, Field_created_date, ");
		sql.append("Field_last_modified, field_author_id ) ");
		sql.append("VALUE(?, ?, ?, ?, ?)");

		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());

			pre.setString(1, item.getField_name());
			pre.setString(2, item.getField_notes());
			pre.setString(3, item.getField_created_date());
			pre.setString(4, item.getField_last_modified());
			pre.setInt(5, item.getField_author_id());

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
	public boolean editField(FieldObject item,FIELD_EDIT_TYPE et) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE tblField SET ");
		switch(et) {
		case GENERAL:
			sql.append("Field_name=?, Field_notes=?, ");
			sql.append("Field_last_modified=? ");
			break;
		case TRASH:
			sql.append("Field_delete= 1, Field_last_modified=? ");
			break;
		case RESTORE :
			sql.append("Field_delete= 0, Field_last_modified=? ");
			break;
		}
		sql.append(" WHERE Field_id=?;");
		System.out.println(sql);
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			switch (et) {
			case GENERAL: 
				pre.setString(1, item.getField_name());
				pre.setString(2, item.getField_notes());
				pre.setString(3, item.getField_last_modified());
				pre.setInt(4, item.getField_id());
				break;
			case TRASH:
				pre.setString(1, item.getField_last_modified());
				pre.setInt(2, item.getField_id());
				break;
			case RESTORE:
				pre.setString(1, item.getField_last_modified());
				pre.setInt(2, item.getField_id());
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
	public boolean delField(FieldObject item) {
		// TODO Auto-generated method stub
		if (!this.isEmptyFieldObject(item)) {
			return false;
		}
		//System.out.println(item.getField_id());

		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM tblField WHERE (Field_id=?);");

		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			pre.setInt(1, item.getField_id());
            System.out.println(sql);
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

	private boolean isEmptyFieldObject(FieldObject item) {
		boolean flag = true;

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM tblarticle WHERE article_Field_id='").append(item.getField_id())
				.append("';");
		sql.append("SELECT category_Field_id FROM tblcategory WHERE category_Field_id=" + item.getField_id() + "; ");
		

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
	public ArrayList<ResultSet> getField(short id, UserObject userLogined) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM tblField AS s ");
		sql.append("LEFT JOIN tbluser AS u ON s.field_author_id = u.user_id ");
		sql.append("WHERE (s.Field_id = "+id+");"); 
		return this.getMR(sql.toString());
	}

	@Override
	public ArrayList<ResultSet> getFields(Quartet<FieldObject, Integer, Byte,UserObject> infos, Pair<FIELD_SOFT, ORDER> so) {
		// đối tượng lưu trữ thông tin lọc kết quả
		FieldObject similar = infos.getValue0();

		// vị trí bắt đầu lấy bản ghi
		int at = infos.getValue1();

		// Số bản ghi được lấy trong một lần
		byte total = infos.getValue2();

		UserObject user = infos.getValue3();
		
		StringBuffer sql = new StringBuffer();

		sql.append("SELECT * FROM tblField AS s ");
		sql.append("LEFT JOIN tbluser AS u ON s.field_author_id = u.user_id ");
		sql.append("");
		sql.append(this.createConditions(similar));
		switch (so.getValue0()) {
		case ID:
			sql.append("ORDER BY s.Field_id ").append(so.getValue1().name());
			break;
		case NAME:
			sql.append("ORDER BY s.Field_name ").append(so.getValue1().name());
			break;
		case MANAGER:
			sql.append("ORDER BY s.Field_author_id  ").append(so.getValue1().name());
			break;
		default:
			sql.append("ORDER BY s.Field_name DESC ");

		}
		sql.append(" LIMIT ").append(at).append(", ").append(total).append(";");

		sql.append("SELECT COUNT(Field_id) AS total FROM tblField ");
		sql.append(createConditions(similar));
		sql.append(";");

		return this.getMR(sql.toString());
	}
	private String createConditions(FieldObject similar) {
		StringBuffer conds = new StringBuffer();
		if (similar != null) {
			if(similar.isField_delete()) {
				conds.append(" (Field_delete=1)");
			} else {
				conds.append(" (Field_delete=0) ");
			}
			// tu khoa tim kiem
			String key = similar.getField_name();
			if(key!=null && !key.equalsIgnoreCase("")) {
				conds.append(" AND ((Field_name LIKE '%"+key+"%') OR ");
				conds.append("(Field_notes LIKE '%"+key+"%') ");
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
