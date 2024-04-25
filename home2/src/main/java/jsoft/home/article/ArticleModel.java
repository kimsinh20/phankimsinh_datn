package jsoft.home.article;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Sextet;
import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.library.ORDER;
import jsoft.library.Utilities;
import jsoft.objects.ArticleObject;
import jsoft.objects.CategoryObject;
import jsoft.objects.SectionObject;

public class ArticleModel {
	private Article a;

	public ArticleModel(ConnectionPool cp) {
		this.a = new AritcleImpl(cp);
	}

	public ConnectionPool getCP() {
		return this.a.getCP();
	}

	public void relaseConnection() {
		this.a.releaseConnection();
	}

	public Quartet<ArticleObject, ArrayList<ArticleObject>, ArrayList<SectionObject>,HashMap<String, Integer>> getArticleObject(int id) {
		ArticleObject item = null;
		ArrayList<ResultSet> res = this.a.getArticle(id);
		ResultSet rs = res.get(0);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new ArticleObject();
					item.setArticle_id(rs.getInt("article_id"));
					item.setArticle_title(rs.getString("article_title"));
					
					item.setArticle_summary(rs.getString("article_summary"));
					item.setArticle_content(jsoft.library.Utilities.decode(rs.getString("article_content")));
					item.setArticle_created_date(rs.getString("article_created_date"));
					item.setArticle_last_modified(rs.getString("article_last_modified"));
				    item.setArticle_image(rs.getString("article_image"));
					item.setArticle_section_id(rs.getShort("article_section_id"));
					item.setArticle_source(rs.getString("article_source"));
					item.setArticle_category_id(rs.getShort("article_category_id"));
					item.setSection_name(rs.getString("section_name"));
					item.setCategory_name(rs.getString("category_name"));
					item.setArticle_visited(rs.getShort("article_visited"));
					item.setArticle_author_name(rs.getString("article_author_name"));
					item.setArticle_enable(rs.getBoolean("article_enable"));
					item.setArticle_url_link(rs.getString("article_url_link"));
					item.setArticle_tag(rs.getString("article_tag"));
					item.setArticle_fee(rs.getInt("article_fee"));
					item.setArticle_isfee(rs.getBoolean("article_isfee"));
					item.setArticle_delete(rs.getBoolean("article_delete"));
					item.setArticle_modified_author_name(rs.getString("article_modified_author_name"));
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
        ArrayList<SectionObject> sections = new ArrayList<>();
        SectionObject s = null;
         rs = res.get(2);
        if(rs!=null) {
       	 try {
				while(rs.next()) {
					s= new SectionObject();
					s.setSection_id(rs.getShort("section_id"));
					s.setSection_name(rs.getString("section_name"));
					sections.add(s);
					}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        HashMap<String, Integer> tags = new HashMap<>();
        rs = res.get(3);
        String tag;
        String[] tagList;
        if(rs!=null) {
       	 try {
       		while(rs.next()) {
       			if(rs.getString("article_tag")!=null) {
       			tag =Utilities.decode(rs.getString("article_tag")).toLowerCase();
       			} else {
       			tag = "";
       			}
//       			System.out.println("tag:"+tag);
       			tagList = tag.split(",");
       			for(String word:tagList) {
       				if(!"".equalsIgnoreCase(word)) {
       					word = word.trim();
       				  if(tags.containsKey(word)) {
       					  tags.replace(word, tags.get(word)+1);
       				  } else {
       					  tags.put(word, 1);
       				  }
       				}
       			}
					}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        // loai bo tag co so lan xuat hien < 3
//           tags.keySet().removeAll(
//       	        tags.entrySet().stream()
//       	           .filter(a->a.getValue().compareTo(3)<0)
//       	                   .map(e -> e.getKey()).collect(Collectors.toList()));
		return new Quartet<>(item,this.getArticleObject(res.get(1)),sections,tags);
	}

	public Triplet<ArrayList<ArticleObject>,Integer,ArrayList<CategoryObject>> getArticleObjects(Triplet<ArticleObject, Integer, Byte> infos,Pair<ARTICLE_SOFT, ORDER> so) {
		ArrayList<ResultSet> res = this.a.getArticles(infos,so);
		
		ResultSet rs = res.get(1);
		Integer total = 0;
		if (rs != null) {
			try {
				if (rs.next()) {
					total = rs.getInt("total");
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		 rs = res.get(2);
		ArrayList<CategoryObject> cates = new ArrayList<>();
		CategoryObject item = null;
		if (rs != null) {
			try {
				while (rs.next()) {
					item = new CategoryObject();
					item.setCategory_id(rs.getShort("category_id"));
					item.setCategory_name(rs.getString("category_name"));
					item.setSection_name(rs.getString("section_name"));
					cates.add(item);
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return new Triplet<>(this.getArticleObject(res.get(0)),total,cates);
	}
	

	private ArrayList<ArticleObject> getArticleObject(ResultSet rs) {
		ArrayList<ArticleObject> items = new ArrayList<>();
		ArticleObject item = null;
		if (rs != null) {
			try {
				while (rs.next()) {
					item = new ArticleObject();
					item.setArticle_id(rs.getInt("article_id"));
					item.setArticle_title(rs.getString("article_title"));
					item.setArticle_summary(rs.getString("article_summary"));
					item.setArticle_content(rs.getString("article_content"));
					item.setArticle_created_date(rs.getString("article_created_date"));
					item.setArticle_last_modified(rs.getString("article_last_modified"));
					item.setArticle_image(rs.getString("article_image"));
					item.setArticle_section_id(rs.getShort("article_section_id"));
					item.setArticle_category_id(rs.getShort("article_category_id"));
					item.setArticle_visited(rs.getShort("article_visited"));
					item.setArticle_author_name(rs.getString("article_author_name"));
					item.setArticle_enable(rs.getBoolean("article_enable"));
					item.setArticle_url_link(rs.getString("article_url_link"));
					item.setArticle_tag(rs.getString("article_tag"));
					item.setArticle_fee(rs.getInt("article_fee"));
					item.setArticle_source(rs.getString("article_source"));
					item.setArticle_isfee(rs.getBoolean("article_isfee"));
					item.setArticle_delete(rs.getBoolean("article_delete"));
					item.setArticle_modified_author_name(rs.getString("article_modified_author_name"));
					item.setCategory_name(rs.getString("category_name"));
					item.setSection_name(rs.getString("section_name"));
					item.setArticle_section_id(rs.getShort("article_section_id"));
					
					items.add(item);
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return items;
	}
	
	
	public Triplet<ArrayList<ArticleObject>, ArrayList<ArticleObject>,ArrayList<SectionObject>> 
	getArticleBolg(Triplet<ArticleObject, Integer, Byte> infos) {
		ArrayList<ResultSet> res = this.a.getArticlesBlog(infos);
         ArrayList<SectionObject> sections = new ArrayList<>();
         SectionObject s = null;
         ResultSet rs = res.get(2);
         if(rs!=null) {
        	 try {
				while(rs.next()) {
					s= new SectionObject();
					s.setSection_id(rs.getShort("section_id"));
					s.setSection_name(rs.getString("section_name"));
					sections.add(s);
					}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         }
    		
            
		return new Triplet<>(this.getArticleObject(res.get(0)), this.getArticleObject(res.get(1)),sections);
	}
}
