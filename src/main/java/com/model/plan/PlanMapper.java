package com.model.plan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public interface PlanMapper {
    List<PlanDTO> planMakelist(Map map);

    List<PlanDTO> planMakelist_a(int areacode);
}
