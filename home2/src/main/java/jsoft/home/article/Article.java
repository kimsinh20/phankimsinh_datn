package jsoft.home.article;

import jsoft.ShareControl;
import jsoft.library.ORDER;
import jsoft.objects.*;
import java.sql.*;
import java.util.ArrayList;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Triplet;

public interface Article extends ShareControl {
	// các chức năng cập nhật
	// các chức năng lấy dữ liệu
	public ResultSet getArticle(int id);

//	public ResultSet getArticles(ArticleObject similar, int at, byte total);
	public ArrayList<ResultSet> getArticles(Triplet<ArticleObject, Integer, Byte> infos);
	public ArrayList<ResultSet> getArticles(Quartet<ArticleObject, Integer, Byte,Boolean> infos);
}
