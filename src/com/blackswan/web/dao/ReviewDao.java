package com.blackswan.web.dao;

import java.sql.SQLException;
import java.util.List;

import com.blackswan.web.entity.view.ReviewView;

public interface ReviewDao {
//	
//	List<ReviewView> getList() throws ClassNotFoundException, SQLException;	//���丮��Ʈ
//	List<ReviewView> getList(int page) throws ClassNotFoundException, SQLException;	//���丮��Ʈ(������ �ѱ��)
	List<ReviewView> getList(int page, int id) throws ClassNotFoundException, SQLException;	//���丮��Ʈ(�˻�)
	
	

}
