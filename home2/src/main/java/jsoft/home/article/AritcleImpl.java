package jsoft.home.article;

import java.sql.Array;
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
import jsoft.objects.ArticleObject;

public class AritcleImpl extends BasicImpl implements Article {

	public AritcleImpl(ConnectionPool cp) {
		super(cp, "Article-Home");
	}

	@Override
	public synchronized ResultSet getArticle(int id) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		StringBuilder sql2 = new StringBuilder();
		sql.append("SELECT * FROM tblarticle ");
		sql.append("LEFT JOIN tblcategory ON article_category_id=category_id ");
		sql.append("LEFT JOIN tblsection ON category_section_id=section_id ");
		sql.append("WHERE (article_id=?) AND (article_delete=0) AND (article_enable=1) ;");
		
		sql2.append("UPDATE tblarticle SET article_visited=article_visited+1 WHERE article_id = "+id).append(";");
		ArrayList<String> sqls= new ArrayList<>();
		sqls.add(sql.toString());
		sqls.add(sql2.toString());
		return this.getUpd(sqls, id);
	}

	@Override
	public synchronized ArrayList<ResultSet> getArticles(Quartet<ArticleObject, Integer, Byte,Boolean> infos) {
		// TODO Auto-generated method stub
		
		// đối tượng lưu trữ thông tin lọc kết quả
		ArticleObject similar = infos.getValue0();
		
		
		// số bản ghi đc lấy
		byte total = infos.getValue2();
		
		// vị trí bắt đầu bản ghi
			int at = (infos.getValue1()-1)*total;

			Boolean isDetail = infos.getValue3();
		
		
		StringBuffer sql = new StringBuffer();
		// danh sach bai viet moi nhat
		// lay 10 ban ghi
		sql.append("SELECT * FROM tblarticle ");
		sql.append("LEFT JOIN tblcategory ON article_category_id=category_id ");
		sql.append("LEFT JOIN tblsection ON category_section_id=section_id ");
		sql.append("WHERE (article_delete=0) AND (article_enable=1)");
		sql.append(this.createConditions(similar,true));
		sql.append("ORDER BY article_id DESC ");
		sql.append("LIMIT 5;");
		
		// danh sach bai viet xem nhieu nhat
		// lay 10 ban ghi 
		sql.append("SELECT * FROM tblarticle ");
		sql.append("LEFT JOIN tblcategory ON article_category_id=category_id ");
		sql.append("LEFT JOIN tblsection ON category_section_id=section_id ");
		sql.append("WHERE (article_delete=0) AND (article_enable=1)");
		sql.append(this.createConditions(similar,true));
		sql.append(" ORDER BY article_visited DESC ");
		sql.append("LIMIT 5;");
		
		// danh sach the loai
		sql.append("SELECT * FROM tblcategory ");
		sql.append("WHERE category_section_id=").append(similar.getArticle_section_id());
		sql.append(" ORDER BY category_name ASC ;");
		
		
		//danh sach bai viet tag
		sql.append("select article_tag from tblarticle where (article_section_id=").append(similar.getArticle_section_id()).append(");");
		
		if(isDetail) {
			sql.append("SELECT * FROM tblarticle ");
			sql.append("LEFT JOIN tblcategory ON article_category_id=category_id ");
			sql.append("LEFT JOIN tblsection ON category_section_id=section_id ");
			sql.append("WHERE (article_delete=0) AND (article_enable=1)");
			sql.append("AND (article_id="+similar.getArticle_id()+")");
		} else {
			
			// danh sách bài viết mới nhất
			sql.append("SELECT * FROM tblarticle ");
			sql.append("LEFT JOIN tblcategory ON article_category_id=category_id ");
			sql.append("LEFT JOIN tblsection ON category_section_id=section_id ");
			sql.append("WHERE (article_delete=0) AND (article_enable=1)");
			sql.append(this.createConditions(similar,isDetail));
			sql.append("ORDER BY article_id DESC ");
			sql.append("LIMIT " + at + ", " + total + ";");
			
			// tong so ban ghi
			sql.append("SELECT count(*) AS total FROM tblarticle ");
			sql.append("WHERE (article_delete=0) AND (article_enable=1)");
			sql.append(this.createConditions(similar,isDetail));
			sql.append(";");
		}
		
		System.out.println(sql);
		return this.getMR(sql.toString());
	}
	@Override
	public synchronized ArrayList<ResultSet> getArticles(Triplet<ArticleObject, Integer, Byte> infos) {
		// TODO Auto-generated method stub
		
		// đối tượng lưu trữ thông tin lọc kết quả
		ArticleObject similar = infos.getValue0();
			
		StringBuffer sql = new StringBuffer();
		// danh sach bai viet moi nhat
		// lay 10 ban ghi
		sql.append("SELECT * FROM tblarticle ");
		sql.append("LEFT JOIN tblcategory ON article_category_id=category_id ");
		sql.append("LEFT JOIN tblsection ON category_section_id=section_id ");
		sql.append("WHERE (article_delete=0) AND (article_enable=1)");
		sql.append(this.createConditions(similar,true));
		sql.append("ORDER BY article_id DESC ");
		sql.append("LIMIT 5;");
		//
		sql.append("SELECT * FROM tblarticle ");
		sql.append("LEFT JOIN tblcategory ON article_category_id=category_id ");
		sql.append("LEFT JOIN tblsection ON category_section_id=section_id ");
		sql.append("WHERE (article_delete=0) AND (article_enable=1)");
		sql.append(this.createConditions(similar,true));
		sql.append(" ORDER BY article_visited DESC ");
		sql.append("LIMIT 5;");
		// danh sach the loai
		sql.append("SELECT * FROM tblcategory ");
		sql.append("WHERE category_section_id=").append(similar.getArticle_section_id());
		sql.append(" ORDER BY category_name ASC ;");
			
//		System.out.println(sql);
		return this.getMR(sql.toString());
	}
	private StringBuilder createConditions(ArticleObject similar,Boolean iSDetail) {
		StringBuilder tmp = new StringBuilder();
		if(similar!=null && !iSDetail ) {
			short sid = similar.getArticle_section_id();
			if(sid==0) {
				sid = similar.getCategory_id();
			}
			if(sid==0) {
				sid=similar.getSection_id();
			}
			if(sid>0) {
				tmp.append("(article_section_id=").append(sid).append(")");
			}
			short cid=similar.getArticle_category_id();
			if(cid==0) {
				cid=similar.getCategory_id();
			}
			if(cid>0) {
				if(!tmp.toString().equalsIgnoreCase("")) {
					tmp.append(" AND ");
				}
				tmp.append("(article_category_id=").append(cid).append(")");
			}
			if(!iSDetail) {
			String key = similar.getArticle_tag();
			if(key!=null && !key.equalsIgnoreCase("")) {
				tmp.append(" AND (article_tag LIKE '%"+key+"%')");
			} 
			}
			
		}
		if(!tmp.toString().equalsIgnoreCase("")) {
			tmp.insert(0, " AND ");
		}
		return tmp;
	}

	public static void main(String[] args) {
	
	}
}

