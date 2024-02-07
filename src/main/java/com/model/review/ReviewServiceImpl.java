package com.model.review;

import com.model.review.ReviewDTO;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("com.model.review.ReviewServiceImpl")
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewMapper mapper;


    @Override
    public int total(Map map) {
        return mapper.total(map);
    }

    @Override
    public List<ReviewDTO> list(Map map) {
        return mapper.list(map);
    }

    @Override
    public ReviewDTO read(int noticeno) {
        return mapper.read(noticeno);
    }

    @Override
    public void upViewcnt(int reviewno) {
        mapper.upViewcnt(reviewno);
    }

    @Override
    public int create(ReviewDTO dto) {
        return mapper.create(dto);
    }

    @Override
    public int update(ReviewDTO dto) {
        return mapper.update(dto);
    }

    @Override
    public int delete(int reviewno) {
        return mapper.delete(reviewno);
    }
}