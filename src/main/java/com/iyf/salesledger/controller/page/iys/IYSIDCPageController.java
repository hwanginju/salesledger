package com.iyf.salesledger.controller.page.iys;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iyf.salesledger.service.SalesCostStatusService;

import lombok.extern.log4j.Log4j2;

@Controller @Log4j2
public class IYSIDCPageController {
	
	@Autowired
	private SalesCostStatusService salesCostStatusService;

	/***
	 * @기능 iys/idc/empLedgerList.jsp 인력기초원장 목록페이지
	 */
	@PreAuthorize("hasAuthority('통합 관리자') or hasAuthority('IYS 관리자')")
	@GetMapping("/iys/idc/empLedgerList")
	public String showEmpLedgerListPage(ModelMap modelMap) {
		if (log.isInfoEnabled()) {log.info("Start IYSIDCPageController.showEmpLedgerListPage");}
		modelMap.addAttribute("company", "IYS");
		modelMap.addAttribute("company_lower", "iys");
		modelMap.addAttribute("department", "IDC");
		modelMap.addAttribute("department_lower", "idc");
		modelMap.addAttribute("department_kr", "IDC");
		if (log.isInfoEnabled()) {log.info("modelMap ::: " + modelMap);}
		if (log.isInfoEnabled()) {log.info("page ::: " + "iys/idc/empLedgerList");}
		if (log.isInfoEnabled()) {log.info("End IYSIDCPageController.showEmpLedgerListPage");}
		return "iys/idc/empLedgerList";
	}

	/***
	 * @기능 iys/idc/empLedgerRegister.jsp 인력기초원장 등록팝업페이지 (투입예정버튼 클릭시)
	 */
	@PreAuthorize("hasAuthority('통합 관리자') or hasAuthority('IYS 관리자')")
	@GetMapping("/iys/idc/empLedgerRegister")
	public String showEmpLedgerRegisterPage(ModelMap modelMap) {
		if (log.isInfoEnabled()) {log.info("Start IYSIDCPageController.showEmpLedgerRegisterPage");}
		modelMap.addAttribute("company", "IYS");
		modelMap.addAttribute("company_lower", "iys");
		modelMap.addAttribute("department", "IDC");
		modelMap.addAttribute("department_lower", "idc");
		modelMap.addAttribute("department_kr", "IDC");
		if (log.isInfoEnabled()) {log.info("modelMap ::: " + modelMap);}
		if (log.isInfoEnabled()) {log.info("page ::: " + "iys/idc/empLedgerRegister");}
		if (log.isInfoEnabled()) {log.info("End IYSIDCPageController.showEmpLedgerRegisterPage");}
		return "iys/idc/empLedgerRegister";
	}


	/***
	 * @기능 iys/idc/salesLedgerDetail.jsp 인력기초원장 상세팝업페이지 (행데이터 더블클릭시)
	 */
	@PreAuthorize("hasAuthority('통합 관리자') or hasAuthority('IYS 관리자')")
	@GetMapping("/iys/idc/empLedgerDetail")
	public String showEmpLedgerDetailPage(ModelMap modelMap) {
		if (log.isInfoEnabled()) {log.info("Start IYSIDCPageController.showEmpLedgerDetailPage");}
		modelMap.addAttribute("company", "IYS");
		modelMap.addAttribute("company_lower", "iys");
		modelMap.addAttribute("department", "IDC");
		modelMap.addAttribute("department_lower", "idc");
		modelMap.addAttribute("department_kr", "IDC");
		if (log.isInfoEnabled()) {log.info("modelMap ::: " + modelMap);}
		if (log.isInfoEnabled()) {log.info("page ::: " + "iys/idc/empLedgerDetail");}
		if (log.isInfoEnabled()) {log.info("End IYSIDCPageController.showEmpLedgerDetailPage");}
		return "iys/idc/empLedgerDetail";
	}
	
	/***
	 * @기능 iys/idc/salesLedgerList.jsp 매출원장 목록페이지 (기본이 금월 데이터조회, 검색으로 해당년월 데이터조회가능)
	 */
	@PreAuthorize("hasAuthority('통합 관리자') or hasAuthority('IYS 관리자')")
	@GetMapping("/iys/idc/salesLedgerList")
	public String showSalesledgerListPage(ModelMap modelMap) {
		if (log.isInfoEnabled()) {log.info("Start IYSIDCPageController.showSalesledgerListPage");}
		modelMap.addAttribute("company", "IYS");
		modelMap.addAttribute("company_lower", "iys");
		modelMap.addAttribute("department", "IDC");
		modelMap.addAttribute("department_lower", "idc");
		modelMap.addAttribute("department_kr", "IDC");
		if (log.isInfoEnabled()) {log.info("modelMap ::: " + modelMap);}
		if (log.isInfoEnabled()) {log.info("page ::: " + "iys/idc/salesLedgerList");}
		if (log.isInfoEnabled()) {log.info("End IYSIDCPageController.showSalesledgerListPage");}
		return "iys/idc/salesLedgerList";
	}
	
	/***
	 * @기능 iys/idc/salesLedgerDetail.jsp 매출원장 상세팝업페이지 (행데이터 더블클릭시)
	 */
	@PreAuthorize("hasAuthority('통합 관리자') or hasAuthority('IYS 관리자')")
	@GetMapping("/iys/idc/salesLedgerDetail")
	public String showSalesledgerDetailPage(ModelMap modelMap) {
		if (log.isInfoEnabled()) {log.info("Start IYSIDCPageController.showSalesledgerDetailPage");}
		modelMap.addAttribute("company", "IYS");
		modelMap.addAttribute("company_lower", "iys");
		modelMap.addAttribute("department", "IDC");
		modelMap.addAttribute("department_lower", "idc");
		modelMap.addAttribute("department_kr", "IDC");
		if (log.isInfoEnabled()) {log.info("modelMap ::: " + modelMap);}
		if (log.isInfoEnabled()) {log.info("page ::: " + "iys/idc/salesLedgerDetail");}
		if (log.isInfoEnabled()) {log.info("End IYSIDCPageController.showSalesledgerDetailPage");}
		return "iys/idc/salesLedgerDetail";
	}
	
	/***
	 * @기능 iys/idc/salesResultList.jsp 매출실적 목록페이지 (기본이 금월 데이터조회, 검색으로 해당년월 데이터조회가능)
	 */
	@PreAuthorize("hasAuthority('통합 관리자') or hasAuthority('IYS 관리자')")
	@GetMapping("/iys/idc/salesResultList")
	public String showSalesResultListPage(ModelMap modelMap) {
		if (log.isInfoEnabled()) {log.info("Start IYSIDCPageController.showSalesResultListPage");}
		modelMap.addAttribute("company", "IYS");
		modelMap.addAttribute("company_lower", "iys");
		modelMap.addAttribute("department", "IDC");
		modelMap.addAttribute("department_lower", "idc");
		modelMap.addAttribute("department_kr", "IDC");
		if (log.isInfoEnabled()) {log.info("modelMap ::: " + modelMap);}
		if (log.isInfoEnabled()) {log.info("page ::: " + "iys/idc/salesResultList");}
		if (log.isInfoEnabled()) {log.info("End IYSIDCPageController.showSalesResultListPage");}
		return "iys/idc/salesResultList";
	}
	
	/***
	 * @기능 iys/idc/salesResultRegister.jsp 매출실적 수기데이터 등록팝업페이지 (수기데이터 등록버튼 클릭시) <br>
	 *     (수기 데이터: 매출원장에 없는 수기등록 데이터로 배치스케줄러에 의한 추가/삭제되지 않고 매출실적과 통계에 필요시 추가적으로 반영되기 위한 데이터)
	 */
	@PreAuthorize("hasAuthority('통합 관리자') or hasAuthority('IYS 관리자')")
	@GetMapping("/iys/idc/salesResultRegister")
	public String showSalesResultRegisterPage(ModelMap modelMap) {
		if (log.isInfoEnabled()) {log.info("Start IYSIDCPageController.showSalesResultRegisterPage");}
		modelMap.addAttribute("company", "IYS");
		modelMap.addAttribute("company_lower", "iys");
		modelMap.addAttribute("department", "IDC");
		modelMap.addAttribute("department_lower", "idc");
		modelMap.addAttribute("department_kr", "IDC");
		if (log.isInfoEnabled()) {log.info("modelMap ::: " + modelMap);}
		if (log.isInfoEnabled()) {log.info("page ::: " + "iys/idc/salesResultRegister");}
		if (log.isInfoEnabled()) {log.info("End IYSIDCPageController.showSalesResultRegisterPage");}
		return "iys/idc/salesResultRegister";
	}
	
	/***
	 * @기능 iys/idc/salesResultDetail.jsp 매출실적 수기데이터 상세팝업페이지 (행데이터 더블클릭시) <br>
	 * 	   1. 매출원장을 원본으로 하는 매출실적은 직접 수정불가하며 <br>
	 * 	   2. 수기등록 데이터만 매출실적상세에서 직접 수정가능함
	 */
	@PreAuthorize("hasAuthority('통합 관리자') or hasAuthority('IYS 관리자')")
	@GetMapping("/iys/idc/salesResultDetail")
	public String showSalesResultDetailPage(ModelMap modelMap) {
		if (log.isInfoEnabled()) {log.info("Start IYSIDCPageController.showSalesResultDetailPage");}
		modelMap.addAttribute("company", "IYS");
		modelMap.addAttribute("company_lower", "iys");
		modelMap.addAttribute("department", "IDC");
		modelMap.addAttribute("department_lower", "idc");
		modelMap.addAttribute("department_kr", "IDC");
		if (log.isInfoEnabled()) {log.info("modelMap ::: " + modelMap);}
		if (log.isInfoEnabled()) {log.info("page ::: " + "iys/idc/salesResultDetail");}
		if (log.isInfoEnabled()) {log.info("End IYSIDCPageController.showSalesResultDetailPage");}
		return "iys/idc/salesResultDetail";
	}
	
	/***
	 * @기능 iys/idc/salesEstimationList.jsp 매출추정 목록페이지 (기본이 다음달 데이터조회, 검색으로 해당년월 데이터조회가능)
	 */
	@PreAuthorize("hasAuthority('통합 관리자') or hasAuthority('IYS 관리자')")
	@GetMapping("/iys/idc/salesEstimationList")
	public String showSalesEstimationListPage(ModelMap modelMap) {
		if (log.isInfoEnabled()) {log.info("Start IYSIDCPageController.showSalesEstimationListPage");}
		modelMap.addAttribute("company", "IYS");
		modelMap.addAttribute("company_lower", "iys");
		modelMap.addAttribute("department", "IDC");
		modelMap.addAttribute("department_lower", "idc");
		modelMap.addAttribute("department_kr", "IDC");
		if (log.isInfoEnabled()) {log.info("modelMap ::: " + modelMap);}
		if (log.isInfoEnabled()) {log.info("page ::: " + "iys/idc/salesEstimationList");}
		if (log.isInfoEnabled()) {log.info("End IYSIDCPageController.showSalesEstimationListPage");}
		return "iys/idc/salesEstimationList";
	}
	
	/***
	 * @기능 iys/idc/salesCostStatusList.jsp 매출원가현황 목록페이지
	 */
	@PreAuthorize("hasAuthority('통합 관리자') or hasAuthority('IYS 관리자')")
	@GetMapping("/iys/idc/salesCostStatusList")
	public String salesCostStatusListPage(ModelMap modelMap) {
		if (log.isInfoEnabled()) {log.info("Start IYSIDCPageController.salesCostStatusListpPage");}
		modelMap.addAttribute("company", "IYS");
		modelMap.addAttribute("company_lower", "iys");
		modelMap.addAttribute("department", "IDC");
		modelMap.addAttribute("department_lower", "idc");
		modelMap.addAttribute("department_kr", "IDC");
		if (log.isInfoEnabled()) {log.info("modelMap ::: " + modelMap);}
		if (log.isInfoEnabled()) {log.info("page ::: " + "iys/idc/salesCostStatusList");}
		if (log.isInfoEnabled()) {log.info("End IYSIDCPageController.salesCostStatusListpPage");}
		return "iys/idc/salesCostStatusList";
	}

    /***
	 * @기능 iys/idc/salesCostStatusDetail.jsp 매출원가현황 목록 상세페이지
	 */
	@PreAuthorize("hasAuthority('통합 관리자') or hasAuthority('IYS 관리자')")
	@GetMapping("/iys/idc/salesCostStatusDetail")
	public String salesCostStatusDetailPage(@RequestParam long emp_id, ModelMap modelMap) {
		if (log.isInfoEnabled()) {log.info("Start IYSIDCPageController.salesCostStatusDetailPage");}
		modelMap.addAttribute("company", "IYS");
		modelMap.addAttribute("company_lower", "iys");
		modelMap.addAttribute("department", "IDC");
		modelMap.addAttribute("department_lower", "idc");
		modelMap.addAttribute("department_kr", "IDC");
		
		Map<String, Object> requestMap = new HashMap<>();
		requestMap.put("emp_id", emp_id);
		Map<String, Object> salesCostStatus = salesCostStatusService.getSalesCostStatus(requestMap);
		modelMap.addAttribute("salesCostStatus", salesCostStatus);
		
		if (log.isInfoEnabled()) {log.info("modelMap ::: " + modelMap);}
		if (log.isInfoEnabled()) {log.info("page ::: " + "iys/idc/salesCostStatusDetail");}
		if (log.isInfoEnabled()) {log.info("End IYSIDCPageController.salesCostStatusDetailPage");}
		return "iys/idc/salesCostStatusDetail";
	}
}
