package com.iyf.salesledger.controller.page.iys;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iyf.salesledger.service.SalesCostStatusService;

import lombok.extern.log4j.Log4j2;

@Controller @Log4j2
public class IYSCONVERSIONPageController {
	
	@Autowired
	private SalesCostStatusService salesCostStatusService;

	/***
	 * @기능 iys/conversion/empLedgerList.jsp 인력기초원장 목록페이지
	 */
	@PreAuthorize("hasAuthority('통합 관리자') or hasAuthority('IYS 관리자')")
	@GetMapping("/iys/conversion/empLedgerList")
	public String showEmpLedgerListPage(ModelMap modelMap) {
		if (log.isInfoEnabled()) {log.info("Start IYSCONVERSIONPageController.showEmpLedgerListPage");}
		modelMap.addAttribute("company", "IYS");
		modelMap.addAttribute("company_lower", "iys");
		modelMap.addAttribute("department", "CONVERSION");
		modelMap.addAttribute("department_lower", "conversion");
		modelMap.addAttribute("department_kr", "컨버전스");
		if (log.isInfoEnabled()) {log.info("modelMap ::: " + modelMap);}
		if (log.isInfoEnabled()) {log.info("page ::: " + "iys/conversion/empLedgerList");}
		if (log.isInfoEnabled()) {log.info("End IYSCONVERSIONPageController.showEmpLedgerListPage");}
		return "iys/conversion/empLedgerList";
	}

	/***
	 * @기능 iys/conversion/empLedgerRegister.jsp 인력기초원장 등록팝업페이지 (투입예정버튼 클릭시)
	 */
	@PreAuthorize("hasAuthority('통합 관리자') or hasAuthority('IYS 관리자')")
	@GetMapping("/iys/conversion/empLedgerRegister")
	public String showEmpLedgerRegisterPage(ModelMap modelMap) {
		if (log.isInfoEnabled()) {log.info("Start IYSCONVERSIONPageController.showEmpLedgerRegisterPage");}
		modelMap.addAttribute("company", "IYS");
		modelMap.addAttribute("company_lower", "iys");
		modelMap.addAttribute("department", "CONVERSION");
		modelMap.addAttribute("department_lower", "conversion");
		modelMap.addAttribute("department_kr", "컨버전스");
		if (log.isInfoEnabled()) {log.info("modelMap ::: " + modelMap);}
		if (log.isInfoEnabled()) {log.info("page ::: " + "iys/conversion/empLedgerRegister");}
		if (log.isInfoEnabled()) {log.info("End IYSCONVERSIONPageController.showEmpLedgerRegisterPage");}
		return "iys/conversion/empLedgerRegister";
	}

	/***
	 * @기능 iys/conversion/empLedgerDetail.jsp 인력기초원장 상세팝업페이지 (행데이터 더블클릭시)
	 */
	@PreAuthorize("hasAuthority('통합 관리자') or hasAuthority('IYS 관리자')")
	@GetMapping("/iys/conversion/empLedgerDetail")
	public String showEmpLedgerDetailPage(ModelMap modelMap) {
		if (log.isInfoEnabled()) {log.info("Start IYSCONVERSIONPageController.showEmpLedgerDetailPage");}
		modelMap.addAttribute("company", "IYS");
		modelMap.addAttribute("company_lower", "iys");
		modelMap.addAttribute("department", "CONVERSION");
		modelMap.addAttribute("department_lower", "conversion");
		modelMap.addAttribute("department_kr", "컨버전스");
		if (log.isInfoEnabled()) {log.info("modelMap ::: " + modelMap);}
		if (log.isInfoEnabled()) {log.info("page ::: " + "iys/conversion/empLedgerDetail");}
		if (log.isInfoEnabled()) {log.info("End IYSCONVERSIONPageController.showEmpLedgerDetailPage");}
		return "iys/conversion/empLedgerDetail";
	}

	/***
	 * @기능 iys/conversion/salesLedgerList.jsp 매출원장 목록페이지 (기본이 금월 데이터조회, 검색으로 해당년월 데이터조회가능)
	 */
	@PreAuthorize("hasAuthority('통합 관리자') or hasAuthority('IYS 관리자')")
	@GetMapping("/iys/conversion/salesLedgerList")
	public String showSalesledgerListPage(ModelMap modelMap) {
		if (log.isInfoEnabled()) {log.info("Start IYSCONVERSIONPageController.showSalesledgerListPage");}
		modelMap.addAttribute("company", "IYS");
		modelMap.addAttribute("company_lower", "iys");
		modelMap.addAttribute("department", "CONVERSION");
		modelMap.addAttribute("department_lower", "conversion");
		modelMap.addAttribute("department_kr", "컨버전스");
		if (log.isInfoEnabled()) {log.info("modelMap ::: " + modelMap);}
		if (log.isInfoEnabled()) {log.info("page ::: " + "iys/conversion/salesLedgerList");}
		if (log.isInfoEnabled()) {log.info("End IYSCONVERSIONPageController.showSalesledgerListPage");}
		return "iys/conversion/salesLedgerList";
	}
	
	/***
	 * @기능 iys/conversion/salesLedgerDetail.jsp 매출원장 상세팝업페이지 (행데이터 더블클릭시)
	 */
	@PreAuthorize("hasAuthority('통합 관리자') or hasAuthority('IYS 관리자')")
	@GetMapping("/iys/conversion/salesLedgerDetail")
	public String showSalesledgerDetailPage(ModelMap modelMap) {
		if (log.isInfoEnabled()) {log.info("Start IYSCONVERSIONPageController.showSalesledgerDetailPage");}
		modelMap.addAttribute("company", "IYS");
		modelMap.addAttribute("company_lower", "iys");
		modelMap.addAttribute("department", "CONVERSION");
		modelMap.addAttribute("department_lower", "conversion");
		modelMap.addAttribute("department_kr", "컨버전스");
		if (log.isInfoEnabled()) {log.info("modelMap ::: " + modelMap);}
		if (log.isInfoEnabled()) {log.info("page ::: " + "iys/conversion/salesLedgerDetail");}
		if (log.isInfoEnabled()) {log.info("End IYSCONVERSIONPageController.showSalesledgerDetailPage");}
		return "iys/conversion/salesLedgerDetail";
	}
	
	/***
	 * @기능 iys/conversion/salesResultList.jsp 매출실적 목록페이지 (기본이 금월 데이터조회, 검색으로 해당년월 데이터조회가능)
	 */
	@PreAuthorize("hasAuthority('통합 관리자') or hasAuthority('IYS 관리자')")
	@GetMapping("/iys/conversion/salesResultList")
	public String showSalesResultListPage(ModelMap modelMap) {
		if (log.isInfoEnabled()) {log.info("Start IYSCONVERSIONPageController.showSalesResultListPage");}
		modelMap.addAttribute("company", "IYS");
		modelMap.addAttribute("company_lower", "iys");
		modelMap.addAttribute("department", "CONVERSION");
		modelMap.addAttribute("department_lower", "conversion");
		modelMap.addAttribute("department_kr", "컨버전스");
		if (log.isInfoEnabled()) {log.info("modelMap ::: " + modelMap);}
		if (log.isInfoEnabled()) {log.info("page ::: " + "iys/conversion/salesResultList");}
		if (log.isInfoEnabled()) {log.info("End IYSCONVERSIONPageController.showSalesResultListPage");}
		return "iys/conversion/salesResultList";
	}
	
	/***
	 * @기능 iys/conversion/salesResultList.jsp 매출실적 수기데이터 등록팝업페이지 (수기데이터 등록버튼 클릭시) <br>
	 *     (수기 데이터: 매출원장에 없는 수기등록 데이터로 배치스케줄러에 의한 추가/삭제되지 않고 매출실적과 통계에 필요시 추가적으로 반영되기 위한 데이터)
	 */
	@PreAuthorize("hasAuthority('통합 관리자') or hasAuthority('IYS 관리자')")
	@GetMapping("/iys/conversion/salesResultRegister")
	public String showSalesResultRegisterPage(ModelMap modelMap) {
		if (log.isInfoEnabled()) {log.info("Start IYSCONVERSIONPageController.showSalesResultRegisterPage");}
		modelMap.addAttribute("company", "IYS");
		modelMap.addAttribute("company_lower", "iys");
		modelMap.addAttribute("department", "CONVERSION");
		modelMap.addAttribute("department_lower", "conversion");
		modelMap.addAttribute("department_kr", "컨버전스");
		if (log.isInfoEnabled()) {log.info("modelMap ::: " + modelMap);}
		if (log.isInfoEnabled()) {log.info("page ::: " + "iys/conversion/salesResultRegister");}
		if (log.isInfoEnabled()) {log.info("End IYSCONVERSIONPageController.showSalesResultRegisterPage");}
		return "iys/conversion/salesResultRegister";
	}
	
	/***
	 * @기능 iys/conversion/salesResultDetail.jsp 매출실적 수기데이터 상세팝업페이지 (행데이터 더블클릭시) <br>
	 * 	   1. 매출원장을 원본으로 하는 매출실적은 직접 수정불가하며 <br>
	 * 	   2. 수기등록 데이터만 매출실적상세에서 직접 수정가능함
	 */
	@PreAuthorize("hasAuthority('통합 관리자') or hasAuthority('IYS 관리자')")
	@GetMapping("/iys/conversion/salesResultDetail")
	public String showSalesResultDetailPage() {
		if (log.isInfoEnabled()) {log.info("Start IYSCONVERSIONPageController.showSalesResultDetailPage");}
		if (log.isInfoEnabled()) {log.info("page ::: " + "iys/conversion/salesResultDetail");}
		if (log.isInfoEnabled()) {log.info("End IYSCONVERSIONPageController.showSalesResultDetailPage");}
		return "iys/conversion/salesResultDetail";
	}
	
	/***
	 * @기능 iys/conversion/salesEstimationList.jsp 매출추정 목록페이지 (기본이 다음달 데이터조회, 검색으로 해당년월 데이터조회가능)
	 */
	@PreAuthorize("hasAuthority('통합 관리자') or hasAuthority('IYS 관리자')")
	@GetMapping("/iys/conversion/salesEstimationList")
	public String showSalesEstimationListPage(ModelMap modelMap) {
		if (log.isInfoEnabled()) {log.info("Start IYSCONVERSIONPageController.showSalesEstimationListPage");}
		modelMap.addAttribute("company", "IYS");
		modelMap.addAttribute("company_lower", "iys");
		modelMap.addAttribute("department", "CONVERSION");
		modelMap.addAttribute("department_lower", "conversion");
		modelMap.addAttribute("department_kr", "컨버전스");
		if (log.isInfoEnabled()) {log.info("page ::: " + "iys/conversion/salesEstimationList");}
		if (log.isInfoEnabled()) {log.info("End IYSCONVERSIONPageController.showSalesEstimationListPage");}
		return "iys/conversion/salesEstimationList";
	}
	
	/***
	 * @기능 iys/conversion/salesCostStatusList.jsp 매출원가현황 목록페이지
	 */
	@PreAuthorize("hasAuthority('통합 관리자') or hasAuthority('IYS 관리자')")
	@GetMapping("/iys/conversion/salesCostStatusList")
	public String salesCostStatusListPage(ModelMap modelMap) {
		if (log.isInfoEnabled()) {log.info("Start IYSCONVERSIONPageController.salesCostStatusListpPage");}
		modelMap.addAttribute("company", "IYS");
		modelMap.addAttribute("company_lower", "iys");
		modelMap.addAttribute("department", "CONVERSION");
		modelMap.addAttribute("department_lower", "conversion");
		modelMap.addAttribute("department_kr", "CONVERSION");
		if (log.isInfoEnabled()) {log.info("modelMap ::: " + modelMap);}
		if (log.isInfoEnabled()) {log.info("page ::: " + "iys/conversion/salesCostStatusList");}
		if (log.isInfoEnabled()) {log.info("End IYSCONVERSIONPageController.salesCostStatusListpPage");}
		return "iys/conversion/salesCostStatusList";
	}

    /***
	 * @기능 iys/conversion/salesCostStatusDetail.jsp 매출원가현황 목록 상세페이지
	 */
	@PreAuthorize("hasAuthority('통합 관리자') or hasAuthority('IYS 관리자')")
	@GetMapping("/iys/conversion/salesCostStatusDetail")
	public String salesCostStatusDetailPage(@RequestParam long emp_id, ModelMap modelMap) {
		if (log.isInfoEnabled()) {log.info("Start IYSCONVERSIONPageController.salesCostStatusDetailPage");}
		modelMap.addAttribute("company", "IYS");
		modelMap.addAttribute("company_lower", "iys");
		modelMap.addAttribute("department", "CONVERSION");
		modelMap.addAttribute("department_lower", "conversion");
		modelMap.addAttribute("department_kr", "CONVERSION");
		
		Map<String, Object> requestMap = new HashMap<>();
		requestMap.put("emp_id", emp_id);
		Map<String, Object> salesCostStatus = salesCostStatusService.getSalesCostStatus(requestMap);
		modelMap.addAttribute("salesCostStatus", salesCostStatus);
		
		if (log.isInfoEnabled()) {log.info("modelMap ::: " + modelMap);}
		if (log.isInfoEnabled()) {log.info("page ::: " + "iys/conversion/salesCostStatusDetail");}
		if (log.isInfoEnabled()) {log.info("End IYSCONVERSIONPageController.salesCostStatusDetailPage");}
		return "iys/conversion/salesCostStatusDetail";
	}
}
