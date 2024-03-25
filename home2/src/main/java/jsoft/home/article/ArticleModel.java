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
import jsoft.library.Utilities;
import jsoft.objects.ArticleObject;
import jsoft.objects.CategoryObject;

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

	public ArticleObject getArticleObject(int id) {
		ArticleObject item = null;
		ResultSet rs = this.a.getArticle(id);
		if (rs != null) {
			try {
				if (rs.next()) {
					item = new ArticleObject();
					item.setArticle_id(rs.getInt("article_id"));
					item.setArticle_title(rs.getString("article_title"));
					;
					item.setArticle_summary(rs.getString("article_summary"));
					item.setArticle_content(rs.getString("article_content"));
					item.setArticle_created_date(rs.getString("article_created_date"));
					item.setArticle_last_modified(rs.getString("article_last_modified"));
//					item.setArticle_image(rs.getString("article_image"));
					item.setArticle_section_id(rs.getShort("article_section_id"));
					;
					item.setArticle_category_id(rs.getShort("article_category_id"));
					;
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
		return item;
	}

	public Pair<ArrayList<ArticleObject>, ArrayList<ArticleObject>> getArticleObjects(Triplet<ArticleObject, Integer, Byte> infos) {
		ArrayList<ResultSet> res = this.a.getArticles(infos);

		return new Pair<>(this.getArticleObject(res.get(0)), this.getArticleObject(res.get(1)));
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
	public Sextet<ArrayList<ArticleObject>, ArrayList<ArticleObject>,ArrayList<CategoryObject>,HashMap<String, Integer>,Integer,ArrayList<ArticleObject>> 
	getNewsArticleObjects(Quartet<ArticleObject, Integer, Byte,Boolean> infos) {
		ArrayList<ResultSet> res = this.a.getArticles(infos);
         ArrayList<CategoryObject> cates = new ArrayList<>();
         CategoryObject cate = null;
         ResultSet rs = res.get(2);
         if(rs!=null) {
        	 try {
				while(rs.next()) {
					cate= new CategoryObject();
					cate.setCategory_id(rs.getShort("category_id"));
					cate.setCategory_name(rs.getString("category_name"));
					cates.add(cate);
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
//        			System.out.println("tag:"+tag);
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
            tags.keySet().removeAll(
        	        tags.entrySet().stream()
        	           .filter(a->a.getValue().compareTo(3)<0)
        	                   .map(e -> e.getKey()).collect(Collectors.toList()));
            int total = 0;
            if(!infos.getValue3()) {
            rs = res.get(5);
    		if(rs!= null) {
    			try {
    				if(rs.next()) {
    					total = rs.getShort("total");
    				}
    				rs.close();
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		}
           }
    		
            
		return new Sextet<>(this.getArticleObject(res.get(0)), this.getArticleObject(res.get(1)),cates,tags,total,this.getArticleObject(res.get(4)));
	}
	public Pair<ArrayList<ArticleObject>,ArrayList<CategoryObject>> getFooter(Triplet<ArticleObject, Integer, Byte> infos) {
		ArrayList<ResultSet> res = this.a.getArticles(infos);
         ArrayList<CategoryObject> cates = new ArrayList<>();
         CategoryObject cate = null;
         ResultSet rs = res.get(2);
         if(rs!=null) {
        	 try {
				while(rs.next()) {
					cate= new CategoryObject();
					cate.setCategory_id(rs.getShort("category_id"));
					cate.setCategory_name(rs.getString("category_name"));
					cates.add(cate);
					}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         }
            
		return new Pair<>(this.getArticleObject(res.get(0)),cates);
	}
	
}
