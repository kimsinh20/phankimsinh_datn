package jsoft.home.job;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.javatuples.Pair;
import org.javatuples.Triplet;

import jsoft.ShareControl;
import jsoft.library.ORDER;
import jsoft.objects.JobObject;
import jsoft.objects.UserObject;

public interface Job extends ShareControl {
	
	// các chức năng lấy dữ liệu
	public ArrayList<ResultSet> getJob(short id, UserObject userLogined);

	public ArrayList<ResultSet> getJobs(Triplet<JobObject, Integer, Byte> infos,Pair<JOB_SOFT, ORDER> so);
	
	
}
