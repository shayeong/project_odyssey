package com.model.plan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.model.plan.PlanServiceImpl")
public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlanMapper mapper;

	@Override
	public List<PlanDTO> planMakelist(Map map) {
		// TODO Auto-generated method stub
		return mapper.planMakelist(map);
	}

	@Override
	public List<PlanDTO> planMakelist_a(int areacode) {
		// TODO Auto-generated method stub
		return mapper.planMakelist_a(areacode);
	}
}
