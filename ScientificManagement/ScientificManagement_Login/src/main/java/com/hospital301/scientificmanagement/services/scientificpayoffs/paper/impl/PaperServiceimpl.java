package com.hospital301.scientificmanagement.services.scientificpayoffs.paper.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hospital301.scientificmanagement.dao.scientificpayoffs.paper.ProjectPaperMapper;
import com.hospital301.scientificmanagement.services.BaseServiceImpl;
import com.hospital301.scientificmanagement.services.scientificpayoffs.paper.PaperService;

@Service
public class PaperServiceimpl extends BaseServiceImpl implements PaperService {

	@Autowired
	private ProjectPaperMapper paperdao;
	
	@Override
	public Map QueryTableInfo(Map<String, Object> map) {
		Map<String,Object> resultMap = new HashMap<>();
		List list = paperdao.getPaperList(map);
		Integer total = paperdao.getPaperListTotal(map);
		resultMap.put("page", list);
		resultMap.put("total", total);
		return map;
	}
}
