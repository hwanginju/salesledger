package com.iyf.salesledger.controller.page.total;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


import lombok.extern.log4j.Log4j2;

@Controller @Log4j2
public class TotalPageController {
	
	/***
	 * @기능 empStatusList_total.jsp 페이지 호출
	 */
	@GetMapping("/empStatusList_total")
	public String showEmpStatusList() {
		if (log.isInfoEnabled()) {log.info("Start TotalPageController.showEmpStatusList");}
		if (log.isInfoEnabled()) {log.info("page ::: " + "total/empStatusList_total");}
		if (log.isInfoEnabled()) {log.info("End TotalPageController.showEmpStatusList");}
		return "total/empStatusList_total";
	}
	
	/***
	 * @기능 salesCostStatusListTotal.jsp 회사별 사업부 전체 매출원가현황 페이지 호출
	 */
	@PreAuthorize("hasAuthority('통합 관리자') or hasAuthority('IYCNC 관리자')")
	@GetMapping("/iycnc/salesCostStatusListTotal")
	public String salesCostStatusListTotalIYCNCPage(ModelMap modelMap) {
		if (log.isInfoEnabled()) {log.info("Start TotalAjaxController.salesCostStatusListTotalIYCNCPage");}
		modelMap.addAttribute("company", "IYCNC");
		modelMap.addAttribute("company_lower", "iycnc");
		if (log.isInfoEnabled()) {log.info("modelMap ::: " + modelMap);}
		if (log.isInfoEnabled()) {log.info("page ::: " + "iycnc/salesCostStatusListTotal");}
		if (log.isInfoEnabled()) {log.info("End TotalAjaxController.salesCostStatusListTotalIYCNCPage");}
		return "iycnc/salesCostStatusListTotal";
	}
	
	@PreAuthorize("hasAuthority('통합 관리자') or hasAuthority('IBTS 관리자')")
	@GetMapping("/ibts/salesCostStatusListTotal")
	public String salesCostStatusListTotalIBTSPage(ModelMap modelMap) {
		if (log.isInfoEnabled()) {log.info("Start TotalAjaxController.salesCostStatusListTotalIBTSPage");}
		modelMap.addAttribute("company", "IBTS");
		modelMap.addAttribute("company_lower", "ibts");
		if (log.isInfoEnabled()) {log.info("modelMap ::: " + modelMap);}
		if (log.isInfoEnabled()) {log.info("page ::: " + "ibts/salesCostStatusListTotal");}
		if (log.isInfoEnabled()) {log.info("End TotalAjaxController.salesCostStatusListTotalIBTSPage");}
		return "ibts/salesCostStatusListTotal";
	}
	
	@PreAuthorize("hasAuthority('통합 관리자') or hasAuthority('IYS 관리자')")
	@GetMapping("/iys/salesCostStatusListTotal")
	public String salesCostStatusListTotalIYSPage(ModelMap modelMap) {
		if (log.isInfoEnabled()) {log.info("Start TotalAjaxController.salesCostStatusListTotalIYSPage");}
		modelMap.addAttribute("company", "IYS");
		modelMap.addAttribute("company_lower", "iys");
		if (log.isInfoEnabled()) {log.info("modelMap ::: " + modelMap);}
		if (log.isInfoEnabled()) {log.info("page ::: " + "iys/salesCostStatusListTotal");}
		if (log.isInfoEnabled()) {log.info("End TotalAjaxController.salesCostStatusListTotalIYSPage");}
		return "iys/salesCostStatusListTotal";
	}
	
	/***
	 * @기능 salesEstimationListTotal.jsp 회사별 사업부 전체매출추정 목록페이지 (기본이 다음달 데이터조회, 검색으로 해당년월 데이터조회가능)
	 */
	@PreAuthorize("hasAuthority('통합 관리자') or hasAuthority('IYCNC 관리자')")
	@GetMapping("/iycnc/salesEstimationListTotal")
	public String showSalesEstimationListTotalIYCNCPage(ModelMap modelMap) {
		if (log.isInfoEnabled()) {log.info("Start TotalAjaxController.showSalesEstimationListTotalIYCNCPage");}
		modelMap.addAttribute("company", "IYCNC");
		modelMap.addAttribute("company_lower", "iycnc");
		if (log.isInfoEnabled()) {log.info("modelMap ::: " + modelMap);}
		if (log.isInfoEnabled()) {log.info("page ::: " + "iycnc/salesEstimationListTotal");}
		if (log.isInfoEnabled()) {log.info("End TotalAjaxController.showSalesEstimationListTotalIYCNCPage");}
		return "iycnc/salesEstimationListTotal";
	}
	
	@PreAuthorize("hasAuthority('통합 관리자') or hasAuthority('IBTS 관리자')")
	@GetMapping("/ibts/salesEstimationListTotal")
	public String showSalesEstimationListTotalIBTSPage(ModelMap modelMap) {
		if (log.isInfoEnabled()) {log.info("Start TotalAjaxController.showSalesEstimationListTotalIBTSPage");}
		modelMap.addAttribute("company", "IBTS");
		modelMap.addAttribute("company_lower", "ibts");
		if (log.isInfoEnabled()) {log.info("modelMap ::: " + modelMap);}
		if (log.isInfoEnabled()) {log.info("page ::: " + "ibts/salesEstimationListTotal");}
		if (log.isInfoEnabled()) {log.info("End TotalAjaxController.showSalesEstimationListTotalIBTSPage");}
		return "ibts/salesEstimationListTotal";
	}
	
	@PreAuthorize("hasAuthority('통합 관리자') or hasAuthority('IYS 관리자')")
	@GetMapping("/iys/salesEstimationListTotal")
	public String showSalesEstimationListTotalIYSPage(ModelMap modelMap) {
		if (log.isInfoEnabled()) {log.info("Start TotalAjaxController.showSalesEstimationListTotalIYSPage");}
		modelMap.addAttribute("company", "IYS");
		modelMap.addAttribute("company_lower", "iys");
		if (log.isInfoEnabled()) {log.info("modelMap ::: " + modelMap);}
		if (log.isInfoEnabled()) {log.info("page ::: " + "iycnc/salesEstimationListTotal");}
		if (log.isInfoEnabled()) {log.info("End TotalAjaxController.showSalesEstimationListTotalIYSPage");}
		return "iys/salesEstimationListTotal";
	}
	
	/*
	 * @기능 salesResultListTotal.jsp 회사별 사업부 전체매출실적 목록페이지 (기본이 금월 데이터조회, 검색으로 해당년월 데이터조회가능)
	 */
	@PreAuthorize("hasAuthority('통합 관리자') or hasAuthority('IYCNC 관리자')")
	@GetMapping("/iycnc/salesResultListTotal")
	public String showSalesResultListTotalIYCNCPage(ModelMap modelMap) {
		if (log.isInfoEnabled()) {log.info("Start TotalAjaxController.showSalesResultListTotalIYCNCPage");}
		modelMap.addAttribute("company", "IYCNC");
		modelMap.addAttribute("company_lower", "iycnc");
		if (log.isInfoEnabled()) {log.info("modelMap ::: " + modelMap);}
		if (log.isInfoEnabled()) {log.info("page ::: " + "iycnc/salesResultListTotal");}
		if (log.isInfoEnabled()) {log.info("End TotalAjaxController.showSalesResultListTotalIYCNCPage");}
		return "iycnc/salesResultListTotal";
	}
	
	@PreAuthorize("hasAuthority('통합 관리자') or hasAuthority('IBTS 관리자')")
	@GetMapping("/ibts/salesResultListTotal")
	public String showSalesResultListTotalIBTSPage(ModelMap modelMap) {
		if (log.isInfoEnabled()) {log.info("Start TotalAjaxController.showSalesResultListTotalIBTSPage");}
		modelMap.addAttribute("company", "IBTS");
		modelMap.addAttribute("company_lower", "ibts");
		if (log.isInfoEnabled()) {log.info("modelMap ::: " + modelMap);}
		if (log.isInfoEnabled()) {log.info("page ::: " + "ibts/salesResultListTotal");}
		if (log.isInfoEnabled()) {log.info("End TotalAjaxController.showSalesResultListTotalIBTSPage");}
		return "ibts/salesResultListTotal";
	}
	
	@PreAuthorize("hasAuthority('통합 관리자') or hasAuthority('IYS 관리자')")
	@GetMapping("/iys/salesResultListTotal")
	public String showSalesResultListTotalIYSPage(ModelMap modelMap) {
		if (log.isInfoEnabled()) {log.info("Start TotalAjaxController.showSalesResultListTotalIYSPage");}
		modelMap.addAttribute("company", "IYS");
		modelMap.addAttribute("company_lower", "iys");
		if (log.isInfoEnabled()) {log.info("modelMap ::: " + modelMap);}
		if (log.isInfoEnabled()) {log.info("page ::: " + "iys/salesResultListTotal");}
		if (log.isInfoEnabled()) {log.info("End TotalAjaxController.showSalesResultListTotalIYSPage");}
		return "iys/salesResultListTotal";
	}
}
