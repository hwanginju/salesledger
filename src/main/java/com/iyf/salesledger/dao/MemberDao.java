package com.iyf.salesledger.dao;

import java.util.List;

import com.iyf.salesledger.common.model.CustomMap;
import com.iyf.salesledger.common.paging.PagingDTO;
import com.iyf.salesledger.common.security.Member;
import com.iyf.salesledger.common.security.MemberAuthority;

public interface MemberDao {
	Member selectOne(String username);
	
	void insertMember(Member member);
	
	void insertAuthority(MemberAuthority memberAuthority);
	
	List<CustomMap> selectMemberListPagingByKeyword(PagingDTO pagingDTO);
	
	long selectTotalCount(PagingDTO pagingDTO);
	
	void updateMember(Member member);
	
	int updateMemberDetail(CustomMap paramMap);
	
	int deleteMemberAuthority(CustomMap paramMap);
	
	int insertMemberAuthority(CustomMap paramMap);
	
	void updateAuthority(MemberAuthority authority); 
	
	void deleteMember(String username);
	
	void deleteAuthority(String username);
}
