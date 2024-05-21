package jsoft.home.user;

import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.ConnectionPoolImpl;
import jsoft.objects.ClientObject;
import jsoft.objects.UserObject;

public class UserControl {
	private UserModel um;

	public UserControl(ConnectionPool cp) {
		this.um = new UserModel(cp);
	}

	public ConnectionPool getCP() {
		return this.um.getCP();
	}

	public void releaseConnection() {
		this.um.releaseConnection();
	}
	
	public boolean signup(UserObject item) {
		return this.um.signup(item);
	}
	
	public boolean editUser(UserObject item,USER_EDIT_TYPE et) {
		return this.um.editUser(item,et);
	}
//	---------------------------------------------
	public ClientObject getUserObject(int id) {
		return this.um.getUserObject(id);
	}

	public UserObject getUserObject(String username, String userpass) {
		return this.um.getUserObject(username, userpass);
	}
	public UserObject getCheckPass(int id,String newPass) {
		UserObject eUser = new UserObject();
		eUser.setUser_id(id);
		eUser.setUser_pass(newPass);
		return this.um.getCheckpass(eUser);
	}
   
	public boolean getUpdateLogined(UserObject item) {
		return this.um.getUpdatelogined(item);
	}



	public static void main(String[] args) {
		ConnectionPool cp = new ConnectionPoolImpl();
		UserControl uc = new UserControl(cp);

		Triplet<UserObject, Integer, Byte> infos = new Triplet<>(null, 0, (byte) 15);

//		ArrayList<String> views = uc.viewUser(infos, new Pair<>(USER_SOFT.NAME, ORDER.ASC));

		uc.releaseConnection();
//		System.out.println(views);
	}
}
