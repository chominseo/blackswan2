package com.blackswan.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.blackswan.web.dao.ReviewDao;
import com.blackswan.web.entity.view.ReviewView;


public class OracleReviewDao implements ReviewDao {

	@Override
	public List<ReviewView> getList(int page, int id) throws ClassNotFoundException, SQLException {
	List<ReviewView> list = new ArrayList<>();
		
		int start =(page-1)*10+1;
		int end =page+9;
		
		String sql = "SELECT fid, buy_id, title, content, regdate fROM review_view where fid ="+id;
		String url = "jdbc:oracle:thin:@192.168.0.16:1521/xepdb1";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "\"PRJ\"", "1234");
		Statement st = con.createStatement();
		
		
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			ReviewView review = new ReviewView(
					rs.getString("fid"),
					rs.getString("title"), 
					rs.getString("content"),
					rs.getInt("fid"), 
					rs.getString("regdate")
					);
					
					list.add(review);
		}
		
					
		rs.close();
		st.close();
		con.close();
		
		return list;
	}

	@Override
	public ReviewView delete(int id) throws ClassNotFoundException, SQLException {
		return null;
	}

	@Override
	public ReviewView get(int id) throws ClassNotFoundException, SQLException {
		return null;
	}

	@Override
	public int update(ReviewDao review) throws ClassNotFoundException, SQLException {
		return 0;
	}

	@Override
	public List<ReviewView> getList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReviewView> getList(int page) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(ReviewView r) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}


}
