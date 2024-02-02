<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
    <style>
        body{
            font-family: 'Noto Sans KR', sans-serif;
        }
        .notice-title-a{
            text-decoration: none;
            color: black;
        }
    </style>
    <script>
        function read(noticeno){
            let url = "/notice/read";
            url +="?nowPage=${nowPage}";
            url +="&col=${col}";
            url +="&word=${word}";
            url +="&noticeno="+noticeno;
            location.href=url;
        }

    </script>
</head>
</head>
<body>
<div class="container mt-5">
    <div class="d-flex justify-content-between align-items-center" style="margin-top: 150px">
        <div>
            <h2>게시판</h2>
        </div>
        <form action="/notice/list" class="d-flex">
            <div class="row">
                <div class='col'>
                    <select class="form-select" name="col">
                        <option
                                <c:if test="${col == 'id'}">
                                    selected
                                </c:if>
                                value="id">작성자</option>
                        <option
                                <c:if test="${col == 'title'}">
                                    selected
                                </c:if>
                                value="title">제목</option>
                        <option
                                <c:if test="${col == 'content'}">
                                    selected
                                </c:if>
                                value="content">내용</option>
                        <option
                                <c:if test="${col == 'title_content'}">
                                    selected
                                </c:if>
                                value="title_content" >제목+내용</option>
                        <option
                                <c:if test="${col == 'total'}">
                                    selected
                                 </c:if>
                                value="total" >전체출력</option>
                    </select>
                </div>
                <div class="col">
                    <input type="search" class="form-control" name="word" required="required" value="${word}">

                </div>
                <div class='col'>
                    <button type="submit" class="btn btn-dark">검색</button>
                    <button type="button" class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#myModal">등록</button>
                    <c:if test="${sessionScope.grade == 'H'}">
                        <button type="button" class="btn btn-dark" data-bs-toggle="modal" data-bs-target="#myModal">등록</button>
                    </c:if>

                </div>
            </div>

        </form>
    </div>

    <div class="container mt-5 ">
        <!-- <h2>게시판</h2> -->

        <table class="table table-hover">
            <!--<table class="table table-striped table-hover">-->

            <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>날짜</th>
                <th>조회수</th>
            </tr>
            </thead>

            <tbody class="contents "  >

            <c:forEach var="dto" items="${list}" varStatus="status">

                <c:choose>
                    <c:when test="${empty dto}">
                        <tr> <td colspan="5"> 등록된 글이 없습니다. </td></tr>
                    </c:when>
                    <c:otherwise>
                        <tr>
                        <td> ${fn:length(list) - status.index}</td>

                        <td>    <a class="notice-title-a" href="javascript:read(${dto.noticeno})">${dto.title}</a>
                        </td>
                        <td> ${dto.id}</td>
                        <td> ${dto.rdate}</td>
                        <td> ${dto.cnt}</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            </tbody>
        </table>
        ${paging}
    </div>
</div>

</body>
</html>
