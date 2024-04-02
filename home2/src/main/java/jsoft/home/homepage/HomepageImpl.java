package jsoft.home.homepage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.ConnectionPoolImpl;
import jsoft.home.basic.BasicImpl;
import jsoft.library.ORDER;
import jsoft.objects.CareerObject;
import jsoft.objects.SectionObject;
import jsoft.objects.UserObject;

public class HomepageImpl extends BasicImpl implements Homepage {

	public HomepageImpl(ConnectionPool cp) {
		super(cp, "Career");
		// TODO Auto-generated constructor stub
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
	public ArrayList<ResultSet> getCategories(Triplet<CareerObject, Integer, Byte> infos) {
		// TODO Auto-generated method stub
		CareerObject similar = infos.getValue0();

		// vị trí bắt đầu lấy bản ghi
		int at = infos.getValue1();

		// Số bản ghi được lấy trong một lần
		byte total = infos.getValue2();

		StringBuffer sql = new StringBuffer();

		sql.append("SELECT career_field_id,career_id,career_name, COUNT(*) AS 'job_count' ");
		sql.append("FROM tblCareer ");
		sql.append(this.createConditions(similar));
		sql.append(" GROUP BY career_field_id ");
		sql.append("ORDER BY job_count DESC ");
		sql.append("LIMIT 5;");
		
		sql.append("SELECT * ");
		sql.append("FROM tblcompany ");
		sql.append("ORDER BY company_subscribe DESC ");
		sql.append("LIMIT 6; ");
		
		sql.append("SELECT job_company_id,count(*) as total FROM tbljob group by job_company_id ; ");
		
		sql.append("SELECT * FROM tbljob as j ");
		sql.append("LEFT JOIN tblcompany as c ");
		sql.append("ON j.job_company_id=c.company_id ");
		sql.append("WHERE j.job_status=1 AND job_delete=0 AND job_enable=0 ");
		sql.append("ORDER BY job_id DESC ");
		sql.append("LIMIT 9; ");
		
		sql.append("SELECT * FROM tblarticle as a ");
		sql.append("LEFT JOIN tblcategory c ON c.category_id = a.article_category_id ");
		sql.append("LEFT JOIN tblsection s ON c.category_section_id = s.section_id ");
		sql.append("ORDER BY article_visited DESC ");
		sql.append("LIMIT 3; ");
		
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
				conds.append(")");
			} 
				
		}
		if (!conds.toString().equalsIgnoreCase("")) {
			conds.insert(0, " WHERE ");
		}
		return conds.toString();
	}
	
}
