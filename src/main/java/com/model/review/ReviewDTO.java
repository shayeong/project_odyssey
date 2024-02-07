package com.model.review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder

@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
   private int reviewno  ;
   private String title  ;
   private String content;
   private String id     ;
   private int cnt       ;
   private String rdate  ;
};

