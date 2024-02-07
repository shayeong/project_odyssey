package com.model.tour;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.model.plan.TourlistServiceImpl")
public class TourlistServiceImpl implements TourlistService {

	@Autowired
	private TourlistMapper mapper;

	@Override
	public int addTourlist(TourlistDTO dto) {
		// TODO Auto-generated method stub
		return mapper.addTourlist(dto);
	}
}
