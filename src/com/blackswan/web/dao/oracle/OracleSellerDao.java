package com.blackswan.web.dao.oracle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.blackswan.web.dao.FundingDao;
import com.blackswan.web.dao.SellerDao;
import com.blackswan.web.entity.Funding;
import com.blackswan.web.entity.SelEvent;
import com.blackswan.web.entity.Seller;
import com.blackswan.web.entity.view.FundingView;

public class OracleSellerDao implements SellerDao{


	
@Override
public int insert(Seller seller) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	int result = 0;

	String sql = "insert into seller(id, company_tel, company_email, company_name, "
			+ " company_img, company_web, company_comi, company_reg_num, company_reg,"
			+ " company_pass, company_boss, company_bossemail)"
			+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	String url = "jdbc:oracle:thin:@222.111.247.47:1522/xepdb1";
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection(url, "\"PRJ\"", "1234");

	PreparedStatement st = con.prepareStatement(sql); // preparedStatement : 실행 전에 statement를 준비, prepare로 준비할 경우
														// st.executeUpdate에 sql 적지 않기
	st.setInt(1, seller.getId());
	st.setInt(2, seller.getCompanyTel());
	st.setString(3, seller.getCompanyEmail());
	st.setString(4, seller.getCompanyName());
	st.setString(5, seller.getCompanyImg());
	st.setString(6, seller.getCompanyWeb());
	st.setInt(7,seller.getCompanyComi());
	st.setInt(8, seller.getCompanyRegNum());
	st.setString(9, seller.getCompanyReg());
	st.setString(10, seller.getCompanyPass());
	st.setString(11, seller.getCompanyBoss());
	st.setString(12, seller.getCompanyBossEmail());


	result = st.executeUpdate();

	st.close();
	con.close();

	
	return result;
}

@Override
public int getCount() throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int getCount(String field, String query) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public List<Seller> getList() throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<Seller> getList(int page) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<Seller> getList(int page, String field, String query) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	return null;
}






@Override
public int getLastId() throws ClassNotFoundException, SQLException {
	return 0;
	// TODO Auto-generated method stub
	
}

@Override
public Seller get(int id) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	Seller seller =null;
	String sql ="select * from seller where id = ?";
	
	String url = "jdbc:oracle:thin:@222.111.247.47:1522/xepdb1";
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection(url, "\"PRJ\"", "1234");
	PreparedStatement st = con.prepareStatement(sql);
	  
	st.setInt(1, id);
	
	
	ResultSet rs = st.executeQuery();
	
	while (rs.next()) {
		seller = new Seller(
					rs.getInt("id"),
					rs.getInt("company_tel"),
					rs.getString("company_email"),
					rs.getString("company_name"),
					rs.getString("company_img"),
					rs.getString("company_web"), 
					rs.getInt("company_comi"), 
					rs.getInt("company_reg_num"),
					rs.getString("company_reg"),
					rs.getString("company_pass"), 
					rs.getString("company_boss"),
					rs.getString("company_bossemail")
				);

	}

	rs.close();
	st.close();
	con.close();
	
	return seller;
	
//	select id, company_tel, company_email, company_name, "  
//			+ " company_img, company_web, company_comi, company_reg_num, company_reg, "  
//			+ " company_pass, company_boss, company_bossemail "
	
}

@Override
public int update(Seller seller) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int delete(int id) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	return 0;
}


	


}
