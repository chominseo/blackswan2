package com.blackswan.web.dao;

import java.sql.SQLException;
import java.util.List;

import com.blackswan.web.entity.Funding;
import com.blackswan.web.entity.Notice;
import com.blackswan.web.entity.Seller;
import com.blackswan.web.entity.view.FundingView;
import com.blackswan.web.entity.view.NoticeView;

public interface SellerDao {
	
	int getCount() throws ClassNotFoundException, SQLException;
	int getCount(String field, String query) throws ClassNotFoundException, SQLException;
	
	List<Seller> getList() throws ClassNotFoundException, SQLException;
	List<Seller> getList(int page) throws ClassNotFoundException, SQLException;
	List<Seller> getList(int page, String field, String query) throws ClassNotFoundException, SQLException;
	
	Seller get(int id) throws ClassNotFoundException, SQLException;
	
	
	
	int insert(Seller seller) throws ClassNotFoundException, SQLException;
	int update(Seller seller) throws ClassNotFoundException, SQLException;
	int delete(int id) throws ClassNotFoundException, SQLException;
	int getLastId() throws ClassNotFoundException, SQLException;
}
