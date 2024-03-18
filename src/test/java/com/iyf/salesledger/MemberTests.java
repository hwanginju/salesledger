package com.iyf.salesledger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.iyf.salesledger.common.model.CustomMap;
import com.iyf.salesledger.dao.MemberDao;

import lombok.extern.log4j.Log4j2;

@SpringBootTest @Log4j2
public class MemberTests {

	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	public void test1() {
		String username = "user1";
		String password = "qwer";
		
		updateMemberPassword(username, password);
	}
	
	/***
	 * <pre>
	 * 회원 비밀번호 변경
	 * </pre>
	 * @param username 변경 대상 회원아이디
	 * @param password 신규 비밀번호
	 */
	private void updateMemberPassword(String username, String password) {
		CustomMap memberMap = new CustomMap();
		memberMap.put("username", username);
		
		String encodedPassword = passwordEncoder.encode(password);
		memberMap.put("password", encodedPassword);
		if (log.isInfoEnabled()) { log.info("username ::: " + username); }
		if (log.isInfoEnabled()) { log.info("password ::: " + password); }
		if (log.isInfoEnabled()) { log.info("encodedPassword ::: " + encodedPassword); }
		if (log.isInfoEnabled()) { log.info("memberMap ::: " + memberMap); }
		memberDao.updateMemberPassword(memberMap);
		
	}
}
