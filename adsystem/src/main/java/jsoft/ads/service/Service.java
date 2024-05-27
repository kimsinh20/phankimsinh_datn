package jsoft.ads.service;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.javatuples.Pair;
import org.javatuples.Quartet;

import jsoft.ShareControl;
import jsoft.library.ORDER;
import jsoft.objects.CareerObject;
import jsoft.objects.UserObject;

public interface Service extends ShareControl {
	// các chức năng cập nhật
	public boolean delService(int id);

	// các chức năng lấy dữ liệu
	public ArrayList<ResultSet> getService(short id, UserObject userLogined);

	public ArrayList<ResultSet> getServices();
}
