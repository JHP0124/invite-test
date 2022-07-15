<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 목록</title>
</head>
<body>
<center>

<h3>게시글 목록</h3>

<br><hr><br>

<table border="1" width="700">
<tr>
	<th width="100">번호</th>
	<th width="200">제목</th>
	<th width="150">작성자</th>
</tr>
 
<c:forEach var="board" items="${boardList}">
	<tr>
		<td>${board.seq}</td>
		<td align="left"><a href="getBoard?seq=${board.seq}">${board.title}</a></td>
		<td>${board.writer}</td>		
	</tr>
</c:forEach>

</table>
<br>
<a href="insertBoard.html">게시글 등록</a>
</center>
</body>
</html>
