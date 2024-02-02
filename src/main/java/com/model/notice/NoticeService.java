package com.model.notice;

import com.model.member.MemberDTO;
import java.util.List;
import java.util.Map;

public interface NoticeService {
    int total(Map map);

    List<MemberDTO> list(Map map);

    NoticeDTO read(int noticeno);

    void upViewcnt(int noticeno);

    int create(NoticeDTO dto);

    int update(NoticeDTO dto);

    int delete(int noticeno);
}
