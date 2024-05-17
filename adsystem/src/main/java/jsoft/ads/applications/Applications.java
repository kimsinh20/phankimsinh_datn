package jsoft.ads.applications;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.javatuples.Pair;
import org.javatuples.Quartet;

import jsoft.ShareControl;
import jsoft.library.ORDER;
import jsoft.objects.ApplicationsObject;
import jsoft.objects.CareerObject;
import jsoft.objects.UserObject;

public interface Applications extends ShareControl {
	// các chức năng cập nhật
	public boolean addApp(ApplicationsObject item);

	public boolean editApp(ApplicationsObject item,APP_EDIT_TYPE et);

	public boolean delApp(ApplicationsObject item);

	// các chức năng lấy dữ liệu
	public ArrayList<ResultSet> getApp(short id, UserObject userLogined);

	public ArrayList<ResultSet> getApps(Quartet<ApplicationsObject, Integer, Byte, UserObject> infos, Pair<APP_SOFT, ORDER> so);
}
