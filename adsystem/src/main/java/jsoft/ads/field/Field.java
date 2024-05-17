package jsoft.ads.field;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.javatuples.Pair;
import org.javatuples.Quartet;

import jsoft.ShareControl;
import jsoft.library.ORDER;
import jsoft.objects.FieldObject;
import jsoft.objects.UserObject;

public interface Field extends ShareControl {
	// các chức năng cập nhật
	public boolean addField(FieldObject item);

	public boolean editField(FieldObject item,FIELD_EDIT_TYPE et);

	public boolean delField(FieldObject item);

	
	// các chức năng lấy dữ liệu
	public  ArrayList<ResultSet> getField(short id, UserObject userLogined);

	public ArrayList<ResultSet> getFields(Quartet<FieldObject, Integer, Byte,UserObject> infos, Pair<FIELD_SOFT, ORDER> so);
}
