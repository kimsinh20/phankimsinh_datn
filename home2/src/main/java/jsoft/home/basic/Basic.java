package jsoft.home.basic;

import java.sql.*;
import jsoft.*;
import java.util.*;

public interface Basic extends ShareControl {
	//PreparedStatement pre - đã đc biên dịch và truyền đầy đủ giá trị( các đối tượng khác nhau về thuộc tính nên dùng PreparedStatement )
	
	public ResultSet get(String sql, int id);

	public ResultSet getUpd(ArrayList<String> sql,int id);
	
	public ResultSet get(String sql, int id, String pass);
	
	public ResultSet gets(String sql);
	
	public ResultSet[] gets(String[] sql);
	
	// thuc hien nhieu SELECT trong 1 lan bien dich
	public ArrayList<ResultSet> getMR(String multiSelect);
	

}
