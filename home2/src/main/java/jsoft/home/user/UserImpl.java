package jsoft.home.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jsoft.ConnectionPool;
import jsoft.home.basic.BasicImpl;
import jsoft.objects.UserObject;

public class UserImpl extends BasicImpl implements User {

	public UserImpl(ConnectionPool cp) {
		super(cp, "User");
	}

	

	@Override
	public ResultSet getUser(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tblUser WHERE (user_id = ?) AND (user_deleted=0)";
		return this.get(sql, id);
	}

	@Override
	public ResultSet getUser(String username, String userpass) {
		// TODO Auto-generated method stub

		String sqlSlc = "SELECT * FROM tblUser WHERE (user_name = ?) AND (user_pass = md5(?)) AND (user_deleted=0) AND (user_permission=1); ";
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
