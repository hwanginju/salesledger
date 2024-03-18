package com.iyf.salesledger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iyf.salesledger.common.model.CustomMap;
import com.iyf.salesledger.common.paging.PagingDTO;
import com.iyf.salesledger.common.security.Member;
import com.iyf.salesledger.common.security.MemberAuthority;
import com.iyf.salesledger.dao.MemberDao;

import lombok.extern.log4j.Log4j2;

@Service @Log4j2
public class MemberService {

	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Member selectOne(String username) {
		return memberDao.selectOne(username);
	}

	@Transactional
	public void insert(Member member) {
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		memberDao.insertMember(member);
		MemberAuthority memberAuthority = new MemberAuthority();
		memberAuthority.setUsername(member.getUsername());
		memberAuthority.setAuthority("권한 없음");
		memberDao.insertAuthority(memberAuthority);
	}

	public List<CustomMap> selectMemberListPagingByKeyword(PagingDTO pagingDTO) {
		return memberDao.selectMemberListPagingByKeyword(pagingDTO);
	}

	public long selectTotalCount(PagingDTO pagingDTO) {
		return memberDao.selectTotalCount(pagingDTO);
	}

	@Transactional
	public void update(CustomMap paramMap) {
			memberDao.updateMemberDetail(paramMap);
			
			memberDao.deleteMemberAuthority(paramMap);
			List<String> authList = (List<String>) paramMap.getList("authList");
			for (String auth : authList) {
				CustomMap authMap = new CustomMap();
				authMap.put("username", paramMap.getString("username"));
				authMap.put("authority" ,auth);
				memberDao.insertMemberAuthority(authMap);
			}
	}

	@Transactional
	public void delete(String username) {
		memberDao.deleteAuthority(username);
		memberDao.deleteMember(username);
	}	
	
	public void updateMemberPassword(CustomMap paramMap) {
		if (log.isInfoEnabled()) { log.info("paramMap ::: " + paramMap); }
		String encodedPassword = passwordEncoder.encode(paramMap.getString("password"));
		if (log.isInfoEnabled()) { log.info("encodedPassword ::: " + encodedPassword); }
		CustomMap memberMap = new CustomMap();
		memberMap.put("username", paramMap.getString("username"));
		memberMap.put("password", encodedPassword);
		memberDao.updateMemberPassword(memberMap);
	}
	

}
