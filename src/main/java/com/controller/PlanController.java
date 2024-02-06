package com.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.plan.PlanDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.plan.PlanService;

@Controller
public class PlanController {

	@Autowired
	@Qualifier("com.model.plan.PlanServiceImpl")
	private PlanService service;

    @GetMapping("/PlanMakeAction.pl")
    public String makePlan(HttpServletRequest request) {
        
		// return "make_plan"; // 뷰 이름 반환
		
		List<PlanDTO> planmakelist = null;
		String region = request.getParameter("region");
		System.out.println("region : " + region);
		
		int areacode = 0;
		int sigungucode = 0;

		Map map = new HashMap();
		
		switch (region) {
			case "chuncheon":
				areacode = 32;
				sigungucode = 13;
				map.put("areacode", areacode);
				map.put("sigungucode", sigungucode);
				planmakelist = service.planMakelist(map);
				break;
				
			case "busan":
				areacode = 6;
				planmakelist = service.planMakelist_a(areacode);
				break;
				
			case "daegu":
				areacode = 4;
				planmakelist = service.planMakelist_a(areacode);
				break;
				
			case "gangneung":
				areacode = 32;
				sigungucode = 1;
				map.put("areacode", areacode);
				map.put("sigungucode", sigungucode);
				planmakelist = service.planMakelist(map);
				break;
				
			case "gyeongju":
				areacode = 35;
				sigungucode = 2;
				map.put("areacode", areacode);
				map.put("sigungucode", sigungucode);
				planmakelist = service.planMakelist(map);
				break;
				
			case "incheon":
				areacode = 2;
				planmakelist = service.planMakelist_a(areacode);
				break;
				
			case "jeju":
				areacode = 39;
				planmakelist = service.planMakelist_a(areacode);
				break;
				
			case "jeonju":
				areacode = 37;
				sigungucode = 12;
				map.put("areacode", areacode);
				map.put("sigungucode", sigungucode);
				planmakelist = service.planMakelist(map);
				break;
				
			case "seoul":
				areacode = 1;
				planmakelist = service.planMakelist_a(areacode);
				break;
				
			case "sokcho":
				areacode = 32;
				sigungucode = 5;
				map.put("areacode", areacode);
				map.put("sigungucode", sigungucode);
				planmakelist = service.planMakelist(map);
				break;
				
			case "yeongwol":
				areacode = 32;
				sigungucode = 8;
				map.put("areacode", areacode);
				map.put("sigungucode", sigungucode);
				planmakelist = service.planMakelist(map);
				break;
				
			case "yeosu":
				areacode = 38;
				sigungucode = 13;
				map.put("areacode", areacode);
				map.put("sigungucode", sigungucode);
				planmakelist = service.planMakelist(map);
				break;
		}
		
		System.out.println("areacode : " + areacode);
		System.out.println("sigungucode : " + sigungucode);
		
		request.setAttribute("planmakelist", planmakelist);
		
		return "/plan/make";
	}

	@Async
	@PostMapping("/PlanSave.pl")
    public Future<ResponseEntity<String>> asyncSavePlan(@RequestBody String groupedData) {
        // 비동기로 처리할 작업 수행
        System.out.println("Received groupedData asynchronously: " + groupedData);

		try {
            ObjectMapper objectMapper = new ObjectMapper();

            // 각 항목의 필요한 값을 추출하여 리스트에 저장
            List<String> valueDayList = new ArrayList<>();
            List<String> textTitleList = new ArrayList<>();
            List<String> memoList = new ArrayList<>();

			// JSON 문자열을 List<Map<String, String>>으로 파싱
			List<Map<String, String>> dataList = objectMapper.readValue(groupedData, new TypeReference<List<Map<String, String>>>() {});

			// 파싱된 데이터 출력
			for (Map<String, String> data : dataList) {
				valueDayList.add(data.get("value_day"));
				textTitleList.add(data.get("text_title"));
				memoList.add(data.get("memo"));
			}
			
			System.out.println(valueDayList);
			System.out.println(textTitleList);
			System.out.println(memoList);

			System.out.println(memoList.get(0));


            // for (JsonNode jsonNode : jsonArray) {
            //     valueDayList.add(jsonNode.get("value_day").asText());
            //     textTitleList.add(jsonNode.get("text_title").asText());
            //     memoList.add(jsonNode.get("memo").asText());
            // }

            // 결과 출력
            System.out.println("value_day: " + valueDayList);
            System.out.println("text_title: " + textTitleList);
            System.out.println("memo: " + memoList);

			System.out.println(memoList.get(0));

        } catch (Exception e) {
            e.printStackTrace();
        }
		

        // 작업이 완료되면 성공 응답 반환
        return new AsyncResult<>(ResponseEntity.ok("Success"));
    }
}
