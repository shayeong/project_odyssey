package com.model.plan;

import java.util.HashMap;
import java.util.List;

public interface PlanMakeService {
    List<PlanMakeDTO> getPlanMakeList(int areacode, int sigungucode);

    List<PlanMakeDTO> getPlanMakeListByAreaCode(int areacode);
}
