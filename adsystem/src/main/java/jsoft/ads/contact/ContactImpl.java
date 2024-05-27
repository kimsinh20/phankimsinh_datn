package jsoft.ads.contact;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.ads.basic.BasicImpl;
import jsoft.objects.ContactObject;

public class ContactImpl extends BasicImpl implements Contact {

	public ContactImpl(ConnectionPool cp) {
		super(cp, "Contact");
	}

	@Override
	public boolean addContact(ContactObject c) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO tblcontact(");
		sql.append(" contact_title, contact_email, contact_fullname, contact_enable, contact_created_date, contact_content ) ");
		sql.append("VALUE(?, ?, ?, ?, ?, ?)");

		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());

			pre.setString(1, c.getContact_title());
			pre.setString(2, c.getContact_email());
			pre.setString(3, c.getContact_fullname());
			pre.setBoolean(4, c.isContact_enable());
			pre.setString(5, c.getContact_created_date());
			pre.setString(6, c.getContact_content());

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
	public boolean delContact(ContactObject item) {
		// TODO Auto-generated method stub
		if (!this.isEmptyContactObject(item)) {
			return false;
		}
		//System.out.println(item.getContact_id());

		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM tblContact WHERE (Contact_id=?);");

		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			pre.setInt(1, item.getContact_id());
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

	private boolean isEmptyContactObject(ContactObject item) {
		boolean flag = true;

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM tblarticle WHERE article_Contact_id='").append(item.getContact_id())
				.append("';");
		sql.append("SELECT category_Contact_id FROM tblcategory WHERE category_Contact_id=" + item.getContact_id() + "; ");
		

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
	public ArrayList<ResultSet> getContact(short id) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM tblContact AS s ");
		sql.append("WHERE (s.Contact_id = "+id+");"); 
		return this.getMR(sql.toString());
	}

	@Override
	public ArrayList<ResultSet> getContacts(Triplet<ContactObject, Integer, Byte> infos) {
		// đối tượng lưu trữ thông tin lọc kết quả
		ContactObject similar = infos.getValue0();

		// vị trí bắt đầu lấy bản ghi
		int at = infos.getValue1();

		// Số bản ghi được lấy trong một lần
		byte total = infos.getValue2();

		
		StringBuffer sql = new StringBuffer();

		sql.append("SELECT * FROM tblContact AS s ");
		sql.append("");
		sql.append(this.createConditions(similar));
		sql.append(" ORDER BY s.Contact_id DESC ");

		sql.append(" LIMIT ").append(at).append(", ").append(total).append(";");

		sql.append("SELECT COUNT(Contact_id) AS total FROM tblContact ");
		sql.append(createConditions(similar));
		sql.append(";");

		return this.getMR(sql.toString());
	}
	private String createConditions(ContactObject similar) {
		StringBuffer conds = new StringBuffer();
		if (similar != null) {
			// tu khoa tim kiem
			String key = similar.getContact_title();
			if(key!=null && !key.equalsIgnoreCase("")) {
				conds.append(" ((Contact_title LIKE '%"+key+"%') OR ");
				conds.append("(Contact_content LIKE '%"+key+"%') ");
//				conds.append("(user_name LIKE '%"+key+"%') ");
				conds.append(")");
			} 
				
		}
		if (!conds.toString().equalsIgnoreCase("")) {
			conds.insert(0, " WHERE ");
		}
		return conds.toString();
	}

	@Override
	public boolean updateEnable() {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tblcontact SET contact_enable = 1 ;");
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());

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
}
