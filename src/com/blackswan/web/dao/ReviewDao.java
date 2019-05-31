package com.blackswan.web.dao;

import java.sql.SQLException;
import java.util.List;

import com.blackswan.web.entity.Review;

public interface ReviewDao {
	
	List<Review> getList() throws ClassNotFoundException, SQLException;	//���丮��Ʈ
	List<Review> getList(int page) throws ClassNotFoundException, SQLException;	//���丮��Ʈ(������ �ѱ��)
	List<Review> getList(int page, String field, String query) throws ClassNotFoundException, SQLException;	//���丮��Ʈ(�˻�)
	
	Review get(int id) throws ClassNotFoundException, SQLException;	//���� �󼼺���
	Review getPrev(int id) throws ClassNotFoundException, SQLException;//����������
	Review getNext(int id);//����������
	
	int insert(Review review) throws SQLException, ClassNotFoundException;	//�۾���
	int update(Review review) throws ClassNotFoundException, SQLException;	//����
	int delete(int id) throws ClassNotFoundException, SQLException;// ����

}
