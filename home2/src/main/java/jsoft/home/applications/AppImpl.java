package jsoft.home.applications;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.javatuples.Pair;
import org.javatuples.Quartet;

import jsoft.ConnectionPool;
import jsoft.home.basic.BasicImpl;
import jsoft.library.ORDER;
import jsoft.objects.ApplicationsObject;
import jsoft.objects.UserObject;

public class AppImpl extends BasicImpl implements Applications {

	public AppImpl(ConnectionPool cp) {
		super(cp, "applications");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addApp(ApplicationsObject item) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO tblapplications (");
		sql.append("`applications_user_id`, `applications_job_id`, `applications_delete`, `applications_enable`, `applications_created_date`, `applications_last_modified`, `applications_status`, `applications_letter`, `applications_cv` ");
		sql.append(")");
		sql.append("VALUES (?,?,?,?,?,?,?,?,?);");
		sql.append("");
		
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			pre.setInt(1, item.getUser().getUser_id());
			pre.setInt(2, item.getJob().getJob_id());
			pre.setBoolean(3, item.isApplications_delete());
			pre.setBoolean(4, item.isApplications_enable());
			pre.setString(5, item.getApplications_created_date());
			pre.setString(6, item.getApplications_last_modified());
			pre.setInt(7, item.getApplications_status());
			pre.setString(8, item.getApplications_letter());
			pre.setString(9, item.getApplications_cv());
			
			
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
	public boolean editApp(ApplicationsObject item,APP_EDIT_TYPE et) {
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE tblapplications SET ");
		switch(et) {
		case GENERAL:
			sql.append("applications_name=?, applications_notes=?, ");
			sql.append("applications_last_modified=?, applications_field_id=? ");
			break;
		case TRASH:
			sql.append("applications_delete= 1, applications_last_modified=? ");
			break;
		case RESTORE :
			sql.append("applications_delete= 0, applications_last_modified=? ");
			break;
		case STATUS :
			sql.append("applications_status= ?, applications_last_modified=? ");
			break;
		}
		sql.append(" WHERE applications_id=?;");
		System.out.println(sql);
		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			switch (et) {
			case GENERAL: 
			
				break;
			case TRASH:
				pre.setString(1, item.getApplications_last_modified());
				pre.setInt(2, item.getApplications_id());
				break;
			case RESTORE:
				pre.setString(1, item.getApplications_last_modified());
				pre.setInt(2, item.getApplications_id());
				break;
			case STATUS:
				pre.setInt(1, item.getApplications_status());
				pre.setString(2, item.getApplications_last_modified());
				pre.setInt(3, item.getApplications_id());
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
	public boolean delApp(ApplicationsObject item) {
		// TODO Auto-generated method stub
		if (!this.isEmpty(item)) {
			return false;
		}

		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM tblapplications WHERE (applications_id=?);");

		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			pre.setInt(1, item.getApplications_id());
//			pre.setInt(2, item.getapplications_created_author_id());
//			pre.setInt(3, item.getapplications_manager_id());
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

	private boolean isEmpty(ApplicationsObject item) {
		boolean flag = true;

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM tblarticle WHERE article_applications_id='").append(item.getApplications_id()).append("';");
		sql.append("LEFT JOIN tblfield AS s ON c.applications_field_id = s.field_id ");
		sql.append("LEFT JOIN tbluser AS u ON c.applications_author_id = u.user_id ");
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
	public ArrayList<ResultSet> getApp(short id, UserObject userLogined) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM tblapplications c "); // cate la con cua section
		sql.append("LEFT JOIN tblfield AS s ON c.applications_field_id = s.field_id ");
		sql.append("LEFT JOIN tbluser AS u ON c.applications_author_id = u.user_id ");
		sql.append("WHERE (c.applications_id="+id+");"); 
		
		sql.append("SELECT * FROM tblfield AS s  ");
		sql.append("WHERE (field_delete=0);");
		System.out.println(sql);
		
		return this.getMR(sql.toString());
	}

	@Override
	public ArrayList<ResultSet> getApps(Quartet<ApplicationsObject, Integer, Byte,UserObject> infos, Pair<APP_SOFT, ORDER> so) {
		// TODO Auto-generated method stub
		ApplicationsObject similar = infos.getValue0();

		// vị trí bắt đầu lấy bản ghi
		int at = infos.getValue1();

		// Số bản ghi được lấy trong một lần
		byte total = infos.getValue2();
		
		// tai khoan dang nhap
		UserObject user = infos.getValue3();

		StringBuffer sql = new StringBuffer();

		sql.append("SELECT * FROM tblapplications AS c ");
		sql.append("LEFT JOIN tbljob AS s ON c.applications_job_id = s.job_id ");
		sql.append("LEFT JOIN tbluser AS u ON c.applications_user_id = u.user_id ");
		sql.append(this.createConditions(similar));
		switch (so.getValue0()) {
		case GENERAL:
			sql.append("ORDER BY c.applications_id DESC ");
			break;
		default:
			sql.append("ORDER BY c.applications_id DESC ");

		}
		sql.append(" LIMIT ").append(at).append(", ").append(total).append(";");

		sql.append("SELECT COUNT(applications_id) AS total FROM tblapplications");
		sql.append(createConditions(similar));
		sql.append(";");
		System.out.println(sql.toString());
		
		return this.getMR(sql.toString());
	}

	private String createConditions(ApplicationsObject similar) {
		StringBuffer conds = new StringBuffer();
		if (similar != null) {
			if(similar.isApplications_delete()) {
				conds.append(" (applications_delete=1)");
			} else {
				conds.append(" (applications_delete=0) ");
			}
			// tu khoa tim kiem
//			String key = similar.id();
//			if(key!=null && !key.equalsIgnoreCase("")) {
//				conds.append(" AND ((applications_name LIKE '%"+key+"%') OR ");
//				conds.append("(applications_notes LIKE '%"+key+"%') ");
////				conds.append("(user_name LIKE '%"+key+"%') ");
//				conds.append(")");
//			} 
				
		}
		if (!conds.toString().equalsIgnoreCase("")) {
			conds.insert(0, " WHERE ");
		}
		return conds.toString();
	}

	public boolean isExisting(int job_id,int user_id) {
		boolean flag = false;
		String sql = "SELECT * FROM tblapplications WHERE (`applications_job_id` = '"+job_id+"' AND `applications_user_id`='"+user_id+"');";
		ArrayList<ResultSet> listrs = this.getMR(sql);
		ResultSet rs = listrs.get(0);
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
	
}
