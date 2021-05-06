<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf8">
<title>Insert title here</title>

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.3.2/jquery-migrate.min.js"></script>
<link rel="stylesheet" href="/resources/css/swipe.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">

<style>
	.thumbImg {
	}

</style>

<!--fontawesome ---->
<script src="https://kit.fontawesome.com/dc299fac74.js" crossorigin="anonymous"></script>
<style>
	img {
		width: 200px;
		height: 200px;	
	}
</style>
</head>

	<script type="text/javascript">
		$(document).ready(function(){
			
		
		var msg = '${msg}';
        if (msg.length > 0) {
            alert(msg);
        }		
	})
	</script>
<body>
	
		<nav class="navbar">
        <a class="fas fa-fire" href="#"></a> <!-- 누르기 기능 삭제 -->
		<a class="fas fa-comments" href="/chat/rooms"></a>
        <a class="fas fa-user" href="/profile/info?email=${member.email}"></a>
    </nav>

     <table class="type09">
                        <thead>
                            <tr>
                                <th scope="cols">NickName</th>
                                <th scope="cols">age</th>

                                <th scope="cols">gender</th>
                                <th scope="cols">zone</th>
                                <th scope="cols">image</th>
                                <th scope="cols">hobby1</th>
                                <th scope="cols">hobby2</th>
                                <th scope="cols">hobby3</th>
                            </tr>
                        </thead>
                        <tbody id="list">
                            <c:forEach items="${LIST}" var="li">
                                <tr>
                                    <td>${li.nickname}</td>
                                    <td>${li.age}</td>
                                    <td>${li.gender}</td>
                                    <td>${li.zone}</td>
                                    <td><a href="/profile/infoThem?email=${li.email}"><img src="${li.imageRoot}"></a></td>
                                    <td>${li.hobby1}</td>
                                    <td>${li.hobby2}</td>
                                    <td>${li.hobby3}</td>
                      
                                    

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
		
	<!--<c:if test="${member != null}">
        <div>
            <p>${member.email}님 환영합니다.</p>
     </div>
     </c:if>-->
     
     
     
</body>
</html>