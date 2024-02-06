package com.controller;

import com.model.tour.TourlistDTO;
import com.model.tour.TourlistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TourlistController {

	@Autowired
	@Qualifier("com.model.tour.TourlistServiceImpl")
	private TourlistService service;

    @RequestMapping("/tour/lib.to")
    public String tourlist(HttpServletRequest request) {
        String command = request.getParameter("command");

        if ( command.equals("list") ) {
            return "/tour/list";

        } else if ( command.equals("tourlistdb") ) {
			int total = 0;

			System.out.println("AddTourlistAction 도착");
			String[] Tourlist = request.getParameterValues("list");

			List<TourlistDTO> tdtos = new ArrayList<TourlistDTO>();

			// System.out.println(Tourlist[143]);

			for( int i = 0; i < Tourlist.length; i++ ) {
				String[] tmp = Tourlist[i].split(";");
				System.out.println(Arrays.toString(tmp));
			
				TourlistDTO tdto = new TourlistDTO(tmp[0], Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2]), tmp[3], Integer.parseInt(tmp[4]), tmp[5], Double.parseDouble(tmp[6]), Double.parseDouble(tmp[7]));
				tdtos.add(tdto);
			}

			for( int i = 0; i < tdtos.size(); i++ ) {
				TourlistDTO tdto = tdtos.get(i);
				
				int cnt = service.addTourlist(tdto);

				total+=cnt;
			}

			System.out.println("총 Tourlist의 개수: " + tdtos.size());
			System.out.println("저장 성공한 개수: " +  total);

        }
		// 기본적으로는 에러 페이지 등으로 리다이렉트 또는 포워딩할 수 있습니다.
		return "/tour/insert_db"; // 에러 페이지 경로를 적절히 설정하세요.
    }

	@GetMapping("/tour/insert_db")
	public String tourlist_test() {

		return "/tour/insert_db";
	}
}
