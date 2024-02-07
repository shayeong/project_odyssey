<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <script>
        function list(){
            let url  ="/notice/list";
            url +="?nowPage=${nowPage}";
            url +="&col=${col}";
            url +="&word=${word}";

            location.href=url;
        }


        function delete_url(noticeno){
            let url  ="/notice/delete";
            url +="?noticeno="+noticeno;

            if (confirm("정말 삭제하시겠습니까?")){
                location.href=url;
            }

        }
    </script>
    <style>
        body{
            font-family: 'Noto Sans KR', sans-serif;
        }
        .card-header{
            padding: 15px;
            font-size: 20px;
            font-weight: 700;
        }
        .textarea{
            margin: 30px;
        }
        .footer-buttons{
            margin-left: 5px;
        }
    </style>
</head>
<body>
<div class="container mt-5"  style="">
    <div class="card" style="width: 100%; margin-top: 150px;">
        <div class="card-header">
            ${dto.title}
        </div>
        <div class="textarea">${dto.content}</div>

        <div class="card-footer d-flex justify-content-between">
            <div >작성자 : ${dto.id} | 등록일 : ${dto.rdate} | 조회수 : ${dto.cnt}</div>

            <div>
            </div>
        </div>
        <div class="card-footer d-flex flex-row-reverse ">
                <c:if test="${sessionScope.grade == 'H' && sessionScope.mname == dto.id}">
                    <button class="btn btn-outline-dark footer-buttons" onclick="delete_url(${dto.noticeno})">삭제</button>
                    <button class="btn btn-outline-dark footer-buttons" data-toggle="modal" data-target="#updateModal" >수정</button>
                </c:if>
            <button class="btn btn-outline-dark footer-buttons" onclick="list()">목록</button>
        </div>
    </div>
</div>

<script>
    $(function() {
        CKEDITOR.replace('content'); // <TEXTAREA>태그 id 값
    });
    function checkModal(f){
        if (f.title.value == ""){
            alert("제목을 입력하세요");
            f.title.focus()
            return false;
        }
        if (f.content.value == ""){
            alert("내용을 입력하세요");
            f.content.focus()
            return false;
        }
    }
</script>

<div class="modal" id="updateModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">게시판 수정</h4>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <form action="/notice/update" method="post" id="update" onsubmit="return checkModal(this)">
                    <input type="hidden" name="noticeno" value="${dto.noticeno}">
                    <div class="modal-body-fir mb-3 d-flex justify-content-between">
                        <div class="input-group me-5">
                            <span class="input-group-text">제목</span>
                            <input type="text" class="form-control " value="${dto.title}" name="title">
                        </div>
                        <div class="input-group">
                            <span class="input-group-text">이름</span>
                            <input type="text" class="form-control" placeholder="id" name="id" value="${sessionScope.mname}"  readonly>
                        </div>
                    </div>
                    <div class="mb-3 mt-3 " style="">
                        <label for="content">내용</label>
                        <div class="" style="height: auto">
                            <textarea class="form-control " rows="5" cols="3" id="content" name="content" style="height:500px">${dto.content}</textarea>
                        </div>
                    </div>
                </form>
            </div>
            <!-- Modal footer -->
            <div class="modal-footer">

                <div class="input-group d-flex flex-row-reverse">

                    <div>
                        <button type="submit" form="update" class="btn text-danger">수정</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>
