package com.iyf.salesledger.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SalesEstimationDao {

	List<Map<String, Object>> listByCompanyAndDepartmentAndBatchMonth(@Param("company") String company, @Param("department") String department, @Param("batch_month") String batch_month);
	
	//회사별 전체 추정
	List<Map<String, Object>> listByCompanyAndBatchMonth(@Param("company") String company, @Param("batch_month") String batch_month);

}
