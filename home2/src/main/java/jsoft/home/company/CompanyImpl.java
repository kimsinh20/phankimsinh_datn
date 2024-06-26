package jsoft.home.company;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.javatuples.Pair;
import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.home.basic.BasicImpl;
import jsoft.library.ORDER;
import jsoft.objects.CompanyObject;
import jsoft.objects.JobObject;
import jsoft.objects.UserObject;

public class CompanyImpl extends BasicImpl implements company {

	public CompanyImpl(ConnectionPool cp) {
		super(cp, "Company");
		// TODO Auto-generated constructor stub
	}


	@Override
	public ArrayList<ResultSet> getCompany(short id) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tblcompany c "); // cate la con cua section
		sql.append("LEFT JOIN tblfield f ON c.company_field_id = f.field_id ");
		sql.append("WHERE (c.company_delete=0) AND (c.company_id=" + id + ");");

		sql.append("SELECT * FROM tblskill WHERE skill_delete = 0;");
		
		sql.append("SELECT * FROM tbljob as j ");
		sql.append("LEFT JOIN tblcompany as c ");
		sql.append("ON j.job_company_id=c.company_id ");
		sql.append("WHERE j.job_status>0 AND job_delete=0 AND job_enable=0 ");
		sql.append("ORDER BY job_id DESC ");
		sql.append("LIMIT 2; ");
		
		sql.append("SELECT * FROM tblarticle as a ");
		sql.append("LEFT JOIN tblcategory c ON c.category_id = a.article_category_id ");
		sql.append("LEFT JOIN tblsection s ON c.category_section_id = s.section_id ");
		sql.append("ORDER BY article_visited DESC ");
		sql.append("LIMIT 3; ");
		
		sql.append("SELECT company_id,COUNT(user_id) AS total FROM tblcompanyfollow WHERE company_id = "+id);
		sql.append(";");
		
		return this.getMR(sql.toString());
	}

	@Override
	public ArrayList<ResultSet> getCompanies(Triplet<CompanyObject, Integer, Byte> infos,Pair<COMPANY_SOFT, ORDER> so) {
		// TODO Auto-generated method stub
		CompanyObject similar = infos.getValue0();

		// vị trí bắt đầu lấy bản ghi
		int at = infos.getValue1();

		// Số bản ghi được lấy trong một lần
		byte total = infos.getValue2();

		StringBuffer sql = new StringBuffer();

		
		sql.append("SELECT * FROM tblcompany AS c ");
		sql.append("LEFT JOIN tblfield AS f ON f.field_id = c.company_field_id ");
		sql.append(this.createConditions(similar));
		switch (so.getValue0()) {
		case GENERAL:
			sql.append("ORDER BY c.company_visited ").append(so.getValue1().name());
			break;
		case DATE:
			sql.append("ORDER BY c.company_id ").append(so.getValue1().name());
			break;
		case TITLE:
			sql.append("ORDER BY c.company_name ").append(so.getValue1().name());
			break;
		default:
			sql.append("ORDER BY c.company_id ").append(so.getValue1().name());

		}
		
		sql.append(" LIMIT ").append(at).append(", ").append(total).append(";");
		
		sql.append("SELECT COUNT(company_id) AS total FROM tblcompany as c ");
		sql.append("LEFT JOIN tblfield AS f ON f.field_id = c.company_field_id ");
		sql.append(createConditions(similar));
		sql.append(";");
		
		sql.append(" SELECT * FROM tblfield where field_delete=0 ; ");
		
		System.out.println(sql.toString());
		return this.getMR(sql.toString());
	}

	private String createConditions(CompanyObject similar) {
		StringBuffer conds = new StringBuffer();
				if (similar != null) {
			if (similar.isCompany_delete()) {
				conds.append(" (company_delete=1)");
			} else {
				conds.append(" (company_delete=0) ");
			}
			// tu khoa tim kiem
			String key = similar.getCompany_name();
			if (key != null && !key.equalsIgnoreCase("")) {
				conds.append(" AND ((company_about LIKE '%" + key + "%') OR ");
				conds.append("(company_name LIKE '%" + key + "%') ");
				conds.append(") ");
			}
				
				if(similar.getCompany_field_id()>0) {
					conds.append(" AND (company_field_id = "+similar.getCompany_field_id()+" )");
				}	
		}
		if (!conds.toString().equalsIgnoreCase("")) {
			conds.insert(0, " WHERE ");
		}
		return conds.toString();
	}


	@Override
	public ArrayList<ResultSet> getCareerOfField() {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tblfield AS s  ");
		sql.append("WHERE (field_delete=0);");
		
		sql.append("SELECT c.career_field_id, c.career_id,c.career_name, COUNT(j.job_id) AS job_count\r\n"
				+ "FROM tblfield f\r\n"
				+ "JOIN tblcareer c ON f.field_id = c.career_field_id\r\n"
				+ "JOIN tbljob j ON c.career_id = j.job_career_id\r\n"
				+ "GROUP BY c.career_field_id, f.field_name, c.career_name;");
		
		sql.append("SELECT * FROM tbljob as j ");
		sql.append("LEFT JOIN tblcompany as c ");
		sql.append("ON j.job_company_id=c.company_id ");
		sql.append("WHERE j.job_status>0 AND job_delete=0 AND job_enable=0 ");
		sql.append("ORDER BY job_id DESC ");
		sql.append("LIMIT 3; ");
		
		sql.append("SELECT * FROM tblarticle as a ");
		sql.append("LEFT JOIN tblcategory c ON c.category_id = a.article_category_id ");
		sql.append("LEFT JOIN tblsection s ON c.category_section_id = s.section_id ");
		sql.append("ORDER BY article_visited DESC ");
		sql.append("LIMIT 2; ");
		
		System.out.println(sql);
		
		return this.getMR(sql.toString());
	}


	@Override
	public boolean follow(int com_id, int user_id) {
		// TODO Auto-generated method stub
				StringBuffer sql = new StringBuffer();
				sql.append("INSERT INTO tblcompanyfollow(");
				sql.append("company_id, user_id ) ");
				sql.append("VALUE(?, ?)");

				try {
					PreparedStatement pre = this.con.prepareStatement(sql.toString());
					pre.setInt(1, com_id);
					pre.setInt(2, user_id);
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
	public boolean unFollow(int com_id, int user_id) {
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM `tblcompanyfollow` WHERE (`company_id` = '"+com_id+"' AND `user_id`='"+user_id+"');");

		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			return this.del(pre);

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
	public boolean isExisting(int com_id, int user_id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "SELECT * FROM tblcompanyfollow WHERE (`company_id` = '"+com_id+"' AND `user_id`='"+user_id+"');";
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
	@Override
	public ArrayList<ResultSet> getCompanyFollow(int user_id) {
		String sql = "SELECT * FROM tblcompanyfollow WHERE (`user_id`='"+user_id+"');";
		return this.getMR(sql.toString());
	}


	@Override
	public ArrayList<ResultSet> totalFollow(int com_id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT company_id,COUNT(user_id) AS total FROM tblcompanyfollow WHERE company_id = "+com_id);
		sql.append(";");
		return this.getMR(sql.toString());
		
	}

	
	
}
