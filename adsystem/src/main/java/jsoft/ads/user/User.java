package jsoft.ads.user;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Triplet;

import jsoft.ShareControl;
import jsoft.library.ORDER;
import jsoft.objects.ContactObject;
import jsoft.objects.ServiceObject;
import jsoft.objects.UserObject;

public interface User extends ShareControl {
	// các chức năng cập nhật
	public boolean addUser(UserObject item,USER_TYPE et);

	public boolean editUser(UserObject item,USER_EDIT_TYPE et);

	public boolean delUser(UserObject item);
	
	public ResultSet getService(int id);
	
	public boolean addContact(ContactObject c);
	
	public ArrayList<ResultSet> getDashboard();
	public ArrayList<ResultSet> getDashboardEmployer(int user_id);
	
	public boolean addOrder(int order_id,ServiceObject sv , UserObject u);

	// các chức năng lấy dữ liệu
	public ResultSet getUser(int id);

	public ResultSet getEmployer(String username, String userpass);
	
	public ResultSet getUser(String username, String userpass);
	
	public ResultSet getCheckPass(UserObject item);

	public boolean updateLogined(UserObject item);

//	public ResultSet getUsers(UserObject similar, int at, byte total);
//	public ResultSet getUsers(UserObject similar, Integer at, Byte total);

	public ArrayList<ResultSet> getUsers(Quartet<UserObject, Integer, Byte,USER_TYPE> infos, Pair<USER_SOFT, ORDER> so);
}
