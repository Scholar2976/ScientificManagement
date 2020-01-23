package com.hospital301.scientificmanagement.services.role.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.RowSetListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.ccb.sm.response.ResponsePage;
import com.hospital301.scientificmanagement.dao.role.RoleMapper;
import com.hospital301.scientificmanagement.services.role.RoleService;

/**
 * @author 作者
 * @version 创建时间：2020年1月20日 下午2:33:17 类说明
 */
@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleMapper relodao;
	
	@Override
	public Object QueryTableInfoByPage(Map<String, Object> conditionMap) throws Exception {

		List<List<?>> daolist = relodao.getRoleResultByPageAndCount(conditionMap);
		if (daolist.size() > 0) {
			List list = daolist.get(0);
			Integer total = (Integer) daolist.get(1).get(0);
			Map resultMap = new HashMap<>();

			resultMap.put("page", list);
			resultMap.put("total", total);
			return Format(resultMap);
		} else {
			return null;
		}

	}
	
	private Object Format(Map<String,Object> resultMap)
	{
		Map countmap = new HashMap();
		countmap.put("totalRec", resultMap.get("total"));
		ResponsePage rspage = new ResponsePage();
		rspage.setList(resultMap.get("page"));
		rspage.setTxnCommCom(countmap);
		return rspage;
	}

}
