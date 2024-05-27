package jsoft.ads.service;

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

public class ServiceImpl extends BasicImpl implements Service {

	public ServiceImpl(ConnectionPool cp) {
		super(cp, "Career");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean delService(int id) {
		// TODO Auto-generated method stub

		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM tblCareer WHERE (Career_id=?);");

		try {
			PreparedStatement pre = this.con.prepareStatement(sql.toString());
			pre.setInt(1, id);
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

	


	@Override
	public ArrayList<ResultSet> getService(short id, UserObject userLogined) {
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
	public ArrayList<ResultSet> getServices() {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tbl_order_detail as d left join tbl_order as o on d.order_id = o.order_id left join tblservice as s on d.service_id = s.service_id left join tbluser as u on u.user_id = o.user_id ;");
		sql.append("SELECT COUNT(*) as total FROM tbl_order_detail as d left join tbl_order as o on d.order_id = o.order_id left join tblservice as s on d.service_id = s.service_id left join tbluser as u on u.user_id = o.user_id;");
		sql.append("select YEAR(str_to_date(order_created_at,'%d/%m/%Y')) as 'year', MONTH(str_to_date(order_created_at,'%d/%m/%Y')) as 'month',sum(service_price) as 'totalPrice' from tbl_order_detail as d left join tbl_order as o on d.order_id = o.order_id group by YEAR(str_to_date(order_created_at,'%d/%m/%y')), MONTH(str_to_date(order_created_at,'%d/%m/%Y')) order by YEAR(str_to_date(order_created_at,'%d/%m/%Y')), MONTH(str_to_date(order_created_at,'%d/%m/%Y')) asc;");
		return this.getMR(sql.toString());
	}

	
}
