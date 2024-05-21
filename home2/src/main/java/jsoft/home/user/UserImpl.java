package jsoft.home.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jsoft.ConnectionPool;
import jsoft.home.basic.BasicImpl;
import jsoft.objects.ClientObject;
import jsoft.objects.UserObject;

public class UserImpl extends BasicImpl implements User {

	public UserImpl(ConnectionPool cp) {
		super(cp, "User");
	}

	private boolean isExisting(UserObject item) {
		boolean flag = false;
		String sql = "SELECT user_id FROM tblUser WHERE user_name = '" + item.getUser_name() + "'";
		ResultSet rs = this.get(sql, 0);
		if (rs != null) {
			try {
				if (rs.next()) {
					flag = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return flag;
	}

	@Override
	public boolean signup(UserObject item) {
		// TODO Auto-generated method stub
		if (this.isExisting(item)) {
			return false;
		}
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO tbluser(");
		sql.append("user_name, user_pass, user_fullname, user_birthday, user_mobilephone, ");
		sql.append("user_homephone, user_officephone, user_email, user_address, user_jobarea, ");
		sql.append("user_job, user_position, user_applyyear, user_permission, user_notes, ");
		sql.append("user_roles, user_logined, user_created_date, user_last_modified,");
		sql.append("user_last_logined, user_parent_id, user_actions , user_avatar ");
		sql.append(")");
		sql.append("VALUE(?,md5(?),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

		// bien dich
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			pre.setString(1, item.getUser_name());
			pre.setString(2, item.getUser_pass());
			pre.setString(3, item.getUser_fullname());
			pre.setString(4, item.getUser_birthday());
			pre.setString(5, item.getUser_mobilephone());
			pre.setString(6, item.getUser_homephone());
			pre.setString(7, item.getUser_officephone());
			pre.setString(8, item.getUser_email());
			pre.setString(9, item.getUser_address());
			pre.setString(10, item.getUser_jobarea());
			pre.setString(11, item.getUser_job());
			pre.setString(12, item.getUser_position());
			pre.setShort(13, item.getUser_applyyear());
			pre.setByte(14, item.getUser_permission());
			pre.setString(15, item.getUser_notes());
			pre.setString(16, item.getUser_roles());
			pre.setShort(17, item.getUser_logined());
			pre.setString(18, item.getUser_created_date());
			pre.setString(19, item.getUser_last_modified());
			pre.setString(20, item.getUser_last_logined());
			pre.setInt(21, item.getUser_parent_id());
			pre.setByte(22, item.getUser_actions());
			pre.setString(23, item.getUser_avatar());
			boolean isInsert = this.add(pre);
		    return isInsert;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			// tro ve trang thai an toan cua ket noi
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public boolean editUser(UserObject item, USER_EDIT_TYPE et) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE tbluser SET ");
		switch (et) {
		case GENERAL:
			sql.append("user_fullname=?, user_birthday=?, user_mobilephone=?, ");
			sql.append("user_homephone=?, user_officephone=?, user_email=?, user_address=?, user_jobarea=?, ");
			sql.append("user_job=?, user_position=?, user_applyyear=?, user_notes=?, user_gender=?, user_alias=?, ");
			if (item.getUser_avatar() != null) {
				sql.append("user_last_modified=?, user_actions=?, user_avatar= ? ");
			} else {
				sql.append("user_last_modified=?, user_actions=? ");
			}

			break;
		case SETTING:
			sql.append("user_roles=?, user_last_modified=?user_permission=? ");
			break;
		case PASS:
			sql.append("user_pass=md5(?) ");
			break;
		case TRASH:
			sql.append("user_deleted= 1, user_last_modified=? ");
			break;
		case RESTORE:
			sql.append("user_deleted= 0, user_last_modified=? ");
			break;
		}

		sql.append(" WHERE user_id=?;");
		// bien dich
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			switch (et) {
			case GENERAL:
				pre.setString(1, item.getUser_fullname());
				pre.setString(2, item.getUser_birthday());
				pre.setString(3, item.getUser_mobilephone());
				pre.setString(4, item.getUser_homephone());
				pre.setString(5, item.getUser_officephone());
				pre.setString(6, item.getUser_email());
				pre.setString(7, item.getUser_address());
				pre.setString(8, item.getUser_jobarea());
				pre.setString(9, item.getUser_job());
				pre.setString(10, item.getUser_position());
				pre.setShort(11, item.getUser_applyyear());
				pre.setString(12, item.getUser_notes());
				pre.setInt(13, item.getUser_gender());
				pre.setString(14, item.getUser_alias());
				pre.setString(15, item.getUser_last_modified());
				pre.setByte(16, item.getUser_actions());
				if (item.getUser_avatar() != null && !item.getUser_avatar().equalsIgnoreCase("")) {
					pre.setString(17, item.getUser_avatar());
					pre.setInt(18, item.getUser_id());
				} else {
					pre.setInt(17, item.getUser_id());
				}
				break;
			case SETTING:
				pre.setByte(1, item.getUser_permission());
				pre.setString(2, item.getUser_roles());
				pre.setInt(3, item.getUser_id());
				break;
			case PASS:
				pre.setString(1, item.getUser_pass());
				pre.setInt(2, item.getUser_id());
				break;
			case TRASH:
				pre.setString(1, item.getUser_last_modified());
				pre.setInt(2, item.getUser_id());
				break;
			case RESTORE:
				pre.setString(1, item.getUser_last_modified());
				pre.setInt(2, item.getUser_id());
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + et);
			}
			if(item instanceof ClientObject) {
				ClientObject client = (ClientObject) item;
				StringBuilder sql2 = new StringBuilder();
				if (item != null && !client.getClient_profiles().equalsIgnoreCase("")) {
					sql2.append("UPDATE tblclient SET ");
					sql2.append("`client_profiles` = '"+client.getClient_profiles()+"'");
					sql2.append(" where user_id = "+client.getUser_id()+";");
					PreparedStatement pre2 = this.con.prepareStatement(sql2.toString());
					return this.edit(pre) && this.edit(pre2);
				} else {
					return this.edit(pre);
				}
				
			} else {
				return this.edit(pre);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			// tro ve trang thai an toan cua ket noi
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}

	
	
	@Override
	public ResultSet getUser(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tblclient as c left join tblUser as u on u.user_id=c.user_id WHERE (u.user_id = " + id + ") AND (user_deleted=0)";
		return this.gets(sql);
	}

	@Override
	public ResultSet getUser(String username, String userpass) {
		// TODO Auto-generated method stub

		String sqlSlc = "SELECT * FROM tblUser WHERE (user_name = ?) AND (user_pass = md5(?)) AND (user_deleted=0); ";
		String sqlUpd = "UPDATE tbluser SET user_logined = user_logined + 1  WHERE (user_name = ?) AND (user_pass = md5(?));";
		ArrayList<String> sql = new ArrayList<String>();
		sql.add(sqlSlc);
		sql.add(sqlUpd);
		return this.get(sql, username, userpass);
	}

	@Override
	public ResultSet getCheckPass(UserObject item) {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM tblUser WHERE (user_id = ?) AND (user_pass = md5(?)); ";
		return this.get(sql, item.getUser_id(), item.getUser_pass());
	}

	@Override
	public boolean updateLogined(UserObject item) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE tbluser SET user_logined = user_logined + 1 WHERE user_id = ? ;");

		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			pre.setInt(1, item.getUser_id());

			return this.logined(pre);

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

	public static void main(String[] args) {
//		// tạo bộ quản lý kết nối
//		ConnectionPool cp = new ConnectionPoolImpl();
//
//		// đối tượng thực thi chức năng mức interface
//		User u = new UserImpl(cp);
//
//		// gia lap ADD
//		// tạo đối tượng lưu chữ thông tin thêm mới
//		UserObject nUser = new UserObject();
//		nUser.setUser_name("adVanHoangDao123");
//		nUser.setUser_created_date("06/06/2023");
//		nUser.setUser_email("let911318@gmail.com");
//		nUser.setUser_parent_id(56); // admin
//		nUser.setUser_pass("12345678");
//
//		nUser.setUser_fullname("Dao Van Hoang");
//		nUser.setUser_address("TP Hai Duong");
//
//		nUser.setUser_id(51);
//		boolean result = u.editUser(nUser,USER_EDIT_TYPE.GENERAL);
//		if (!result) {
//			System.out.println("------------------ADD FAIL---------------------");
//		}
//
//		// lấy tập kết quả
//		Triplet<UserObject, Integer, Byte> infos = new Triplet<>(null, 0, (byte) 15);
//
//		ArrayList<ResultSet> res = u.getUsers(infos, new Pair<>(USER_SOFT.NAME, ORDER.DESC));
//
//		ResultSet rs = res.get(0);
//
//		String row;
//
//		if (rs != null) {
//			try {
//				while (rs.next()) {
//					row = "ID: " + rs.getInt("user_id");
//					row += "\tNAME: " + rs.getString("user_fullname");
//					row += "\tPARENT: " + rs.getInt("user_parent_id");
//					row += "\tPASS: " + rs.getString("user_pass");
////					System.out.println(row);
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//		rs = res.get(1);
//		if (rs != null) {
//			try {
//				while (rs.next()) {
//					System.out.println("Tong so tai khoan trong DB:" + rs.getShort("total"));
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}

}
