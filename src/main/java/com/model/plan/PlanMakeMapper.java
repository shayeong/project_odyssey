package com.model.plan;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface PlanMakeMapper {
    List<PlanMakeDTO> getPlanMakeList(int areacode, int sigungucode);

    List<PlanMakeDTO> getPlanMakeListByAreaCode(int areacode);
}
