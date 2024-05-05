package jsoft.recruiter.dashboard;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Triplet;

import jsoft.ConnectionPool;
import jsoft.ConnectionPoolImpl;
import jsoft.home.basic.BasicImpl;
import jsoft.library.ORDER;
import jsoft.objects.CareerObject;
import jsoft.objects.SectionObject;
import jsoft.objects.UserObject;

public class DashboardImpl extends BasicImpl implements Dashboard {

	public DashboardImpl(ConnectionPool cp) {
		super(cp, "dashboard");
		// TODO Auto-generated constructor stub
	}



}
