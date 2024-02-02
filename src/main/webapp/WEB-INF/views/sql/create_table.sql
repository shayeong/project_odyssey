use odyssey;

CREATE TABLE planner
( 
	plan_no              varchar(20)  NOT NULL ,
	region               varchar(20)  NOT NULL ,
	plan_img             varchar(100)  NULL ,
	sdate                datetime  NOT NULL ,
	edate                datetime  NOT NULL ,
	PRIMARY KEY  CLUSTERED (plan_no ASC)
);

CREATE TABLE member
( 
	email                varchar(20)  NULL ,
	passwd               varchar(20)  NOT NULL ,
	mname                varchar(20)  NOT NULL ,
	address1             varchar(200)  NULL ,
	mdate                DATE  NOT NULL ,
	id                   varchar(10)  NOT NULL ,
	address2             varchar(100)  NULL ,
	tel                  varchar(20)  NOT NULL ,
	fname                char(18)  NULL ,
	grade                varchar(3)  NULL	DEFAULT  'H',
	zipcode              varchar(10)  NULL ,
	PRIMARY KEY  CLUSTERED (id ASC)
);

CREATE TABLE tourlist
( 
	tour_titile          varchar(30)  NULL ,
	addr                 varchar(30)  NOT NULL ,
	areacode             varchar(10)  NOT NULL ,
	sigungucode          varchar(10)  NOT NULL ,
	tour_img             varchar(100)  NULL ,
	readcount            integer  NOT NULL ,
	ping                 integer  NULL ,
	tour_no              char(18)  NOT NULL ,
	PRIMARY KEY  CLUSTERED (tour_no ASC)
);

CREATE TABLE planner_detail
( 
	plan_name            varchar(20)  NULL ,
	wdate                datetime  NOT NULL ,
	memo                 varchar(1000)  NULL ,
	plan_no              varchar(20)  NOT NULL ,
	plandetail_no        char(18)  NOT NULL ,
	id                   varchar(10)  NULL ,
	tour_no              char(18)  NULL ,
	PRIMARY KEY  CLUSTERED (plandetail_no ASC),
	 FOREIGN KEY (plan_no) REFERENCES planner(plan_no),
	 FOREIGN KEY (id) REFERENCES member(id),
	 FOREIGN KEY (tour_no) REFERENCES tourlist(tour_no)
);

CREATE TABLE share_board
( 
	review               varchar(100)  NULL ,
	rating               integer  NOT NULL ,
	share_no             char(18)  NOT NULL ,
	plandetail_no        char(18)  NOT NULL ,
	id                   varchar(10)  NULL ,
	PRIMARY KEY  CLUSTERED (share_no ASC),
	 FOREIGN KEY (plandetail_no) REFERENCES planner_detail(plandetail_no),
	 FOREIGN KEY (id) REFERENCES member(id)
);
drop table if exists notice;
CREATE TABLE notice(
  noticeno      INT                        NOT NULL AUTO_INCREMENT COMMENT '글 번호',
  title             VARCHAR(300)         NOT NULL COMMENT '제목',
  content       TEXT                       NOT NULL COMMENT '내용',
  id        VARCHAR (20)           NOT NULL COMMENT 'id',
  passwd               varchar(20)  NOT NULL ,
  cnt             SMALLINT                 NOT NULL DEFAULT '0' COMMENT '조회수',
  rdate          DATETIME                  NOT NULL COMMENT '등록일',
  PRIMARY KEY (noticeno)  
);                            
 
-- 등록
INSERT INTO notice(title, content, id, passwd, cnt, rdate)
VALUES('1', '1', '1',  "1", 0, NOW());
