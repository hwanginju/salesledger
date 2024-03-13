package com.iyf.salesledger.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyf.salesledger.dao.EmpStatusDao;

@Service
public class EmpStatusService {
	
	@Autowired
	private EmpStatusDao empStatusDao;

	public List<Map<String, Object>> list() {
		return empStatusDao.list();
	}

}

