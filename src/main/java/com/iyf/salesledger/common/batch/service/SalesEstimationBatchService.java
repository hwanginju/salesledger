package com.iyf.salesledger.common.batch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iyf.salesledger.common.batch.dao.SalesEstimationBatchDao;

@Service
public class SalesEstimationBatchService {

	@Autowired
	private SalesEstimationBatchDao salesEstimationBatchDao;
	
	@Transactional
	public void monthlySalesBatchByCompanyAndDepartment(String company, String department) {
		salesEstimationBatchDao.delete(company, department);
		salesEstimationBatchDao.insert(company, department);
	}

	@Transactional
	public void manualSalesBatchByCompanyAndDepartment(String company, String department, String batch_month) {
		salesEstimationBatchDao.deleteManual(company, department, batch_month);
		salesEstimationBatchDao.insertManual(company, department, batch_month);
	}
	
	@Transactional
	public void manualSalesBatchByCompany(String company, String batch_month) {
		salesEstimationBatchDao.deleteTotalManual(company, batch_month);
		salesEstimationBatchDao.insertTotalManual(company, batch_month);
	}

}
