package ffffffff;

import java.util.List;

import com.funding.web.entity.Member;

public interface MemberDao1 {
	
	List<Member1> getList() throws Exception;	//������-ȸ������Ʈ
	List<Member1> getList(int page) throws Exception;	//������-ȸ������Ʈ(������ �ѱ��)
	List<Member1> getList(int page, String field, String query) throws Exception;	//������-ȸ������Ʈ(�˻�)
	
	Member1 get(String mail) throws Exception;	//ȸ������ �󼼺���
	
	int insert(Member1 member) throws Exception;	//ȸ������
	int update(Member1 member) throws Exception;	//����������-��������
	List<Member1> getUK() throws Exception;
	

}
