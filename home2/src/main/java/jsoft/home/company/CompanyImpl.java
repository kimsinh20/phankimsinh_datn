package jsoft.home.company;

import java.sql.ResultSet;
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
		super(cp, "Job");
		// TODO Auto-generated constructor stub
	}


	@Override
	public ArrayList<ResultSet> getCompany(short id) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tblJob j "); // cate la con cua section
		sql.append("LEFT JOIN tblcareer f ON j.job_career_id = f.career_id ");
		sql.append("LEFT JOIN tblcompany p ON p.company_id = j.job_company_id ");
		sql.append("LEFT JOIN tblfield a ON a.field_id = f.career_field_id ");
		sql.append("WHERE (j.job_status>0) AND (j.job_delete=0) AND (j.job_id=" + id + ");");

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


	
	
}
