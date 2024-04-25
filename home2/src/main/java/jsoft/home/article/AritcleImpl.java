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
	public  ArrayList<ResultSet> getArticle(int id) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT * FROM tblarticle ");
		sql.append("LEFT JOIN tblcategory ON article_category_id=category_id ");
		sql.append("LEFT JOIN tblsection ON category_section_id=section_id ");
		sql.append("WHERE (article_id="+id+") AND (article_delete=0) AND (article_enable=1) ; ");
		
		sql.append("SELECT * FROM tblarticle as a ");
		sql.append("LEFT JOIN tblcategory c ON c.category_id = a.article_category_id ");
		sql.append("LEFT JOIN tblsection s ON c.category_section_id = s.section_id ");
		sql.append("ORDER BY article_id DESC ");
		sql.append("LIMIT 5; ");
		
		
		sql.append("SELECT * FROM web_data.tblsection where section_id>20; ");
		
		sql.append("select article_tag from tblarticle where article_section_id>20; ");
		
		System.out.println(sql.toString());
//		sql2.append("UPDATE tblarticle SET article_visited=article_visited+1 WHERE article_id = "+id).append(";");
//		ArrayList<String> sqls= new ArrayList<>();
		return this.getMR(sql.toString());
	}

	@Override
	public  ArrayList<ResultSet> getArticles(Triplet<ArticleObject, Integer, Byte> infos,Pair<ARTICLE_SOFT, ORDER> so) {
		// TODO Auto-generated method stub
		
		// đối tượng lưu trữ thông tin lọc kết quả
		ArticleObject similar = infos.getValue0();
			
		// vị trí bắt đầu lấy bản ghi
		int at = infos.getValue1();

		// Số bản ghi được lấy trong một lần
		byte total = infos.getValue2();
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT * FROM tblarticle ");
		sql.append("LEFT JOIN tblcategory ON article_category_id=category_id ");
		sql.append("LEFT JOIN tblsection ON category_section_id=section_id ");
		sql.append("WHERE (article_delete=0) AND (article_enable=1)");
		sql.append(this.createConditions(similar));
		switch (so.getValue0()) {
		case VISITED:
			sql.append("ORDER BY article_visited ").append(so.getValue1().name());
			break;
		case DATE:
			sql.append("ORDER BY article_id ").append(so.getValue1().name());
			break;
		case TITLE:
			sql.append("ORDER BY article_title ").append(so.getValue1().name());
			break;
		default:
			sql.append("ORDER BY article_id ").append(so.getValue1().name());

		}
		
		sql.append(" LIMIT ").append(at).append(", ").append(total).append(";");
		
		sql.append("SELECT COUNT(article_id) as 'total' FROM tblarticle ");
		sql.append("LEFT JOIN tblcategory ON article_category_id=category_id ");
		sql.append("LEFT JOIN tblsection ON category_section_id=section_id ");
		sql.append("WHERE (article_delete=0) AND (article_enable=1)");
		sql.append(createConditions(similar));
		sql.append(";");
		
		// danh sach the loai
		sql.append("SELECT * FROM tblcategory ");
		sql.append("LEFT JOIN tblsection ON category_section_id=section_id ");
		sql.append("WHERE category_section_id=").append(similar.getArticle_section_id());
		sql.append(" ORDER BY category_name ASC ;");
			
		System.out.println(sql);
		return this.getMR(sql.toString());
	}
	private StringBuilder createConditions(ArticleObject similar) {
		StringBuilder tmp = new StringBuilder();
		if(similar!=null) {
			short sid = similar.getArticle_section_id();
			if(sid==0) {
				sid = similar.getCategory_id();
			}
			if(sid==0) {
				sid=similar.getSection_id();
			}
			if(sid>0) {
				tmp.append("(article_section_id=").append(sid).append(") ");
			}
			short cid=similar.getArticle_category_id();
			if(cid==0) {
				cid=similar.getCategory_id();
			}
			if(cid>0) {
				if(!tmp.toString().equalsIgnoreCase("")) {
					tmp.append(" AND ");
				}
				tmp.append("(article_category_id=").append(cid).append(") ");
			}
			
			String tag = similar.getArticle_tag();
			if(tag!=null && !tag.equalsIgnoreCase("")) {
				if(!tmp.toString().equalsIgnoreCase("")) {
					tmp.append(" AND ");
				}
				tmp.append(" (article_tag LIKE '%"+tag+"%') ");
			}
			
			String key = similar.getArticle_title();
			if(key!=null && !key.equalsIgnoreCase("")) {
				if(!tmp.toString().equalsIgnoreCase("")) {
					tmp.append(" AND ");
				}
				tmp.append(" ((article_title LIKE '%"+key+"%') OR (article_tag LIKE '%"+key+"%')) ");
			}
			
		}
		if(!tmp.toString().equalsIgnoreCase("")) {
			tmp.insert(0, " AND ");
		}
		return tmp;
	}

	@Override
	public ArrayList<ResultSet> getArticlesBlog(Triplet<ArticleObject, Integer, Byte> infos) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tblarticle as a ");
		sql.append("LEFT JOIN tblcategory c ON c.category_id = a.article_category_id ");
		sql.append("LEFT JOIN tblsection s ON c.category_section_id = s.section_id ");
		sql.append("ORDER BY article_visited DESC ");
		sql.append("LIMIT 3; ");
		
		sql.append("SELECT * FROM tblarticle as a ");
		sql.append("LEFT JOIN tblcategory c ON c.category_id = a.article_category_id ");
		sql.append("LEFT JOIN tblsection s ON c.category_section_id = s.section_id ; ");
		
		sql.append("SELECT * FROM web_data.tblsection where section_id>20; ");
		
		System.out.println(sql.toString());
		return this.getMR(sql.toString());
	}
}

