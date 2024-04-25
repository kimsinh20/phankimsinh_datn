package jsoft.home.homepage;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Triplet;

import jsoft.ShareControl;
import jsoft.library.ORDER;
import jsoft.objects.CareerObject;
import jsoft.objects.UserObject;

public interface Homepage extends ShareControl {
	
	// các chức năng lấy dữ liệu
	public ArrayList<ResultSet> getCareer(short id, UserObject userLogined);

	public ArrayList<ResultSet> getCategories(Triplet<CareerObject, Integer, Byte> infos);
	public ArrayList<ResultSet> getJobSave(int user_id);
	public ArrayList<ResultSet> getDataFooter();
	public ArrayList<ResultSet> getCareerSearch(String key);
	
}
