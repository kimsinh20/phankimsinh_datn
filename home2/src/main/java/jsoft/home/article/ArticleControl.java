package jsoft.home.article;

import java.util.ArrayList;
import java.util.HashMap;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Sextet;
import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.home.company.COMPANY_SOFT;
import jsoft.home.company.CompanyLibrary;
import jsoft.library.ORDER;
import jsoft.objects.ArticleObject;
import jsoft.objects.CategoryObject;
import jsoft.objects.CompanyObject;
import jsoft.objects.FieldObject;
import jsoft.objects.SectionObject;

public class ArticleControl {
	private ArticleModel am;

	public ArticleControl(ConnectionPool cp) {
		this.am = new ArticleModel(cp);
	}

	public ConnectionPool getCP() {
		return this.am.getCP();
	}

	public void releaseConnection() {
		this.am.relaseConnection();
	}

//	------------------------------------------
	
//	---------------------------------------------
	public Quartet<ArticleObject, ArrayList<ArticleObject>, ArrayList<SectionObject>,HashMap<String,Integer>> getArticleObject(int id) {
		return this.am.getArticleObject(id);
	}
//	----------------------------------------------
	
	public Triplet<ArrayList<ArticleObject>, ArrayList<ArticleObject>,ArrayList<SectionObject>> viewArticleBolg(Triplet<ArticleObject, Integer, Byte> infos) {
		Triplet<ArrayList<ArticleObject>,ArrayList<ArticleObject>,ArrayList<SectionObject>> datas = this.am.getArticleBolg(infos);
		return datas;
	}
	public ArrayList<String> ViewBlogsList(Triplet<ArticleObject, Integer, Byte> infos,Pair<ARTICLE_SOFT, ORDER> so,String url,int page) {
		Triplet<ArrayList<ArticleObject>,Integer,ArrayList<CategoryObject>> data = this.am.getArticleObjects(infos,so );
		ArrayList<String> rs = new ArrayList<>();
		rs.add(ArticleLibrary.viewList(data.getValue0(),page,data.getValue1(),url,infos.getValue2()));
		
		if(infos.getValue0().getArticle_category_id()>0) {
			rs.add(ArticleLibrary.cateOption(data.getValue2(),infos.getValue0().getArticle_category_id()));
		} else {
			rs.add(ArticleLibrary.cateOption(data.getValue2(),0));
		}
		rs.add(ArticleLibrary.sortView(url));
		if(data.getValue2().size()>0) {
			rs.add(data.getValue2().get(0).getSection_name());
		} else {
			rs.add("");
		}
		
	   
		return rs;
	}
}
