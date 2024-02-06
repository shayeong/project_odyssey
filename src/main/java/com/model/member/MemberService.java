package com.model.member;

import java.util.List;
import java.util.Map;

public interface MemberService {
	int duplicatedId(String id);
	int duplicatedEmail(String email);
	int create(MemberDTO dto);
	int loginCheck(Map<String,String> map);
	Map<String,String> getGrade(String id);
	int total(Map map);
	List<MemberDTO> list(Map map);
	MemberDTO read(String id);
	int update(MemberDTO dto);
    int updateFile(Map map);
	String getId(Map<String, String> info);
    String getPasswd(Map<String, String> info);
	MemberDTO mypage(String id);
}
