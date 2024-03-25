package jsoft.home.article;

import java.util.ArrayList;
import java.util.HashMap;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Sextet;
import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.objects.ArticleObject;
import jsoft.objects.CategoryObject;

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
	public ArticleObject getArticleObject(int id) {
		return this.am.getArticleObject(id);
	}
//	----------------------------------------------
	public ArrayList<String> viewPostGrid(Triplet<ArticleObject, Integer, Byte> infos) {
		Pair<ArrayList<ArticleObject>, ArrayList<ArticleObject>> datas = this.am.getArticleObjects(infos);
		return ArticleLibrary.viewPostGrid(datas);
	}
	public ArrayList<String> viewNews(Quartet<ArticleObject, Integer, Byte,Boolean> infos) {
		Sextet<ArrayList<ArticleObject>, ArrayList<ArticleObject>,ArrayList<CategoryObject>,HashMap<String, Integer>,Integer,ArrayList<ArticleObject>> datas = this.am.getNewsArticleObjects(infos);
		return ArticleLibrary.viewNews(datas,infos);
	}
	public ArrayList<String> viewNewsDetail(Quartet<ArticleObject, Integer, Byte,Boolean> infos) {
		Sextet<ArrayList<ArticleObject>, ArrayList<ArticleObject>,ArrayList<CategoryObject>,HashMap<String, Integer>,Integer,ArrayList<ArticleObject>> datas = this.am.getNewsArticleObjects(infos);
		return ArticleLibrary.viewDetail(datas,infos);
	}
	public String viewFooter(Triplet<ArticleObject, Integer, Byte> infos) {
		Pair<ArrayList<ArticleObject>,ArrayList<CategoryObject>> datas = this.am.getFooter(infos);
		return ArticleLibrary.ViewFooter(datas).toString();
	}
}
