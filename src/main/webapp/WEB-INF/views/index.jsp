<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  	
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Insert title here</title>
<style type="text/css">@import url("../contents.css");</style>

<!-- 부트스트랩 -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<style>
@font-face {
	font-family: 'SUIT-Medium';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_suit@1.0/SUIT-Medium.woff2')
		format('woff2');
	font-weight: normal;
	font-style: normal;
}

@font-face {
	font-family: 'SUIT-Bold';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_suit@1.0/SUIT-Bold.woff2')
		format('woff2');
	font-weight: normal;
	font-style: normal;
}

.container {
	margin-top: 90px;
 	margin-bottom: 150px;
}

.carousel-inner>.carousel-item>img {
	width: 100%;
	height: 700px;
}

.search_ex {
	text-align: center;
}

#search{
	width: 500px;
}


</style>
</head>
<body>
	
	<!-- carousel 시작 -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script>
		$('.carousel').carousel({
			interval : 2000
		//기본 5초
		})
	</script>
	<div class="all">
	<div class="container">
		<div id="demo" class="carousel slide" data-ride="carousel">
			<div class="carousel-inner">


                <ul class="list-unstyled ps-0 mt-auto">

                    <li class="mb-1">
                        <a href="${root}/board/board" class="btn btn-primary w-100"><i
                                class="fa-solid fa-user-plus"></i> Sign Up</a>
                    </li>

                </ul>


			</div>
		</div>
	</div>
	<!-- carousel 끝 -->
	
	

	<!-- 이미지 시작 -->
	<div class="mx-auto banner mt-5 mb-5 text-center">
		<a href="https://tour.jeonju.go.kr/index.jeonju#content" class="text-decoration-none">   
			<img src="${pageContext.request.contextPath }/images/side_banner1.PNG" width="150" height="150"  alt="전주여행" class="img-responsive center-block">
		</a> 
		<a href="https://www.visitjeju.net/kr/" class="text-decoration-none">         
			<img src="${pageContext.request.contextPath }/images/side_banner2.PNG" width="150" height="150"  alt="제주도여행" class="img-responsive center-block">
		</a> 
		<a href="https://www.airbnb.co.kr/" class="text-decoration-none">         
			<img src="${pageContext.request.contextPath }/images/side_banner3.PNG" width="150" height="150"  alt="에어비앤비" class="img-responsive center-block">
		</a>
	</div>

	<!-- 이미지 끝 -->

	<!-- 검색바 시작 -->
	<form action="https://www.google.com/search" method="GET">
		<div class="mx-auto search_ex mt-5 mb-3"
			style="font-family: 'SUIT-Medium'">
			<h2>
				<b>나만의 여행 플래너 오디세이!</b>
			</h2>
			<h5>
				<b>떠나고 싶은 지역을 검색하세요.</b>
			</h5>
		</div>
	
		<div class="mx-auto mt-5 search-bar input-group mb-3"
			style="font-family: 'SUIT-Medium'" id="search">
			<input onkeyup="filter()" id="serchinput" type="text" name="query" value="" class="form-control rounded-pill" placeholder="여행지를 입력하세요. ex)여수, 춘천 등"> 
		</div>
	</form>

	<!-- 검색바 끝 -->

	<!-- area_List -->
	
		<div class="container">
			<div class="row">
				<div class="col-12 col-md-6 col-lg-4 col-xl-3">
					<a href="/PlanMakeAction.pl?region=seoul" class="area">
						<img src="${pageContext.request.contextPath }/contents_img/seoul.jpg" width="100%" class="area-img" height="240px">
						
						<div class="area-text">
							<h3>SEOUL</h3>
							<span class="subtitle-text">서울</span>
						</div>
					</a>
				</div>
				
				<div class="col-12 col-md-6 col-lg-4 col-xl-3">
					<a href="/PlanMakeAction.pl?region=busan" class="area">
						<img src="${pageContext.request.contextPath }/contents_img/busan.PNG" width="100%" class="area-img" height="240px">
						
						<div class="area-text">
							<h3>BUSAN</h3>
							<span class="subtitle-text">부산</span>
						</div>
					</a>
				</div>
				
				<div class="col-12 col-md-6 col-lg-4 col-xl-3">
					<a href="/PlanMakeAction.pl?region=jeju" class="area">
						<img src="${pageContext.request.contextPath }/contents_img/jeju.PNG" width="100%" class="area-img" height="240px">
						
						<div class="area-text">
							<h3>JEJU</h3>
							<span class="subtitle-text">제주도</span>
						</div>
					</a>
				</div>
				
				<div class="col-12 col-md-6 col-lg-4 col-xl-3">
					<a href="/PlanMakeAction.pl?region=gangneung" class="area">
						<img src="${pageContext.request.contextPath }/contents_img/gangneung.PNG" width="100%" class="area-img" height="240px">
						
						<div class="area-text">
							<h3>GANGNEUNG</h3>
							<span class="subtitle-text">강릉</span>
						</div>
					</a>
				</div>
				
				<div class="col-12 col-md-6 col-lg-4 col-xl-3">
					<a href="/PlanMakeAction.pl?region=gyeongju" class="area">
						<img src="${pageContext.request.contextPath }/contents_img/gyeongju.PNG" width="100%" class="area-img" height="240px">
						
						<div class="area-text">
							<h3>GYEONGJU</h3>
							<span class="subtitle-text">경주</span>
						</div>
					</a>
				</div>
				
				<div class="col-12 col-md-6 col-lg-4 col-xl-3">
					<a href="/PlanMakeAction.pl?region=yeongwol" class="area">
						<img src="${pageContext.request.contextPath }/contents_img/Yeongwol.jpg" width="100%" class="area-img" height="240px">
						
						<div class="area-text">
							<h3>YEONGWOL</h3>
							<span class="subtitle-text">영월</span>
						</div>
					</a>
				</div>
				
				<div class="col-12 col-md-6 col-lg-4 col-xl-3">
					<a href="/PlanMakeAction.pl?region=jeonju" class="area">
						<img src="${pageContext.request.contextPath }/contents_img/jeonju.PNG" width="100%" class="area-img" height="240px">
						
						<div class="area-text">
							<h3>JEONJU</h3>
							<span class="subtitle-text">전주</span>
						</div>
					</a>
				</div>
				
				<div class="col-12 col-md-6 col-lg-4 col-xl-3">
					<a href="/PlanMakeAction.pl?region=yeosu" class="area">
						<img src="${pageContext.request.contextPath }/contents_img/Yeosu.PNG" width="100%" class="area-img" height="240px">
						
						<div class="area-text">
							<h3>YEOSU</h3>
							<span class="subtitle-text">여수</span>
						</div>
					</a>
				</div>
				
				<div class="col-12 col-md-6 col-lg-4 col-xl-3">
					<a href="/PlanMakeAction.pl?region=incheon" class="area">
						<img src="${pageContext.request.contextPath }/contents_img/Incheon.jpg" width="100%" class="area-img" height="240px">
						
						<div class="area-text">
							<h3>INCHEON</h3>
							<span class="subtitle-text">인천</span>
						</div>
					</a>
				</div>
				
				<div class="col-12 col-md-6 col-lg-4 col-xl-3">
					<a href="/PlanMakeAction.pl?region=sokcho" class="area">
						<img src="${pageContext.request.contextPath }/contents_img/Sokcho.jpg" width="100%" class="area-img" height="240px">
						
						<div class="area-text">
							<h3>SOKCHO</h3>
							<span class="subtitle-text">속초</span>
						</div>
					</a>
				</div>
				
				<div class="col-12 col-md-6 col-lg-4 col-xl-3">
					<a href="/PlanMakeAction.pl?region=daegu" class="area">
						<img src="${pageContext.request.contextPath }/contents_img/Daegu.jpg" width="100%" class="area-img" height="240px">
						
						<div class="area-text">
							<h3>DAEGU</h3>
							<span class="subtitle-text">대구</span>
						</div>
					</a>
				</div>
				
				<div class="col-12 col-md-6 col-lg-4 col-xl-3">
					<a href="/PlanMakeAction.pl?region=chuncheon" class="area">
						<img src="${pageContext.request.contextPath }/contents_img/Chuncheon.jpg" width="100%" class="area-img" height="240px">
						
						<div class="area-text">
							<h3>CHUNCHEON</h3>
							<span class="subtitle-text">춘천</span>
						</div>
					</a>
				</div>
				
				</div>
			</div>
		</div>
	
	
	<!-- 검색기능 -->
	<script type="text/javascript">
    	
    $(".area").on("click",function() {
    	if(window.location.pathname != "/login/userloginOk.lo"){
			alert("로그인 후 사용가능합니다."),location.href="/";
			return false;
    }
	});
	</script>
	<!-- 부트스트랩 -->
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
</body>
</html>