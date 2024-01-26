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
	member_name          varchar(20)  NOT NULL ,
	birth                integer  NULL ,
	addr                 varchar(100)  NOT NULL ,
	phone_num            varchar(20)  NOT NULL ,
	mem_no               char(18)  NOT NULL ,
	member_img           char(18)  NULL ,
	PRIMARY KEY  CLUSTERED (mem_no ASC)
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
	mem_no               char(18)  NULL ,
	tour_no              char(18)  NULL ,
	PRIMARY KEY  CLUSTERED (plandetail_no ASC),
	 FOREIGN KEY (plan_no) REFERENCES planner(plan_no),
	 FOREIGN KEY (mem_no) REFERENCES member(mem_no),
	 FOREIGN KEY (tour_no) REFERENCES tourlist(tour_no)
);


CREATE TABLE share_board
( 
	review               varchar(100)  NULL ,
	rating               integer  NOT NULL ,
	share_no             char(18)  NOT NULL ,
	plandetail_no        char(18)  NOT NULL ,
	mem_no               char(18)  NULL ,
	PRIMARY KEY  CLUSTERED (share_no ASC),
	 FOREIGN KEY (plandetail_no) REFERENCES planner_detail(plandetail_no),
	 FOREIGN KEY (mem_no) REFERENCES member(mem_no)
);
