package com.model.plan;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.model.plan.PlanMakeServiceImpl")
public class PlanMakeServiceImpl implements PlanMakeService {

	@Autowired
	private PlanMakeMapper mapper;

	@Override
	public List<PlanMakeDTO> getPlanMakeList(int areacode, int sigungucode) {
		// TODO Auto-generated method stub
		return mapper.getPlanMakeList(areacode, sigungucode);
	}

	@Override
	public List<PlanMakeDTO> getPlanMakeListByAreaCode(int areacode) {
		// TODO Auto-generated method stub
		return mapper.getPlanMakeListByAreaCode(areacode);
	}
}
