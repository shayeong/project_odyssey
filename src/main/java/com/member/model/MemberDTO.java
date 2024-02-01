package com.member.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberDTO {
    private String id       ; 
    private String passwd   ;
    private String mname    ;
    private String tel      ;
    private String email    ;
    private String zipcode  ;
    private String address1 ;
    private String address2 ;
    private String mdate    ;
    private String fname    ;
    private String grade    ;
    private MultipartFile fnameMF;
}
