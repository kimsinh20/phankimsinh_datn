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
	public boolean saveJob(int job_id,int user_id);
	public boolean delJob(int job_id,int user_id);
	public boolean isExisting(int job_id,int user_id);
	// các chức năng lấy dữ liệu
	public ArrayList<ResultSet> getJob(short id);
	public ArrayList<ResultSet> getJobSave(int user_id);
	public ArrayList<ResultSet> getCareerOfField();
	public ArrayList<ResultSet> getJobs(Triplet<JobObject, Integer, Byte> infos,Pair<JOB_SOFT, ORDER> so);
	
	
}
