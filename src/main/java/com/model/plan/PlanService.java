package com.model.plan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PlanService {
    List<PlanDTO> planMakelist(Map map);

    List<PlanDTO> planMakelist_a(int areacode);
}
