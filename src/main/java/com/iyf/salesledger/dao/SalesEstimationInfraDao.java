package com.iyf.salesledger.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.iyf.salesledger.common.batch.model.SalesEstimationInfra;

public interface SalesEstimationInfraDao {

	List<Map<String, Object>> listByCompanyAndDepartmentAndCategoryAndBatchMonth(@Param("company") String company, @Param("department") String department, @Param("category") String category, @Param("batch_month") String batch_month);

	void insert(SalesEstimationInfra salesEstimationInfra);

	Map<String, Object> selectOne(long sales_estimation_infra_id);

	void delete(long sales_estimation_infra_id);

	void update(SalesEstimationInfra salesEstimationInfra);
}
