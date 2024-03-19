package com.iyf.salesledger.controller.ajax.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iyf.salesledger.common.model.CustomMap;
import com.iyf.salesledger.common.security.Member;
import com.iyf.salesledger.common.security.MemberAuthority;
import com.iyf.salesledger.service.MemberService;

import lombok.extern.log4j.Log4j2;

@RestController @Log4j2
public class AdminMemberAjaxController {

	@Autowired
	private MemberService memberService;
	
	/***
	 * @기능 memberDetail.jsp 페이지에서 회원정보 수정
	 * @param memberMap 
	 * @param username 회원 아이디
	 * @param enabled 회원 활성상태
	 * @param auth 회원 권한
	 * @return 
	 */
	@PreAuthorize("hasAuthority('통합 관리자')")
	@PutMapping("/admin/member.ajax")
	public void updateMember(@RequestBody CustomMap requestMap) {
		if (log.isInfoEnabled()) {log.info("Start AdminMemberAjaxController.updateMember");}
		memberService.update(requestMap);
		if (log.isInfoEnabled()) {log.info("End AdminMemberAjaxController.updateMember");}
	}
	
	/***
	 * @기능 memberDetail.jsp 페이지에서 회원비밀번호 수정
	 * @param requestMap
	 */
	@PreAuthorize("hasAuthority('통합 관리자')")
	@PostMapping("/admin/member.ajax/changePassword")
	public void updateMemberPassword(@RequestBody CustomMap requestMap) {
		if (log.isInfoEnabled()) {log.info("Start AdminMemberAjaxController.updateMemberPassword");}
		memberService.updateMemberPassword(requestMap);
		if (log.isInfoEnabled()) {log.info("End AdminMemberAjaxController.updateMemberPassword");}
	}
	
	/***
	 * @기능 memberDetail.jsp 페이지에서 회원정보 삭제
	 * @param username 회원 아이디
	 * @return 
	 */
	@PreAuthorize("hasAuthority('통합 관리자')")
	@DeleteMapping("/admin/member.ajax/username/{username}")
	public void deleteMember(@PathVariable String username) {
		if (log.isInfoEnabled()) {log.info("Start AdminMemberAjaxController.deleteMember");}
		if (log.isInfoEnabled()) {log.info("param ::: username ::: " + username);}
		if (log.isInfoEnabled()) {log.info("do service ::: memberService.delete");}
		memberService.delete(username);
		if (log.isInfoEnabled()) {log.info("End AdminMemberAjaxController.deleteMember");}
	}
}
