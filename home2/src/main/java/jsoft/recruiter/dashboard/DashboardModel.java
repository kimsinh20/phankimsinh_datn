package jsoft.recruiter.dashboard;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Sextet;
import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.library.ORDER;
import jsoft.objects.ArticleObject;
import jsoft.objects.CareerObject;
import jsoft.objects.CompanyObject;
import jsoft.objects.FieldObject;
import jsoft.objects.JobObject;
import jsoft.objects.SectionObject;
import jsoft.objects.UserObject;

public class DashboardModel {
	private Dashboard c;
	public DashboardModel(ConnectionPool cp) {
		this.c = new DashboardImpl(cp);
	}
	
	public ConnectionPool getCP() {
		return this.c.getCP();
	}

	public void releaseConnection() {
		this.c.releaseConnection();
	}
	
}
