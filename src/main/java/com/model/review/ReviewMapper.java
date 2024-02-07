package com.model.review;

import com.model.review.ReviewDTO;

import java.util.List;
import java.util.Map;

public interface ReviewMapper {
    int total(Map map);

    List<ReviewDTO> list(Map map);
    ReviewDTO read(int reviewno);

    void upViewcnt(int reviewno);
    int create(ReviewDTO dto);
    int update(ReviewDTO dto);
    int delete(int reviewno);
}
