package com.controller;

import com.model.review.ReviewDTO;
import com.model.review.ReviewService;
import com.model.member.MemberDTO;
import com.utility.Utility;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewController {
    @Autowired
    @Qualifier("com.model.review.ReviewServiceImpl")
    private ReviewService service;


    @RequestMapping("/review/list")
    public String list(HttpServletRequest request ){
        String col = Utility.checkNull(request.getParameter("col"));
        String word = Utility.checkNull(request.getParameter("word"));

        if (col.equals("total")) {
            word = "";
        }

        int nowPage = 1;// 현재 보고있는 페이지
        if (request.getParameter("nowPage") != null) {
            nowPage = Integer.parseInt(request.getParameter("nowPage"));
        }
        int recordPerPage = 10;// 한페이지당 보여줄 레코드갯수

        int sno = (nowPage - 1) * recordPerPage;
        int eno = recordPerPage;

        Map map = new HashMap();
        map.put("col", col);
        map.put("word", word);
        map.put("sno", sno);
        map.put("eno", eno);

        int total = service.total(map);

        List<ReviewDTO> list = service.list(map);
        String url = "list";

        String paging = Utility.paging(total, nowPage, recordPerPage, col, word, url);

        // request에 Model사용 결과 담는다
        request.setAttribute("list", list);
        request.setAttribute("nowPage", nowPage);
        request.setAttribute("col", col);
        request.setAttribute("word", word);
        request.setAttribute("paging", paging);

        return "/review/list";
    }

    @GetMapping("/review/read")
    public String read(HttpServletRequest request){
        String col = Utility.checkNull(request.getParameter("col"));
        String word = Utility.checkNull(request.getParameter("word"));
        int nowPage = 1;
        if(request.getParameter("nowPage") != null)
        {
            nowPage = Integer.parseInt(request.getParameter("nowPage"));
        }

        int reviewno = Integer.parseInt(request.getParameter("reviewno"));

        ReviewDTO reviewDTO = service.read(reviewno);
        service.upViewcnt(reviewno);

        request.setAttribute("dto", reviewDTO);
        request.setAttribute("nowPage", nowPage);
        request.setAttribute("col", col);
        request.setAttribute("word", word);


        return "/review/read";
    }

    @PostMapping("/review/create")
    public String create(ReviewDTO dto){
        int createReview = service.create(dto);
        if(createReview > 0){
            return "redirect:/review/list";
        }
        return "error";
    }

    @PostMapping("/review/update")
    public String update(ReviewDTO dto){
        int updateReview = service.update(dto);
        if(updateReview > 0){
            return "redirect:/review/read?reviewno=" + dto.getReviewno();
        }
        return "error";
    }

    @GetMapping("/review/delete")
    public String delete(HttpServletRequest request){
        int reviewno = Integer.parseInt(request.getParameter("reviewno"));
        int deleteReview = service.delete(reviewno);
        if(deleteReview > 0){
            return "redirect:/review/list";
        }
        return "error";
    }
}
