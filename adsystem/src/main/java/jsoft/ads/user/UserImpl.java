package jsoft.ads.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.javatuples.Pair;
import org.javatuples.Quartet;

import jsoft.ConnectionPool;
import jsoft.ads.basic.BasicImpl;
import jsoft.library.ORDER;
import jsoft.objects.ClientObject;
import jsoft.objects.RecruiterObject;
import jsoft.objects.SectionObject;
import jsoft.objects.ServiceObject;
import jsoft.objects.UserObject;

public class UserImpl extends BasicImpl implements User {

	public UserImpl(ConnectionPool cp) {
		super(cp, "User");
	}

	@Override
	public boolean addUser(UserObject item, USER_TYPE et) {
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
			if (isInsert) {
				StringBuilder sql2 = new StringBuilder();
				sql2.append("SELECT user_id FROM tbluser WHERE user_name='" + item.getUser_name() + "';");
				ResultSet rs = this.gets(sql2.toString());
				if (rs.next()) {
					int user_id = rs.getInt("user_id");
					System.out.println(user_id);
					if (item instanceof ClientObject) {
						ClientObject client = (ClientObject) item;
						StringBuilder sqlinsert = new StringBuilder();
						sqlinsert.append("INSERT INTO tblclient(");
						sqlinsert.append("user_id,client_profiles ");
						sqlinsert.append(")");
						sqlinsert.append("VALUE(?,?)");
						try {
							PreparedStatement pre2 = this.con.prepareStatement(sqlinsert.toString());
							pre2.setInt(1, user_id);
							pre2.setString(2, client.getClient_profiles() );
							return this.add(pre2);
						} catch (Exception e) {
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
					} else if (item instanceof RecruiterObject) {
						RecruiterObject recruiter = (RecruiterObject) item;
						StringBuilder sqlinsert2 = new StringBuilder();
						sqlinsert2.append("INSERT INTO tblrecruiter(");
						sqlinsert2.append("user_id, company_id ");
						sqlinsert2.append(")");
						sqlinsert2.append("VALUE(?,?)");
						try {
							PreparedStatement pre2 = this.con.prepareStatement(sqlinsert2.toString());
							pre2.setInt(1, user_id);
							pre2.setInt(2, recruiter.getCompany_id());
							return this.add(pre2);
						} catch (Exception e) {
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
					} else {
						return true;
					}
				}
			}
			return false;
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
				if (item.getUser_avatar() != null) {
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

			return this.edit(pre);
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
	public boolean delUser(UserObject item) {
		// TODO Auto-generated method stub
		if (!this.isEmptyUserObject(item)) {
			return false;
		}

		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM tbluser WHERE user_id=?");

		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			pre.setInt(1, item.getUser_id());

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

	private boolean isEmptyUserObject(UserObject item) {
		boolean flag = true;

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT article_id FROM tblarticle WHERE article_author_name='").append(item.getUser_name())
				.append("' ;");
		sql.append("SELECT product_id FROM tblproduct WHERE product_manager_id=" + item.getUser_id() + "; ");
		sql.append("SELECT user_id FROM tbluser WHERE user_parent_id=" + item.getUser_id() + "; ");

		ArrayList<ResultSet> res = this.getMR(sql.toString());

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

	private boolean isEmpty(Object item) {
		boolean flag = true;
		StringBuffer sql = new StringBuffer();

		if (item instanceof UserObject) {
			sql.append("SELECT article_id FROM tblarticle WHERE article_author_name='")
					.append(((UserObject) item).getUser_name()).append("' ;");
			sql.append("SELECT product_id FROM tblproduct WHERE product_manager_id=" + ((UserObject) item).getUser_id()
					+ "; ");
			sql.append("SELECT user_id FROM tbluser WHERE user_parent_id=" + ((UserObject) item).getUser_id() + "; ");
		} else if (item instanceof SectionObject) {
			sql.append("category_id FROM tblcategory_section_id = ").append(((SectionObject) item).getSection_id());
		}

		ArrayList<ResultSet> res = this.getMR(sql.toString());

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
	public ResultSet getUser(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tblUser WHERE (user_id = ?) AND (user_deleted=0)";
		return this.get(sql, id);
	}
	
	@Override
	public ResultSet getService(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tblservice WHERE (service_id = ?);";
		return this.get(sql, id);
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
	public ResultSet getEmployer(String username, String userpass) {
		// TODO Auto-generated method stub

		String sqlSlc = "SELECT * FROM tblUser AS u INNER JOIN tblrecruiter AS r ON u.user_id=r.user_id  WHERE (user_name = ?) AND (user_pass = md5(?)) AND (user_deleted=0); ";
		String sqlUpd = "UPDATE tbluser SET user_logined = user_logined + 1  WHERE (user_name = ?) AND (user_pass = md5(?));";
		ArrayList<String> sql = new ArrayList<String>();
		sql.add(sqlSlc);
		sql.add(sqlUpd);
		System.out.println(sqlSlc);
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
	@Override
	public ArrayList<ResultSet> getDashboard() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT COUNT(user_id) AS total FROM tblUser where user_deleted=0 and user_permission=2;" );
		sql.append("SELECT COUNT(job_id) AS total FROM tbljob where job_delete=0 ;" );
		sql.append("SELECT COUNT(*) AS total FROM tblapplications where applications_delete=0 ;");
		sql.append("SELECT * FROM tblJob AS j LEFT JOIN tbluser AS u ON u.user_id = j.job_author_id LEFT JOIN tblcompany AS c ON c.company_id = j.job_company_id LEFT JOIN tblcareer AS a ON a.career_id = j.job_career_id  WHERE  (job_delete=0) ORDER BY j.job_id DESC  LIMIT 0, 6;");
		sql.append("SELECT * FROM tblarticle as a ");
		sql.append("LEFT JOIN tblcategory c ON c.category_id = a.article_category_id ");
		sql.append("LEFT JOIN tblsection s ON c.category_section_id = s.section_id ");
		sql.append("ORDER BY article_id DESC ");
		sql.append("LIMIT 3; ");
		sql.append("SELECT job_status,count(*) as total FROM tbljob group by job_status;");
		return this.getMR(sql.toString());
	}
	@Override
	public ArrayList<ResultSet> getDashboardEmployer(int user_id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT COUNT(job_id) AS total FROM tbljob where job_delete=0 AND job_status = 0 AND job_author_id="+user_id+";" );
		sql.append("SELECT COUNT(job_id) AS total FROM tbljob where job_delete=0 AND job_status = 1 AND job_author_id="+user_id+";" );
		sql.append("SELECT COUNT(*) AS total FROM tblapplications as a LEFT JOIN tbljob as j ON a.applications_job_id=j.job_id where applications_delete=0 AND job_author_id="+user_id+" ;");
		sql.append("SELECT * FROM tblJob AS j LEFT JOIN tbluser AS u ON u.user_id = j.job_author_id LEFT JOIN tblcompany AS c ON c.company_id = j.job_company_id LEFT JOIN tblcareer AS a ON a.career_id = j.job_career_id  WHERE  (job_delete=0) AND (job_author_id="+user_id+") ORDER BY j.job_id DESC  LIMIT 0, 6;");
		sql.append("SELECT job_status,count(*) as total FROM tbljob WHERE (job_author_id="+user_id+") group by job_status ;");
		return this.getMR(sql.toString());
	}
	@Override
	public ArrayList<ResultSet> getUsers(Quartet<UserObject, Integer, Byte, USER_TYPE> infos,
			Pair<USER_SOFT, ORDER> so) {
		// TODO Auto-generated method stub

		// đối tượng lưu trữ thông tin lọc kết quả
		UserObject similar = infos.getValue0();

		// vị trí bắt đầu lấy bản ghi
		int at = infos.getValue1();

		// Số bản ghi được lấy trong một lần
		byte total = infos.getValue2();

		USER_TYPE et = infos.getValue3();

		StringBuffer sql = new StringBuffer();

		sql.append("SELECT * FROM tblUser ");

		sql.append(this.createConditions(similar, et));
		switch (so.getValue0()) {
		case NAME:
			sql.append("ORDER BY user_name ").append(so.getValue1().name());
			break;
		case FULLNAME:
			sql.append("ORDER BY user_fullname ").append(so.getValue1().name());
			break;
		default:
			sql.append("ORDER BY user_id DESC");
		}
		sql.append(" LIMIT " + at + ", " + total + ";");

		sql.append("SELECT COUNT(user_id) AS total FROM tblUser" );
		sql.append(createConditions(similar, et));
		
		if(et == USER_TYPE.RECRUITER) {
		 sql.append(";SELECT * FROM tblcompany WHERE company_delete = 0;");
		}
			
		System.out.println(sql.toString());
		return this.getMR(sql.toString());
	}

	private String createConditions(UserObject similar, USER_TYPE et) {
		StringBuffer conds = new StringBuffer();

		if (similar != null) {
			byte permis = similar.getUser_permission();
			conds.append(" (user_permission<=").append(permis).append(") ");
			if (permis < 4) {
				int id = similar.getUser_id();
				if (id > 0) {
					conds.append(" AND ( (user_parent_id=").append(id).append(") OR (user_id=").append(id)
							.append(") )");
				}
			}
			// tu khoa tim kiem
			String key = similar.getUser_name();
			if (key != null && !key.equalsIgnoreCase("")) {
				conds.append(" AND (");
				conds.append("(user_name LIKE '%" + key + "%') OR ");
				conds.append("(user_fullname LIKE '%" + key + "%') OR ");
				conds.append("(user_address LIKE '%" + key + "%') OR ");
				conds.append("(user_email LIKE '%" + key + "%')  ");
				conds.append(")");
			}

			if (similar.getUser_deleted()) {
				conds.append(" AND (user_deleted=1)");
			} else {
				conds.append("AND (user_deleted=0) ");
			}

		}

		if (!conds.toString().equalsIgnoreCase("")) {
			switch (et) {
			case ADMIN:
				conds.insert(0, " WHERE user_permission>=3 AND ");
				break;
			case CLIENT:
				conds.insert(0, " WHERE user_permission=1 AND ");
				break;
			case RECRUITER:
				conds.insert(0, " WHERE user_permission=2 AND ");
				break;
			default:
				conds.insert(0, " WHERE ");
			}
		}
		return conds.toString();
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

	@Override
	public boolean addOrder(int order_id,ServiceObject sv, UserObject u) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO tbl_order(");
		sql.append("order_id, order_created_at, user_id, order_exporation_date, order_delete, order_status ");
		sql.append(")");
		sql.append("VALUE(?,?,?,?,?,?)");

		// bien dich
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			pre.setInt(1, order_id);
			pre.setString(2, jsoft.library.Utilities_date.getDate());
			pre.setInt(3, u.getUser_id());
			if(sv.getService_id()==56) {
				String dateString = jsoft.library.Utilities_date.getDate();
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		        LocalDate date = LocalDate.parse(dateString, formatter);

		        LocalDate newDate = date.plusDays(90);

		        String result = newDate.format(formatter);
				pre.setString(4, result);
			} else {
				pre.setString(4, jsoft.library.Utilities_date.getDate());
			}
			
			pre.setInt(5, 0);
			pre.setInt(6, 0);
			boolean isInsert = this.add(pre);
			if(isInsert) {
				StringBuilder sql2 = new StringBuilder();
				sql2.append("INSERT INTO tbl_order_detail(");
				sql2.append("order_id, service_id, service_price, service_discount ");
				sql2.append(")");
				sql2.append("VALUE(?,?,?,?)");
				try {
					PreparedStatement pre2 = this.con.prepareStatement(sql2.toString());
					pre2.setInt(1, order_id);
					pre2.setInt(2, sv.getService_id());
					pre2.setInt(3, sv.getService_price());
					pre2.setInt(4, 0);
					return this.add(pre2);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
			} else {
				return false;
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

	

}
