package com.iyf.salesledger.controller.ajax.total;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iyf.salesledger.common.batch.service.SalesEstimationBatchService;
import com.iyf.salesledger.common.batch.service.SalesResultBatchService;
import com.iyf.salesledger.common.utils.DateUtils;
import com.iyf.salesledger.service.EmpStatusService;
import com.iyf.salesledger.service.SalesCostStatusService;
import com.iyf.salesledger.service.SalesEstimationService;
import com.iyf.salesledger.service.SalesResultService;

import lombok.extern.log4j.Log4j2;

@RestController @Log4j2
public class TotalAjaxController {
	
	@Autowired
	private EmpStatusService empStatusService;
	
	@Autowired
	private SalesCostStatusService salesCostStatusService;
	
	@Autowired
	private SalesEstimationService salesEstimationService;
	
	@Autowired
	private SalesEstimationBatchService salesEstimationBatchService;
	
	@Autowired
	private SalesResultBatchService salesResultBatchService;
	
	@Autowired
	private SalesResultService salesResultService;
	
	/*
	 * @기능 empStatusList_total.jsp 투입인력현황 목록 조회
	 * 
	 * @return 현황
	 * */
	@GetMapping("/empStatus.ajax")
	public List<Map<String, Object>> empStatusList() {
		if (log.isInfoEnabled() ) {log.info("Start TotalAjaxController.empStatusList");}
		if (log.isInfoEnabled() ) {log.info("do service ::: empStatusService.list");}
		List<Map<String, Object>> empStatus = empStatusService.list();
		if (log.isInfoEnabled() ) {log.info("End TotalAjaxController.empStatusList");}
		
		return empStatus;
	}
	
	/*
	 * @기능 salesCostStatusListTotal.jsp 회사별 매출원가현황 목록 조회
	 * 
	 * @return 현황
	 * */
	@GetMapping("/salesCostStatusTotal.ajax/company/{company}/batch_month/{batch_month}")
	public List<Map<String, Object>> retrieveSalesCostListByCompanyAndDepartment(@PathVariable String company, @PathVariable String batch_month) throws ParseException {
		Map<String, Object> requestMap = new HashMap<>();
		requestMap.put("company", company);
		requestMap.put("batch_month", batch_month);
		
		if (batch_month.equals(DateUtils.formatObject(new Date() , "yyyyMM"))) {
			return salesCostStatusService.getSalesCostStatuslistTotal(requestMap);
		} else {
			return salesCostStatusService.getSalesCostStatusHistorylist(requestMap);
		}
	}
	
	/*
	 * @기능 salesEstimationListTotal.jsp 페이지에서 매출추정 목록 조회
	 * @param company 회사(IYCNC, IBTS, IYS)
	 * @param batch_month 배치년월 yyyymm
	 */
	@GetMapping("/salesEstimationTotal.ajax/company/{company}/batch_month/{batch_month}")
	public List<Map<String, Object>> retrieveSalesEstimationListByCompanyAndBatchMonth(@PathVariable String company, @PathVariable String batch_month) {
		if (log.isInfoEnabled()) {log.info("Start TotalAjaxController.retrieveSalesEstimationListByCompanyAndBatchMonth");}
		if (log.isInfoEnabled()) {log.info("param ::: company ::: " + company);}
		if (log.isInfoEnabled()) {log.info("param ::: batch_month ::: " + batch_month);}
		if (log.isInfoEnabled()) {log.info("do service ::: salesEstimationService.listByCompanyAndBatchMonth");}
		List<Map<String, Object>> salesEstiListTotal = salesEstimationService.listByCompanyAndBatchMonth(company, batch_month);
		if (log.isInfoEnabled()) {log.info("End TotalAjaxController.retrieveSalesEstimationListByCompanyAndBatchMonth");}
		return salesEstiListTotal;
	}
	
	/*
	 * @기능 salesEstimationListTotal.jsp 페이지에서 매출추정 수동배치
	 * @param company 회사(IYCNC, IBTS, IYS)
	 * @param batch_month 배치년월 yyyymm
	 */
	@PostMapping("/salesEstimationTotal.ajax/company/{company}/batch_month/{batch_month}")
	public void manualSalesEstiBatchByIBTSAndITO(@PathVariable String company, @PathVariable String batch_month) {
		if (log.isInfoEnabled()) {log.info("Start TotalAjaxController.manualSalesBatchByCompany");}
		if (log.isInfoEnabled()) {log.info("param ::: company ::: " + company);}
		if (log.isInfoEnabled()) {log.info("param ::: batch_month ::: " + batch_month);}
		if (log.isInfoEnabled()) {log.info("do service ::: salesEstimationBatchService.manualSalesBatchByCompany");}
		salesEstimationBatchService.manualSalesBatchByCompany(company, batch_month);
		if (log.isInfoEnabled()) {log.info("End TotalAjaxController.manualSalesBatchByCompany");}
	}
	
	/*
	 * @기능 salesResultListTotal.jsp 페이지에서 매출실적 목록 조회
	 * @param company 회사(IYCNC, IBTS, IYS)
	 * @param batch_month 배치년월 yyyymm
	 */
	@GetMapping("/salesResultTotal.ajax/company/{company}/batch_month/{batch_month}")
	public List<Map<String, Object>> retrieveSalesResultListByCompanyAndBatchMonth(@PathVariable String company, @PathVariable String batch_month) {
		return salesResultService.listByCompanyAndBatchMonth(company, batch_month);
	}
}