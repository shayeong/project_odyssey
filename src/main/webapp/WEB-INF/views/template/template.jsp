<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:getAsString name="title"/></title>
    <!-- Bootstrap CSS link -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.0.0-beta2/css/bootstrap.min.css">
<style>
    body {
        display: flex;
        min-height: 100vh;
        margin: 0;
        flex-direction: column; /* 세로로 쌓기 위해 column으로 변경 */
    }

    .container-fluid {
        display: flex;
        flex: 1;
        flex-direction: column; /* 세로로 쌓기 위해 column으로 변경 */
        position: relative;
    }

    .navbar,
    .main-content,
    .bottombar {
        width: 100%;
    }

    .navbar {
        top: 0; /* 상단에 고정되도록 설정 */
        position: fixed;
    }

    .main-content {
        flex: 1;
        padding: 15px;
        margin-bottom: 150px;
    }

    .bottombar {
        position: absolute;
        bottom: 0; /* 하단에 고정되도록 설정 */
    }
</style>
</head>

<body>

<div class="container-fluid">

    <!-- Nabar -->
    <div class="navbar">
        <!-- 상단 메뉴 -->
        <tiles:insertAttribute name="header"/>
        <!-- 상단 메뉴 끝 -->
    </div>
    
	 <!-- Main Content -->
   	 <div class="main-content">
     	<!-- 내용 시작 -->
        <tiles:insertAttribute name="body"/>       													
        <!-- 내용 끝 -->
    </div>    
    
	<div class="bottombar">
        <!-- 내용 시작 -->
        <tiles:insertAttribute name="bottom"/>       													
        <!-- 내용 끝 -->
    </div>
</div>

<!-- Bootstrap JS and Popper.js scripts -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/5.0.0-beta2/js/bootstrap.min.js"></script>

</body>
</html>