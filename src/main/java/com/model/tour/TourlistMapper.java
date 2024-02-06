package com.model.tour;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface TourlistMapper {
    int addTourlist(TourlistDTO dto);
}
