package jsoft.recruiter.dashboard;

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

public class DashboardControl {
	private DashboardModel cm;

	public DashboardControl(ConnectionPool cp) {
		this.cm = new DashboardModel(cp);
	}

	public ConnectionPool getCP() {
		return this.cm.getCP();
	}

	public void releaseConnection() {
		this.cm.releaseConnection();
	}
	
}
