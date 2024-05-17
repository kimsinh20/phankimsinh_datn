package jsoft.ads.career;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.javatuples.Pair;
import org.javatuples.Quartet;

import jsoft.ShareControl;
import jsoft.library.ORDER;
import jsoft.objects.CareerObject;
import jsoft.objects.UserObject;

public interface Career extends ShareControl {
	// các chức năng cập nhật
	public boolean addCareer(CareerObject item);

	public boolean editCareer(CareerObject item,CAREER_EDIT_TYPE et);

	public boolean delCareer(CareerObject item);

	// các chức năng lấy dữ liệu
	public ArrayList<ResultSet> getCareer(short id, UserObject userLogined);

	public ArrayList<ResultSet> getCategories(Quartet<CareerObject, Integer, Byte, UserObject> infos, Pair<CAREER_SOFT, ORDER> so);
}
